package pl.quiz.online_courses_quiz.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories("pl.quiz.online_courses_quiz.repository")
public class MongoConfig {
}
