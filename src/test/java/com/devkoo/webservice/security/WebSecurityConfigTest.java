//package com.devkoo.webservice.security;
//
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//
//import java.util.Collection;
//
//public class WebSecurityConfigTest {
//
//    @Autowired
//    WebSecurityConfig webSecurityConfig;
//
//    @Test
//    public UserDetailsService userDetailsService() {
//        User user = new User("user", "password", false, false, false, false, null);
//
//        return new InMemoryUserDetailsManager((Collection<UserDetails>) user);
//    }
//
//}
