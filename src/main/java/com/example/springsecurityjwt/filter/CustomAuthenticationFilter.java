package com.example.springsecurityjwt.filter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

import static java.util.Arrays.stream;

public class CustomAuthenticationFilter extends OncePerRequestFilter {
    private static final String SECRET = "secret";
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if (request.getServletPath().equals("/login")) {
            filterChain.doFilter(request, response);
        } else {
            String header = request.getHeader("Authorization");

            if (Objects.nonNull(header) && header.startsWith("Bearer ")) {
                try {
                    String token = header.substring("Bearer ".length());
                    Algorithm algorithm = Algorithm.HMAC256(SECRET.getBytes());
                    JWTVerifier verifier = JWT.require(algorithm).build();
                    DecodedJWT decodedJWT = verifier.verify(token);

                    String[] authorities = decodedJWT.getClaim("authorities").asArray(String.class);
                    Collection<SimpleGrantedAuthority> simpleGrantedAuthorities = new ArrayList<>();
                    stream(authorities).forEach(authority -> simpleGrantedAuthorities.add(new SimpleGrantedAuthority(authority)));

                    String username = decodedJWT.getSubject();

                    UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(username, null, simpleGrantedAuthorities);

                    SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);

                    filterChain.doFilter(request, response);

                } catch (Exception e) {
                    response.setHeader("error", e.getMessage());
                    response.sendError(HttpStatus.FORBIDDEN.value());
                }
            }
        }
    }
}