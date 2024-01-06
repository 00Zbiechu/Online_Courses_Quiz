package pl.quiz.online_courses_quiz.service;

import pl.quiz.online_courses_quiz.model.dto.CourseTitleAndUsernameDTO;
import pl.quiz.online_courses_quiz.model.dto.QuizUserDTO;
import pl.quiz.online_courses_quiz.model.dto.wrapper.QuestionsFormDTO;

public interface QuizService {

    void setUserData(String username, String courseTitle);

    QuestionsFormDTO getQuestionsForLoggedUserAndCourseTitle();

    QuizUserDTO saveQuizResult(QuestionsFormDTO questionsFormDTO);
}
