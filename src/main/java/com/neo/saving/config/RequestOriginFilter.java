package com.neo.saving.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Slf4j
@Component
public class RequestOriginFilter extends OncePerRequestFilter {

   @Value("#{'${zeus.allowed.ip:0:0:0:0:0:0:0:1}'.split(',')}")
   public List<String> zeusWhiteList;

   @Value("${spring.profiles.active:stage}")
   String profile;

   @Override
   protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException {
      String ipAddress = request.getHeader("X-FORWARDED-FOR");
      if (ipAddress == null) {
         ipAddress = request.getRemoteAddr();
      }
      if ("stg".equals(profile) || zeusWhiteList.contains(ipAddress)) {
         filterChain.doFilter(request, response);
      } else {
         log.info("Incoming request from {}", ipAddress);
         response.setStatus(403);
      }
   }
}
