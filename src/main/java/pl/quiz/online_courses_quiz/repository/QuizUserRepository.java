package pl.quiz.online_courses_quiz.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.quiz.online_courses_quiz.model.entity.QuizUserDocument;

import java.util.Optional;

@Repository
public interface QuizUserRepository extends MongoRepository<QuizUserDocument, Long> {

    Optional<QuizUserDocument> findByUsernameAndCourseTitle(String username, String courseTitle);
}
