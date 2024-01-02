package pl.quiz.online_courses_quiz.user;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import pl.quiz.online_courses_quiz.model.entity.QuizUserEntity;

@Component
@Getter
@Setter
@Data
@Builder
public class CurrentUser {

    public static QuizUserEntity INSTANCE;

    private CurrentUser() {
    }

    public static QuizUserEntity getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new QuizUserEntity();
        }

        return INSTANCE;
    }
}
