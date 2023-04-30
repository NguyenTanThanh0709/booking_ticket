package com.tdtu.Cinema.Config;


import com.tdtu.Cinema.Entity.RoleName;
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

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ApplicationSecurityConfig   {

    @Autowired
    private UserDetailService userDetailService;

    @Autowired
    private JwtEntryPoint jwtEntryPoint;

    @Bean
    public JwtTokenFilter jwtAuthenticationFilter(){
        return  new JwtTokenFilter();
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


    @Bean
    protected SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .exceptionHandling()
                .authenticationEntryPoint(jwtEntryPoint)
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests((authorize) -> authorize
                        .requestMatchers( "/"  ).permitAll()
                        .requestMatchers("/register").permitAll()
                        .requestMatchers("/login").permitAll()
                        .requestMatchers("/api/auth/**").permitAll()
                        .requestMatchers("/home").permitAll()
                        .requestMatchers("/api/user/**").authenticated()
                        .requestMatchers("/detailfilm/**").hasRole(RoleName.USER.toString())
                        .requestMatchers("/foodBill/**").hasRole(RoleName.USER.toString())
                        .requestMatchers("/muave").hasRole(RoleName.USER.toString())
                        .requestMatchers("/comments/**").hasRole(RoleName.USER.toString())
                        .requestMatchers("/inforuser").hasRole(RoleName.USER.toString())


                        .requestMatchers("/adminHome").hasRole(RoleName.ADMIN.toString())
                        .requestMatchers("/api/admin/**").hasRole(RoleName.ADMIN.toString())
                        .anyRequest()
                        .authenticated()
                );

        http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403page");

        http.authorizeRequests().and().formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/home?success")
                .failureUrl("/login?error")
                .and().logout().logoutUrl("/logout").logoutSuccessUrl("/login?logout");


        http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    @Autowired
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailService).passwordEncoder(passwordEncoder());
    }


    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
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
