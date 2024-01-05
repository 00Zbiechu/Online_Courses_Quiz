package pl.quiz.online_courses_quiz.service;

import pl.quiz.online_courses_quiz.model.dto.QuizUserDTO;

public interface QuizUserManagementService {

    QuizUserDTO getQuizUserResult(String username, String courseTitle);
}
