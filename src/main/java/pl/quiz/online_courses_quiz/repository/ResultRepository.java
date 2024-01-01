package pl.quiz.online_courses_quiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.quiz.online_courses_quiz.model.entity.ResultEntity;

@Repository
public interface ResultRepository extends JpaRepository<ResultEntity, Long> {
}
