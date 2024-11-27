//package com.example.Astrology.security;
//
//import com.example.Astrology.service.JwtService;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import lombok.AllArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationContext;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import java.io.IOException;
//
///**
// * JwtFilter is a filter responsible for intercepting incoming HTTP requests to check for a valid JWT token
// * in the Authorization header and establishing the authentication context for the user.
// */
//@AllArgsConstructor
//@Component
//public class JwtFilter extends OncePerRequestFilter {
//
//    @Autowired
//    private JwtService jwtService;
//
//    @Autowired
//    private ApplicationContext context;
//
//    /**
//     * This method filters each HTTP request to check if a valid JWT token is present in the Authorization header.
//     * If a valid token is found, it extracts the username, validates the token, and sets the authentication
//     * details in the security context for further processing by Spring Security.
//     *
//     * @param request     The HttpServletRequest object representing the incoming HTTP request
//     * @param response    The HttpServletResponse object representing the outgoing HTTP response
//     * @param filterChain The FilterChain object to allow the request to proceed to the next filter in the chain
//     * @throws ServletException If there is an issue with the request processing
//     * @throws IOException      If an I/O error occurs during filter processing
//     */
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//        String authHeader = request.getHeader("Authorization");
//        String token = null;
//        String username = null;
//
//
//        if (authHeader != null && authHeader.startsWith("Bearer ")) {
//            token = authHeader.substring(7);
//            username = jwtService.extractUsername(token);
//        }
//
//
//        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
//            UserDetails userDetails = context.getBean(CustomUserDetailService.class).loadUserByUsername(username);
//
//
//            if (jwtService.validateToken(token, userDetails)) {
//                UsernamePasswordAuthenticationToken authToken =
//                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
//
//                authToken.setDetails(new WebAuthenticationDetailsSource()
//                        .buildDetails(request));
//
//                SecurityContextHolder.getContext().setAuthentication(authToken);
//            }
//        }
//
//        filterChain.doFilter(request, response);
//    }
//}
