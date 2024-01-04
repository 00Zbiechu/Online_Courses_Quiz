package pl.quiz.online_courses_quiz.model.dto.wrapper;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.quiz.online_courses_quiz.model.dto.QuestionFormDTO;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuestionsFormDTO {

    private List<QuestionFormDTO> questionFormList;
}
