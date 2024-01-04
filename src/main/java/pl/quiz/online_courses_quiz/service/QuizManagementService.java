package pl.quiz.online_courses_quiz.service;

import pl.quiz.online_courses_quiz.model.dto.QuestionDTO;
import pl.quiz.online_courses_quiz.model.dto.wrapper.QuestionsDTO;

public interface QuizManagementService {
    QuestionsDTO getQuestionListForCourse(String courseTitle);

    QuestionsDTO deleteQuestion(String courseTitle, String title);

    QuestionsDTO addQuestion(QuestionDTO questionDTO);
}
