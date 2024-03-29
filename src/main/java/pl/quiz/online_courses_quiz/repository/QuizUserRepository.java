package pl.quiz.online_courses_quiz.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.quiz.online_courses_quiz.model.document.QuizUserDocument;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuizUserRepository extends MongoRepository<QuizUserDocument, Long> {

    Optional<QuizUserDocument> findByUsernameAndCourseTitle(String username, String courseTitle);

    List<QuizUserDocument> findAllByCourseTitle(String courseTitle);
}
