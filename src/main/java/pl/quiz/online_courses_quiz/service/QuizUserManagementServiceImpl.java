package pl.quiz.online_courses_quiz.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.quiz.online_courses_quiz.mapper.QuizUserMapper;
import pl.quiz.online_courses_quiz.model.document.QuizUserDocument;
import pl.quiz.online_courses_quiz.model.dto.wrapper.QuizUsersDTO;
import pl.quiz.online_courses_quiz.repository.QuizUserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuizUserManagementServiceImpl implements QuizUserManagementService {

    private final QuizUserRepository quizUserRepository;

    private final QuizUserMapper quizUserMapper;

    @Override
    public QuizUsersDTO getQuizUsersResult(String courseTitle) {
        List<QuizUserDocument> quizUsers = quizUserRepository.findAllByCourseTitle(courseTitle);
        return QuizUsersDTO.builder().quizUserList(quizUsers.stream().map(quizUserMapper::toDTO).toList()).build();
    }
}
