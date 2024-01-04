package pl.quiz.online_courses_quiz.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("quiz_user")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuizUserDocument extends BaseDocument {

    private String username;

    private int correctAnswer = 0;

    private int wrongAnswer = 0;

    private String courseTitle;
}
