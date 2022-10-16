package com.spring.book;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
//스프링 부트의 자동 설정, 스프링 Bean 읽기와 생성을 자동으로 설정
//@SpringBootApplication이 있는 위치부터 설정을 읽음.
// -> 프로젝트 최상단에 위치해야 함.
public class Application {
    //프로젝트의 메인 클래스
    public static void main(String[] args) {
        //SpringApplication.run으로 인해 내장 was를 실행
        SpringApplication.run(Application.class, args);
    }
}
