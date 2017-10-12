package com.lix.controller;

import static org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lix.domain.master.productores.model.Productores;
import com.lix.domain.master.repositories.ProductoresRepository;
import com.lix.domain.master.repositories.UsersRepository;
import com.lix.domain.master.users.model.Users;
import com.lix.dto.DefaultResponse;
import com.lix.security.UserService;

@Controller
public class LoginController {

//    @RequestMapping(value={"/login"})
//    public String login(){
//        return "login";
//    }
//    @Autowired
//    private UserService userService;
//
    @Autowired
    UsersRepository usersRepository;
//
    @Autowired
    ProductoresRepository productoresRepository;

    @RequestMapping(value="/login", method= RequestMethod.POST)
    public ResponseEntity<List<Productores>> login(HttpServletRequest request){
        // USER
        final String username = request
                .getParameter(SPRING_SECURITY_FORM_USERNAME_KEY);
//        Authentication authentication = (Authentication) SecurityContextHolder.getContext().getAuthentication().getCredentials();
//        UserDetails userDetails = (UserDetails) authentication.getDetails();
//        UserDetails userDetails = userService.loadUserByUsername(username);
//        Authentication authentication = new UsernamePasswordAuthenticationToken(
//                userDetails, null, userDetails.getAuthorities());
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//
//        request.getSession().setAttribute("loggedInUser", userDetails);
        try{
            Users user = usersRepository.findByUsername(username);
            List<Productores> productores = user.getProductores();
            return new ResponseEntity(productores, HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity(Collections.emptyList(), HttpStatus.OK);

    }
}
