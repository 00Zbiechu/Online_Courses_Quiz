package pl.quiz.online_courses_quiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.quiz.online_courses_quiz.model.entity.QuizUserEntity;

import java.util.Optional;

@Repository
public interface QuizUserRepository extends JpaRepository<QuizUserEntity, Long> {

    Optional<QuizUserEntity> findByUsernameAndCourseTitle(String username, String courseTitle);
}
