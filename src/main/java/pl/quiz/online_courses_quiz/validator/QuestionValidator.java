package pl.quiz.online_courses_quiz.validator;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import pl.quiz.online_courses_quiz.exception.CustomErrorException;
import pl.quiz.online_courses_quiz.exception.errors.ErrorCodes;
import pl.quiz.online_courses_quiz.model.dto.QuestionDTO;
import pl.quiz.online_courses_quiz.repository.QuestionRepository;

@Component
@RequiredArgsConstructor
public class QuestionValidator implements Validator {

    private final QuestionRepository questionRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(QuestionDTO.class);
    }

    @Override
    public void validate(@NotNull Object target, @NotNull Errors errors) {
        var dto = (QuestionDTO) target;
        validateIsTitleUnique(dto);
    }

    private void validateIsTitleUnique(QuestionDTO dto) {
        questionRepository.findByCourseTitleAndTitle(dto.getCourseTitle(), dto.getTitle()).ifPresent(
                questionDocument -> {
                    throw new CustomErrorException("question", ErrorCodes.ENTITY_ALREADY_EXIST, HttpStatus.BAD_REQUEST);
                }
        );
    }
}
