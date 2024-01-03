package pl.quiz.online_courses_quiz.exception;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomErrorException.class)
    public String handleCustomErrorException(CustomErrorException ex, Model model) {
        model.addAttribute("errorStatus", ex.getHttpStatus());
        model.addAttribute("field", ex.getField());
        model.addAttribute("errorCode", ex.getErrorCode());
        return "error.html";
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public String handleMissingServletRequestParameterException(MissingServletRequestParameterException ex, Model model) {
        model.addAttribute("errorStatus", HttpStatus.BAD_REQUEST);
        model.addAttribute("field", ex.getParameterName());
        model.addAttribute("errorCode", ex.getMessage());
        return "error.html";
    }
}