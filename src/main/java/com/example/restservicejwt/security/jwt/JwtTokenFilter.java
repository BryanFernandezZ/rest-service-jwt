package com.example.restservicejwt.security.jwt;

import com.example.restservicejwt.security.UserDetailService;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtTokenFilter extends OncePerRequestFilter {

    @Autowired
    private UserDetailService service;

    @Autowired
    private JwtUtil util;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = obtenerTokenDelRequest(request);
        String username = null;

        try {
            username = util.getUsernameFromToken(token);
        } catch (IllegalArgumentException e) {
            System.out.println("Token invalido");
        } catch (ExpiredJwtException e) {
            System.out.println("Token expirado");
        } catch (MalformedJwtException e) {
            System.out.println("Token deprecado");
        }

        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails user = this.service.loadUserByUsername(username);

            if (util.validateToken(token, user)) {
                UsernamePasswordAuthenticationToken usernameToken = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
                usernameToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                SecurityContextHolder.getContext().setAuthentication(usernameToken);
            }
        }

        filterChain.doFilter(request, response);
    }

    public String obtenerTokenDelRequest(HttpServletRequest request) {
        final String tokenHeader = request.getHeader("Authorization");

        if (tokenHeader != null && tokenHeader.startsWith("Bearer")) return tokenHeader.substring(7);
        return null;
    }
}
