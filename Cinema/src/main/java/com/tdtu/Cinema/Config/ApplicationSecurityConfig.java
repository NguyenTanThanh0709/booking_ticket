package com.tdtu.Cinema.Config;


import com.tdtu.Cinema.Entity.RoleName;
import com.tdtu.Cinema.Security.jwt.JwtAuthorizationFilter;
import com.tdtu.Cinema.Security.jwt.JwtEntryPoint;
import com.tdtu.Cinema.Security.jwt.JwtTokenFilter;
import com.tdtu.Cinema.Security.userprincal.UserDetailService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig   {

    @Autowired
    private UserDetailService userDetailService;

    @Autowired
    private JwtEntryPoint jwtEntryPoint;

    @Autowired
    LoginHandler successHandler;

    @Bean
    public JwtTokenFilter jwtAuthenticationFilter(){
        return new JwtTokenFilter();
    }

    @Bean
    public JwtAuthorizationFilter jwtAuthorizationFilter() throws Exception {
        return new JwtAuthorizationFilter();
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }


    @Bean
    protected SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .exceptionHandling()
                .authenticationEntryPoint(jwtEntryPoint);
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.authorizeRequests()
                .requestMatchers(
                        new AntPathRequestMatcher("/api/auth/**"),
                        new AntPathRequestMatcher("/"),
                        new AntPathRequestMatcher("/home"),
                        new AntPathRequestMatcher("/login"),
                        new AntPathRequestMatcher("/register"),
                        new AntPathRequestMatcher("/api/user/**"),
                        new AntPathRequestMatcher("/detailfilm/**")
                ).permitAll();



        http.authorizeRequests().requestMatchers(
                new AntPathRequestMatcher("/api/admin/**"),
                new AntPathRequestMatcher("/adminHome"),
                new AntPathRequestMatcher("/qldanhgiaphim"),
                new AntPathRequestMatcher("/qlfood"),
                new AntPathRequestMatcher("/qlkhuyenmai"),
                new AntPathRequestMatcher("/qlphim"),
                new AntPathRequestMatcher("/qlrap"),
                new AntPathRequestMatcher("/qlsuatchieu"),
                new AntPathRequestMatcher("/qlve")
        ).hasRole("ADMIN")
                .anyRequest()
                .authenticated();


        http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403page");
        http.authorizeRequests().and().formLogin(
                form -> form
                        .loginPage("/login")
//                        .loginProcessingUrl("/j_spring_security_check")
//                        .usernameParameter("sdt")
//                        .passwordParameter("pass")
                        .defaultSuccessUrl("/home?success")
                        .successHandler(successHandler)
                        .failureUrl("/login?error")
                        .permitAll()
        ).logout(
                logout -> logout
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                        .logoutSuccessUrl("/login?logout")
                        .invalidateHttpSession(true)
                        .deleteCookies("JSESSIONID")
                        .permitAll()
        );

        http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
        http.addFilterBefore(jwtAuthorizationFilter(),UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    @Autowired
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailService).passwordEncoder(passwordEncoder());
    }


    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().requestMatchers(
                "/resources/**",
                "/assets/**",
                "/admin/**",
                "/js/**",
                "/css/**",
                "/images/**",
                "/scss/**",
                "/fonts/**");
    }

}
