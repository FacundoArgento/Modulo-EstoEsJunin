package unnoba.edu.ar.gestion2022.tpi.modulo.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.UserDetailsService;
import unnoba.edu.ar.gestion2022.tpi.modulo.service.UserServiceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Autowired
    private UserServiceImp userDetailsService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .cors().and().csrf()
                    .disable()
                .authorizeRequests()
                    .antMatchers(HttpMethod.GET, "/", "/resources/**", "/static/**", "/**/*.js", "/**/*.js.map", "/**/*.css", "/**/*.svg", "/**/*.png").permitAll()
                    .antMatchers("/users", "/users/new", "/form", "/listado", "/index", "/", "/error").permitAll()
                    .antMatchers(HttpMethod.POST, "/users/new").permitAll()
                    .anyRequest().authenticated()
                    .and()
                .formLogin()
                    .loginPage("/login").permitAll()
                    .defaultSuccessUrl("/home", true)
                    .failureUrl("/error")
                    .and()
                .logout()
                    .permitAll()
                    .logoutSuccessUrl("/index");

        return http.build();
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(getPasswordEncoder());
    }

//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .cors().and().csrf().disable()
//                .authorizeRequests()
//                .antMatchers(HttpMethod.GET, "/", "/resources/**", "/static/**", "/**/*.js", "/**/*.js.map", "/**/*.css", "/**/*.svg", "/**/*.png").permitAll()
//            .antMatchers("/users", "/users/new", "/form", "/listado","/").permitAll()
//                .antMatchers(HttpMethod.POST, "/users/new").permitAll()
//                .anyRequest().authenticated()
//                .and().formLogin()
//                .loginPage("/login").permitAll()
//                .defaultSuccessUrl("/home", true)
//                .failureUrl("/error")
//                .and()
//                .logout().permitAll()
//                .logoutSuccessUrl("/index")
//            ;
//    }
//

}