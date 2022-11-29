package com.spring.book.config.auth;

import com.spring.book.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity //Spring Security 설정들을 모두 활성화
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                //h2.console을 사용하기 위해 해당 옵션 disable
                .csrf().disable()
                .headers().frameOptions().disable()
                .and()
                //URL 별 관리를 설정하는 옵션
                    .authorizeRequests()
                    .antMatchers("/", "/css/**", "/images/**", "/js/**", "/h2-console/**", "/profile").permitAll()
                    .antMatchers("/api/v1/**").hasRole(Role.USER.name())
                    .anyRequest().authenticated()
                .and()
                //logout 기능에 대한 여러 설정의 진입점
                    .logout()
                        .logoutSuccessUrl("/")
                .and()
                //login 기능에 대한 여러 설정의 진입점
                    .oauth2Login()
                        .userInfoEndpoint()
                        .userService(customOAuth2UserService);
                        //로그인 성공시 후속 조치를 진행할 UserService 인터페이스 구현체를 등록
    }
}
