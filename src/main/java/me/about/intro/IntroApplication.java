package me.about.intro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class IntroApplication {

    public static void main(String[] args) {

        SpringApplication.run(IntroApplication.class, args);

    }

}
