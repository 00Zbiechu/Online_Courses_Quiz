package pl.quiz.online_courses_quiz.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.quiz.online_courses_quiz.model.dto.QuestionDTO;
import pl.quiz.online_courses_quiz.model.dto.wrapper.QuestionsDTO;
import pl.quiz.online_courses_quiz.service.QuestionManagementService;


@RestController
@RequestMapping("/api/question")
@RequiredArgsConstructor
public class QuestionManagementController {

    private final QuestionManagementService questionManagementService;

    @GetMapping("/question-list")
    public ResponseEntity<QuestionsDTO> getQuestionListForCourse(@RequestParam String courseTitle) {
        return new ResponseEntity<>(questionManagementService.getQuestionListForCourse(courseTitle), HttpStatus.OK);
    }

    @DeleteMapping("/delete-question")
    public ResponseEntity<QuestionsDTO> deleteQuestion(@RequestParam String courseTitle, @RequestParam String title) {
        return new ResponseEntity<>(questionManagementService.deleteQuestion(courseTitle, title), HttpStatus.ACCEPTED);
    }

    @PostMapping("/add-question")
    public ResponseEntity<QuestionsDTO> addQuestion(@Valid @RequestBody QuestionDTO questionDTO, @RequestParam String courseTitle) {
        return new ResponseEntity<>(questionManagementService.addQuestion(questionDTO, courseTitle), HttpStatus.OK);
    }
}
