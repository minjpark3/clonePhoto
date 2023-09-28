package com.cos.photogramstart.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity //해당파일로 시큐리티를 활성화
@Configuration // IoC
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override  //16. 해당주소들은 인증이  나머지는 19. 로그인이 되면 로그인페이지로 가서 로그인이 되면 정상으로 보인다.
    protected void configure(HttpSecurity http)throws Exception{
        //csrf토큰 비활성화 시키기
        http.csrf().disable();
       // super.configure(http);   // 이친구때문에 자꾸 초반에 낚아 채져서 로그인 페이지로 넘어감
        //기존 시큐리티가 가지고 있는 기능들을 비활성화 시킴
        http.authorizeRequests()
                .antMatchers("/","/user/**","/subscribe/**","/comment/**").authenticated()
                .anyRequest().permitAll()
                .and()
                .formLogin()
                .loginPage("/auth/signin")
                .defaultSuccessUrl("/");
    }
}
