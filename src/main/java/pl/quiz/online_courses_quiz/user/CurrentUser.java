package pl.quiz.online_courses_quiz.user;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import pl.quiz.online_courses_quiz.model.entity.QuizUserDocument;

@Component
@Getter
@Setter
@Data
@Builder
public class CurrentUser {

    public static QuizUserDocument INSTANCE;

    private CurrentUser() {
    }

    public static QuizUserDocument getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new QuizUserDocument();
        }

        return INSTANCE;
    }
}
