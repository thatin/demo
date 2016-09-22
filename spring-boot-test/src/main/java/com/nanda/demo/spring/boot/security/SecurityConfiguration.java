package com.nanda.demo.spring.boot.security;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.inject.Inject;

@EnableGlobalMethodSecurity(prePostEnabled = true)
@Configuration
public class SecurityConfiguration {

    @Bean
    @Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
    public WebSecurityConfigurerAdapter webSecurityConfigurerAdapter() {
        return new WebSecurityConfigurerAdapter() {
            @Inject
            private DBAutheniticationProvider DBAutheniticationProvider;

            @Override
            protected void configure(AuthenticationManagerBuilder auth) throws Exception {
                auth.authenticationProvider(DBAutheniticationProvider);
            }

            @Override
            protected void configure(HttpSecurity http) throws Exception {
                http.httpBasic()
                        .and().authorizeRequests()
                        .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                        .antMatchers(HttpMethod.POST, "/**").authenticated()
                        .antMatchers(HttpMethod.PUT, "/**/**").authenticated()
                        .antMatchers(HttpMethod.GET, "/**/**").authenticated()
                        .antMatchers(HttpMethod.DELETE, "/**/**").authenticated()
                        .and().csrf().disable();
            }
        };

    }

    @Bean
    public BeanPostProcessor providerManagerPostProcessor() {
        return new BeanPostProcessor() {

            @Override
            public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
                return bean;
            }

            @Override
            public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
                if (bean instanceof ProviderManager) {
                    ((ProviderManager) bean).setEraseCredentialsAfterAuthentication(false);
                }
                return bean;
            }
        };
    }
}
