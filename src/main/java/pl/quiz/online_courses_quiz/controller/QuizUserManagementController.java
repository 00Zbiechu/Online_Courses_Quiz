package pl.quiz.online_courses_quiz.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.quiz.online_courses_quiz.model.dto.QuizUserDTO;
import pl.quiz.online_courses_quiz.service.QuizUserManagementService;

@RestController
@RequestMapping("/api/quiz-user")
@RequiredArgsConstructor
public class QuizUserManagementController {

    private final QuizUserManagementService quizUserManagementService;

    @GetMapping("/get-result")
    public ResponseEntity<QuizUserDTO> getQuizUserResult(@RequestParam String username, @RequestParam String courseTitle) {
        return new ResponseEntity<>(quizUserManagementService.getQuizUserResult(username, courseTitle), HttpStatus.OK);
    }
}
