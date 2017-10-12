package com.lix.security;

import static org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.ForwardAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lix.domain.master.productores.model.Productores;
import com.lix.domain.master.repositories.UsersRepository;
import com.lix.domain.master.users.model.Users;

//@Component
public class CustomAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    private static final Logger LOGGER = LoggerFactory
            .getLogger(CustomAuthenticationSuccessHandler.class);

    @Autowired
    private UserService userService;

    @Autowired
    UsersRepository usersRepository;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        super.onAuthenticationSuccess(request, response, authentication);

//        SavedRequestAwareAuthenticationSuccessHandler srh = new SavedRequestAwareAuthenticationSuccessHandler();
//        this.setAuthenticationSuccessHandler(srh);
//        srh.setRedirectStrategy(new RedirectStrategy() {
//            @Override
//            public void sendRedirect(HttpServletRequest httpServletRequest,
//                                     HttpServletResponse httpServletResponse, String s)
//                    throws IOException {
//                // do nothing, no redirect
//            }
//        });
//        super.successfulAuthentication(request, response, chain, authResult);
        // super.successfulAuthentication(request, response, authResult);
        HttpServletResponseWrapper responseWrapper = new HttpServletResponseWrapper(
                response);

        // USER
        final String username = request
                .getParameter(SPRING_SECURITY_FORM_USERNAME_KEY);
        UserDetails userDetails = userService.loadUserByUsername(username);
        Authentication myAuth = new UsernamePasswordAuthenticationToken(
                userDetails, null, userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(myAuth);
        LOGGER.info("Entry onAuthenticationSuccess " + "userDetails "
                + userDetails);
        request.getSession().setAttribute("loggedInUser", userDetails);

        Writer out = responseWrapper.getWriter();
        LOGGER.info("getting productores from user");

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
}
