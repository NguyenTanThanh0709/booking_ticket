package com.tdtu.Cinema.Security.jwt;

import com.tdtu.Cinema.Security.userprincal.UserDetailService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class JwtAuthorizationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtProvider jwtTokenProvider;

    @Autowired
    private UserDetailService userDetailService;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        try {
            // Lấy chuỗi JWT từ header Authorization của request
            String jwt = getJwt(request);
            if (StringUtils.hasText(jwt) && jwtTokenProvider.validateToken(jwt)) {
                // Xác thực thông tin người dùng từ chuỗi JWT
                Authentication authentication = getAuthentication(jwt);
                // Lưu thông tin xác thực vào SecurityContextHolder
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        } catch (Exception ex) {
//            logger.error("Failed to set user authentication in security context", ex);
//            httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
            return;
        }

        filterChain.doFilter(request, response);
    }


    private String getJwt(HttpServletRequest request){
        String authHeader = request.getHeader("Authorization");
        if(authHeader != null && authHeader.startsWith("Bearer")){
            return authHeader.replace("Bearer", "");
        }else {
            return  null;
        }
//        String header = request.getHeader("Authorization");
//        String token = header.split(" ")[1].trim();
//        return token;
    }

    private Authentication getAuthentication(String jwt) {
        String username = jwtTokenProvider.getUserNameFromtoken(jwt);
        UserDetails userDetails = userDetailService.loadUserByUsername(username);

        return new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
    }




    }



