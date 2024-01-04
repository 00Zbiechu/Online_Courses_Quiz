package pl.quiz.online_courses_quiz.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("question")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuestionDocument extends BaseDocument {

    private String title;

    private String optionA;

    private String optionB;

    private String optionC;

    private int answer;

    private int choice;

    private String courseTitle;
}
