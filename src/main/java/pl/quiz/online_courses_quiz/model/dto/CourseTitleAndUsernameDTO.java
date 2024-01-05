package pl.quiz.online_courses_quiz.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class CourseTitleAndUsernameDTO {

    private String username;

    private String courseTitle;
}
