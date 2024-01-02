package pl.quiz.online_courses_quiz.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.quiz.online_courses_quiz.model.dto.QuestionFormDTO;
import pl.quiz.online_courses_quiz.service.QuizService;
import pl.quiz.online_courses_quiz.user.CurrentUser;

@Controller
@RequiredArgsConstructor
public class QuizController {

    private final QuizService quizService;

    @GetMapping("/")
    public String home(@RequestParam String courseTitle, @RequestParam String username, Model model) {
        quizService.setUserData(courseTitle, username);
        model.addAttribute("courseTitle", CurrentUser.getInstance().getCourseTitle());
        model.addAttribute("username", CurrentUser.getInstance().getUsername());
        return "index.html";
    }

    @PostMapping("/quiz")
    public String quiz(Model model) {
        model.addAttribute("questionForm", quizService.getQuestionsForLoggedUserAndCourseTitle());
        return "quiz.html";
    }

    @PostMapping("/submit")
    public String submit(@ModelAttribute QuestionFormDTO questionFormDTO, Model model) {
        CurrentUser.getInstance().setTotalCorrectPoints(quizService.getResult(questionFormDTO));
        quizService.saveQuizResult(CurrentUser.getInstance());
        model.addAttribute("result", CurrentUser.getInstance());
        return "result.html";
    }
}
