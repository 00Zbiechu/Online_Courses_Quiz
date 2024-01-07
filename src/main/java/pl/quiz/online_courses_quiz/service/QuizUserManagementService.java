package pl.quiz.online_courses_quiz.service;

import pl.quiz.online_courses_quiz.model.dto.wrapper.QuizUsersDTO;

public interface QuizUserManagementService {

    QuizUsersDTO getQuizUsersResult(String courseTitle);
}
