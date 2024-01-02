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
public class QuestionDTO {

    private String title;

    private String optionA;

    private String optionB;

    private String optionC;

    private int answer;

    private int choice;

    private String courseTitle;
}
