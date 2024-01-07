package pl.quiz.online_courses_quiz.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.quiz.online_courses_quiz.mapper.QuizUserMapper;
import pl.quiz.online_courses_quiz.model.document.QuizUserDocument;
import pl.quiz.online_courses_quiz.model.dto.QuizUserDTO;
import pl.quiz.online_courses_quiz.repository.QuizUserRepository;

@Service
@RequiredArgsConstructor
public class QuizUserManagementServiceImpl implements QuizUserManagementService {

    private final QuizUserRepository quizUserRepository;

    private final QuizUserMapper quizUserMapper;

    @Override
    public QuizUserDTO getQuizUserResult(String username, String courseTitle) {
        var quizUser = quizUserRepository.findByUsernameAndCourseTitle(username, courseTitle).orElseGet(
                () -> QuizUserDocument.builder().correctAnswer(0).wrongAnswer(0).courseTitle(courseTitle).username(username).build()
        );
        return quizUserMapper.toDTO(quizUser);
    }
}
