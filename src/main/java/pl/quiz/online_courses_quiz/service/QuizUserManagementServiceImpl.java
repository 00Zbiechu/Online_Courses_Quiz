package pl.quiz.online_courses_quiz.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import pl.quiz.online_courses_quiz.exception.CustomErrorException;
import pl.quiz.online_courses_quiz.exception.errors.ErrorCodes;
import pl.quiz.online_courses_quiz.mapper.QuizUserMapper;
import pl.quiz.online_courses_quiz.model.dto.QuizUserDTO;
import pl.quiz.online_courses_quiz.repository.QuizUserRepository;

@Service
@RequiredArgsConstructor
public class QuizUserManagementServiceImpl implements QuizUserManagementService {

    private final QuizUserRepository quizUserRepository;

    private final QuizUserMapper quizUserMapper;

    @Override
    public QuizUserDTO getQuizUserResult(String username, String courseTitle) {
        var quizUser = quizUserRepository.findByUsernameAndCourseTitle(username, courseTitle).orElseThrow(
                () -> new CustomErrorException("quizUser", ErrorCodes.ENTITY_DOES_NOT_EXIST, HttpStatus.NOT_FOUND)
        );
        return quizUserMapper.toDTO(quizUser);
    }
}
