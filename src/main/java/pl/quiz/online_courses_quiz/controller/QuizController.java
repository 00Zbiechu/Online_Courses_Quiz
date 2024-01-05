package pl.quiz.online_courses_quiz.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import pl.quiz.online_courses_quiz.model.dto.CourseTitleAndUsernameDTO;
import pl.quiz.online_courses_quiz.model.dto.wrapper.QuestionsFormDTO;
import pl.quiz.online_courses_quiz.service.QuizService;

@Controller
@RequiredArgsConstructor
public class QuizController {

    private final QuizService quizService;

    @GetMapping("/")
    public String home(@RequestBody CourseTitleAndUsernameDTO courseTitleAndUsernameDTO) {
        quizService.setUserData(courseTitleAndUsernameDTO);
        return "index.html";
    }

    @PostMapping("/quiz")
    public String quiz(Model model) {
        model.addAttribute("questionForm", quizService.getQuestionsForLoggedUserAndCourseTitle());
        return "quiz.html";
    }

    @PostMapping("/submit")
    public String submit(@ModelAttribute QuestionsFormDTO questionsFormDTO, Model model) {
        var currentUser = quizService.saveQuizResult(questionsFormDTO);
        model.addAttribute("result", currentUser);
        return "result.html";
    }
}
