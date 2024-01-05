package pl.quiz.online_courses_quiz.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ApiCustomErrorException extends RuntimeException {
    private String field;

    private String errorCode;

    private HttpStatus httpStatus;

    public ApiCustomErrorException(String field, String errorCode, HttpStatus httpStatus) {
        this.field = field;
        this.errorCode = errorCode;
        this.httpStatus = httpStatus;
    }
}
