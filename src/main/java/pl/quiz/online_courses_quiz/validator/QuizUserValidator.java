package pl.quiz.online_courses_quiz.validator;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import pl.quiz.online_courses_quiz.exception.CustomErrorException;
import pl.quiz.online_courses_quiz.exception.errors.ErrorCodes;
import pl.quiz.online_courses_quiz.user.CurrentUser;

@Component
public class QuizUserValidator {

    public void validateQuizUserInstance() {
        if (CurrentUser.getInstance().getCourseTitle() == null || CurrentUser.getInstance().getUsername() == null) {
            throw new CustomErrorException("user", ErrorCodes.FIELD_REQUIRED, HttpStatus.BAD_REQUEST);
        }
    }
}
