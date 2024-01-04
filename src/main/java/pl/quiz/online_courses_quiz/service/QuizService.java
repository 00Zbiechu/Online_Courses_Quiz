package pl.quiz.online_courses_quiz.service;

import pl.quiz.online_courses_quiz.model.dto.QuestionFormDTO;
import pl.quiz.online_courses_quiz.model.entity.QuizUserDocument;

public interface QuizService {

    void setUserData(String courseTitle, String username);

    QuestionFormDTO getQuestionsForLoggedUserAndCourseTitle();

    QuizUserDocument saveQuizResult(QuestionFormDTO questionFormDTO);
}
