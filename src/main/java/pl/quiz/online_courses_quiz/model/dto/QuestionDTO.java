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

import static pl.quiz.online_courses_quiz.exception.errors.ErrorCodes.WRONG_FIELD_SIZE;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class QuestionDTO {

    private String id;

    @NotBlank
    @Size(min = 20, max = 300, message = WRONG_FIELD_SIZE)
    private String title;

    @NotBlank
    @Size(min = 20, max = 200, message = WRONG_FIELD_SIZE)
    private String optionA;

    @NotBlank
    @Size(min = 20, max = 200, message = WRONG_FIELD_SIZE)
    private String optionB;

    @NotBlank
    @Size(min = 20, max = 200, message = WRONG_FIELD_SIZE)
    private String optionC;

    @NotNull
    @Min(1)
    @Max(3)
    private int answer;

    @Size(min = 3, max = 30, message = WRONG_FIELD_SIZE)
    private String courseTitle;
}
