package pl.quiz.online_courses_quiz.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.quiz.online_courses_quiz.model.entity.QuestionDocument;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuestionFormDTO {

    private List<QuestionDocument> questionDocumentList;
}
