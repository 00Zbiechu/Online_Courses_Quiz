package pl.quiz.online_courses_quiz.exception.wrapper;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.quiz.online_courses_quiz.exception.model.ErrorDTO;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorList {

    private List<ErrorDTO> errorList;
}
