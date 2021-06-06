package ch.repnik.statemachine;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author hic/Diecibärg
 */
@Configuration
@Slf4j
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    

    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .headers().frameOptions().sameOrigin()
            .and()
            .authorizeRequests()
            .antMatchers("/actuator/**", "/h2-console/**", "/swagger-ui/").permitAll()
            .anyRequest().authenticated()
            .and()
            .httpBasic();
    }
    
    
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
            .withUser("test")
            .password("{noop}" + "test")
            .roles("UAV"); //Es braucht mindestens 1 Rolle damit die Applikation korrekt startet
    }
  
    
}
