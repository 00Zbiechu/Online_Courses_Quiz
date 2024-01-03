package pl.quiz.online_courses_quiz.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "QUIZ_USER")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuizUserEntity extends BaseEntity {

    @Column(length = 20, nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private int correctAnswer = 0;

    @Column(nullable = false)
    private int wrongAnswer = 0;

    @Column(length = 30, nullable = false)
    private String courseTitle;
}
