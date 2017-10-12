package com.lix.security;

import java.util.Arrays;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.JdbcUserDetailsManagerConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.lix.security.AuthProcessingFilter;
import com.lix.security.CustomAuthenticationSuccessHandler;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

//    @Autowired
//    CustomAuthenticationSuccessHandler authenticationSuccessHandler;

//    @Autowired
//    AuthProcessingFilter authProcessingFilter;

//    @Bean
//    public UserDetailsService userDetailsService() {
////        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
////        manager.createUser(User.withUsername("user").password("password").roles("USER").build());
//        return new AuthenticationManagerBuilder().jdbcAuthentication().getUserDetailsService()
////        try {
////            manager.setAuthenticationManager(authenticationManager());
////        } catch (Exception e) {
////            e.printStackTrace();
////        }
////        return manager;
//    }

    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery(
                        "select username,password, enabled from users where username=?")
                .authoritiesByUsernameQuery(
                        "select username, role from user_roles where username=?");
    }
//
//    @Override
//    @Bean( name="myAuthenticationManager")
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return super.authenticationManagerBean();
//    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        <custom-filter position="FORM_LOGIN_FILTER" ref="authenticationFilter" />
//<!--         <logout invalidate-session="true" delete-cookies="JSESSIONID"/> -->
//<!-- 			success-handler-ref="logoutHandler" -->
//<!-- 			logout-url="/j_spring_security_logout"  -->
//
//		<logout
//		logout-success-url="/login.jsp"
//		invalidate-session="true"
//		delete-cookies="JSESSIONID"
//				/>
//        <session-management invalid-session-url="/login.jsp" />
//        authProcessingFilter.setAuthenticationManager(authenticationManagerBean());
//        authProcessingFilter.setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher("/login","POST"));

//        http.addFilterBefore(authProcessingFilter, UsernamePasswordAuthenticationFilter.class);
        http.csrf().disable();
        http.authorizeRequests()
                .antMatchers("/login.jsp", "/**").anonymous() // #4
                .antMatchers("/app*").hasRole("USER") // #6
                .antMatchers("/index.jsp").hasRole("USER") // #6
                .anyRequest().authenticated()
                .and().formLogin().loginPage("/login")//.successHandler(authenticationSuccessHandler)
                .permitAll() // #5
                .and().logout().logoutSuccessUrl("/login.jsp").invalidateHttpSession(true).deleteCookies("JSESSIONID");// 7


    }
}