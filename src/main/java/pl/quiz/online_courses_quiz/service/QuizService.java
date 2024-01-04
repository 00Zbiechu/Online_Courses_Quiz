package pl.quiz.online_courses_quiz.service;

import pl.quiz.online_courses_quiz.model.dto.QuizUserDTO;
import pl.quiz.online_courses_quiz.model.dto.wrapper.QuestionsFormDTO;

public interface QuizService {

    void setUserData(String courseTitle, String username);

    QuestionsFormDTO getQuestionsForLoggedUserAndCourseTitle();

    QuizUserDTO saveQuizResult(QuestionsFormDTO questionsFormDTO);
}
