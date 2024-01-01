package pl.quiz.online_courses_quiz.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.quiz.online_courses_quiz.model.dto.QuestionFormDTO;
import pl.quiz.online_courses_quiz.model.entity.ResultEntity;
import pl.quiz.online_courses_quiz.service.QuizService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class QuizController {

    private final QuizService quizService;
    Boolean submitted = false;

    @ModelAttribute("result")
    public ResultEntity getResult() {
        return new ResultEntity();
    }

    @GetMapping("/")
    public String home() {
        return "index.html";
    }

    @PostMapping("/quiz")
    public String quiz(@RequestParam String username, Model model, RedirectAttributes redirectAttributes) {
        if (username.isEmpty()) {
            redirectAttributes.addFlashAttribute("warning", "You must enter your name");
            return "redirect:/";
        }

        submitted = false;
        getResult().setUsername(username);

        QuestionFormDTO qForm = quizService.getQuestions();
        model.addAttribute("qForm", qForm);

        return "quiz.html";
    }

    @PostMapping("/submit")
    public String submit(@ModelAttribute QuestionFormDTO questionFormDTO) {
        if (!submitted) {
            getResult().setTotalCorrect(quizService.getResult(questionFormDTO));
            quizService.saveScore(getResult());
            submitted = true;
        }
        return "result.html";
    }

    @GetMapping("/score")
    public String score(Model m) {
        List<ResultEntity> sList = quizService.getTopScore();
        m.addAttribute("sList", sList);
        return "scoreboard.html";
    }
}
