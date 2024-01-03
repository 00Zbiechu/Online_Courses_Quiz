package pl.quiz.online_courses_quiz.user;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import pl.quiz.online_courses_quiz.model.dto.QuizUserDTO;

@Component
@Getter
@Setter
@Data
@Builder
public class CurrentUser {

    public static QuizUserDTO INSTANCE;

    private CurrentUser() {
    }

    public static QuizUserDTO getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new QuizUserDTO();
        }

        return INSTANCE;
    }
}
