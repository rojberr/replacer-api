package dev.drzymala.replacer;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@Configuration
@AllArgsConstructor
public class ReplacerSecurityConfiguration {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .authorizeRequests()
                .mvcMatchers(HttpMethod.GET, "/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .httpBasic();

        http.csrf().disable();
    }
}
