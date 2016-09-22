package com.nanda.demo.spring.boot.security;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.AuthorityUtils;

import javax.inject.Named;

/**
 * Auth provider to delegate authentication to Stablenet
 */
@Named
public class DBAutheniticationProvider implements AuthenticationProvider {

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String role = authentication.getName().equalsIgnoreCase("test") ? "ROLE_ADMIN" : "ROLE_USER";
        return new UsernamePasswordAuthenticationToken(authentication.getName(), authentication.getCredentials(),
                AuthorityUtils.commaSeparatedStringToAuthorityList(role));
    }

}
