package pl.quiz.online_courses_quiz.service;

import pl.quiz.online_courses_quiz.model.dto.QuestionFormDTO;
import pl.quiz.online_courses_quiz.model.entity.QuizUserEntity;

public interface QuizService {

    void setUserData(String courseTitle, String username);

    QuestionFormDTO getQuestionsForLoggedUserAndCourseTitle();

    int getResult(QuestionFormDTO questionFormDTO);

    void saveQuizResult(QuizUserEntity quizUserEntity);
}
