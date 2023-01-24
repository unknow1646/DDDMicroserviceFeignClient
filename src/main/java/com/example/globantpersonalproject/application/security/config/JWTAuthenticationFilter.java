package com.example.globantpersonalproject.application.security.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.Collections;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

  @Override
  public Authentication attemptAuthentication(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws
      AuthenticationException {
    AuthCredentials authCredentials = new AuthCredentials();

    try{
      authCredentials = new ObjectMapper().readValue(httpServletRequest.getReader(), AuthCredentials.class);

    }catch (IOException e){

    }

    UsernamePasswordAuthenticationToken authenticationToken
        = new UsernamePasswordAuthenticationToken(authCredentials.getEmail(), authCredentials.getPassword(), Collections.emptyList());


    return getAuthenticationManager().authenticate(authenticationToken);
  }

  @Override
  protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response,
      FilterChain chain, Authentication authResult)
      throws IOException, ServletException {

    UserDetailsImpl userDetails = (UserDetailsImpl) authResult.getPrincipal();
    String token = TokenUtils.getTokenSecret(userDetails.getName(), userDetails.getUsername());
    response.addHeader("Authorization", "Bearer" + token);
    response.getWriter().flush();
    super.successfulAuthentication(request, response, chain, authResult);
  }
}
