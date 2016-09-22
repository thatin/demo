package com.nanda.demo.spring.boot.security;

import com.nanda.demo.spring.boot.dao.UserRepository;
import com.nanda.demo.spring.boot.model.User;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.AuthorityUtils;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Auth provider to delegate authentication to Stablenet
 */
@Named
public class DBAutheniticationProvider implements AuthenticationProvider {

    @Inject
    UserRepository userRepository;

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        User user = userRepository.findByName(authentication.getName());
        if(user!=null){
            String role = user.getName().equalsIgnoreCase("test") ? "ROLE_ADMIN" : "ROLE_USER";
            return new UsernamePasswordAuthenticationToken(authentication.getName(), authentication.getCredentials(),
                    AuthorityUtils.commaSeparatedStringToAuthorityList(role));
        }
        throw new BadCredentialsException("Invalid credentials!");
    }

}
