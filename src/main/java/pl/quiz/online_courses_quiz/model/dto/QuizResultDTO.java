package pl.quiz.online_courses_quiz.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuizResultDTO {

    private int correctAnswer = 0;

    private int wrongAnswer = 0;
}
