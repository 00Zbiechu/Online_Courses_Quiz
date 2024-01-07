package pl.quiz.online_courses_quiz.model.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import static pl.quiz.online_courses_quiz.exception.errors.ErrorCodes.FIELD_REQUIRED;
import static pl.quiz.online_courses_quiz.exception.errors.ErrorCodes.WRONG_FIELD_SIZE;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class QuestionDTO {

    private String id;

    @NotBlank(message = FIELD_REQUIRED)
    @Size(min = 20, max = 300, message = WRONG_FIELD_SIZE)
    private String title;

    @NotBlank(message = FIELD_REQUIRED)
    @Size(min = 20, max = 200, message = WRONG_FIELD_SIZE)
    private String optionA;

    @NotBlank(message = FIELD_REQUIRED)
    @Size(min = 20, max = 200, message = WRONG_FIELD_SIZE)
    private String optionB;

    @NotBlank(message = FIELD_REQUIRED)
    @Size(min = 20, max = 200, message = WRONG_FIELD_SIZE)
    private String optionC;

    @NotNull(message = FIELD_REQUIRED)
    @Min(value = 1, message = WRONG_FIELD_SIZE)
    @Max(value = 3, message = WRONG_FIELD_SIZE)
    private int answer;

    private String courseTitle;
}
