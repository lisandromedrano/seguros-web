package com.lix.security;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class AuthProcessingFilter extends UsernamePasswordAuthenticationFilter {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(AuthProcessingFilter.class);

	@Override
	protected void successfulAuthentication(HttpServletRequest request,
			HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		SavedRequestAwareAuthenticationSuccessHandler srh = new SavedRequestAwareAuthenticationSuccessHandler();
		this.setAuthenticationSuccessHandler(srh);
		srh.setRedirectStrategy(new RedirectStrategy() {
			@Override
			public void sendRedirect(HttpServletRequest httpServletRequest,
					HttpServletResponse httpServletResponse, String s)
					throws IOException {
				// do nothing, no redirect
			}
		});
		super.successfulAuthentication(request, response, chain, authResult);
		// super.successfulAuthentication(request, response, authResult);
		HttpServletResponseWrapper responseWrapper = new HttpServletResponseWrapper(
				response);
		Writer out = responseWrapper.getWriter();
		LOGGER.info("autentication success");
		out.write("{success:true}");
		out.close();
	}

	@Override
	protected void unsuccessfulAuthentication(HttpServletRequest request,
			HttpServletResponse response, AuthenticationException failed)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		LOGGER.info("autentication failed");
		super.unsuccessfulAuthentication(request, response, failed);
		HttpServletResponseWrapper responseWrapper = new HttpServletResponseWrapper(
				response);
		Writer out = responseWrapper.getWriter();
		out.write("{success:false}");
		out.close();
	}
}