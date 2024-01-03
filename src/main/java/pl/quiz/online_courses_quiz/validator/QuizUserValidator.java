package pl.quiz.online_courses_quiz.validator;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import pl.quiz.online_courses_quiz.exception.CustomErrorException;
import pl.quiz.online_courses_quiz.exception.errors.ErrorCodes;

@Component
public class QuizUserValidator {

    public void validateQuizUserInstanceForSettingCurrentUser(String username, String courseTitle) {
        validateQuizTitle(courseTitle);
        validateQuizUser(username);
    }

    private void validateQuizTitle(String courseTitle) {
        if (courseTitle == null || courseTitle.isBlank() || courseTitle.isEmpty()) {
            throw new CustomErrorException("courseTitle", ErrorCodes.FIELD_REQUIRED, HttpStatus.BAD_REQUEST);
        }

        if (courseTitle.length() < 3 || courseTitle.length() > 30) {
            throw new CustomErrorException("courseTitle", ErrorCodes.WRONG_FIELD_SIZE, HttpStatus.BAD_REQUEST);
        }
    }

    private void validateQuizUser(String username) {
        if (username == null || username.isBlank() || username.isEmpty()) {
            throw new CustomErrorException("courseTitle", ErrorCodes.FIELD_REQUIRED, HttpStatus.BAD_REQUEST);
        }

        if (username.length() < 3 || username.length() > 20) {
            throw new CustomErrorException("username", ErrorCodes.WRONG_FIELD_SIZE, HttpStatus.BAD_REQUEST);
        }
    }
}
