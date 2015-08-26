package com.lix.security;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.lix.domain.master.productores.model.Productores;
import com.lix.domain.master.repositories.UsersRepository;
import com.lix.domain.master.users.model.Users;

public class AuthProcessingFilter extends UsernamePasswordAuthenticationFilter {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(AuthProcessingFilter.class);

	@Autowired
	private UserService userService;

	@Autowired
	UsersRepository usersRepository;

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

		// USER
		final String username = request
				.getParameter(SPRING_SECURITY_FORM_USERNAME_KEY);
		UserDetails userDetails = userService.loadUserByUsername(username);
		Authentication authentication = new UsernamePasswordAuthenticationToken(
				userDetails, null, userDetails.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(authentication);
		logger.info("Entry onAuthenticationSuccess " + "userDetails "
				+ userDetails);
		request.getSession().setAttribute("loggedInUser", userDetails);

		Writer out = responseWrapper.getWriter();
		logger.info("getting productores from user");

		Users user = usersRepository.findByUsername(username);

		ObjectMapper mapper = new ObjectMapper();
		List<Productores> productores = user.getProductores();
		if (productores.size() == 1) {
			request.getSession().setAttribute("currentProductor",
					productores.get(0));
		} else {
			request.getSession().setAttribute("currentProductor",
					productores.get(1));
		}
		String productoresJson = mapper.writeValueAsString(productores);

		LOGGER.info("autentication success");
		out.write("{success:true,");
		out.write("productores:" + productoresJson + "}");
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