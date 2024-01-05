package pl.quiz.online_courses_quiz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class OnlineCoursesQuizApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnlineCoursesQuizApplication.class, args);
    }
}
