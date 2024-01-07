package pl.quiz.online_courses_quiz.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.quiz.online_courses_quiz.model.document.QuestionDocument;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuestionRepository extends MongoRepository<QuestionDocument, Long> {

    List<QuestionDocument> findAllByCourseTitle(String courseTitle);

    Optional<QuestionDocument> findByCourseTitleAndTitle(String courseTitle, String title);
}