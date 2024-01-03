package pl.quiz.online_courses_quiz.service;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import pl.quiz.online_courses_quiz.exception.CustomErrorException;
import pl.quiz.online_courses_quiz.exception.errors.ErrorCodes;
import pl.quiz.online_courses_quiz.mapper.QuestionMapper;
import pl.quiz.online_courses_quiz.mapper.QuizUserMapper;
import pl.quiz.online_courses_quiz.model.dto.QuestionDTO;
import pl.quiz.online_courses_quiz.model.dto.QuestionFormDTO;
import pl.quiz.online_courses_quiz.model.dto.QuizResultDTO;
import pl.quiz.online_courses_quiz.model.dto.QuizUserDTO;
import pl.quiz.online_courses_quiz.model.entity.QuestionEntity;
import pl.quiz.online_courses_quiz.repository.QuestionRepository;
import pl.quiz.online_courses_quiz.repository.QuizUserRepository;
import pl.quiz.online_courses_quiz.user.CurrentUser;
import pl.quiz.online_courses_quiz.validator.QuizUserValidator;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuizServiceImpl implements QuizService {

    private final QuestionRepository questionRepository;

    private final QuizUserRepository quizUserRepository;

    private final QuestionMapper questionMapper;

    private final QuizUserMapper quizUserMapper;

    private final QuizUserValidator quizUserValidator;

    private final HttpSession session;

    @Override
    public void setUserData(String courseTitle, String username) {
        quizUserValidator.validateQuizUserInstanceForSettingCurrentUser(username, courseTitle);
        session.setAttribute("username", username);
        session.setAttribute("courseTitle", courseTitle);
    }

    @Override
    public QuestionFormDTO getQuestionsForLoggedUserAndCourseTitle() {
        List<QuestionEntity> questionEntityList = questionRepository.findAllByCourseTitle(session.getAttribute("courseTitle").toString());

        if (questionEntityList.isEmpty()) {
            throw new CustomErrorException("questions", ErrorCodes.ENTITY_DOES_NOT_EXIST, HttpStatus.NOT_FOUND);
        }

        return QuestionFormDTO.builder().questionList(questionEntityList.stream().map(questionMapper::toDTO).toList()).build();
    }

    @Override
    public QuizUserDTO saveQuizResult(QuestionFormDTO questionFormDTO) {
        var quizResult = getResult(questionFormDTO);
        var currentUser = CurrentUser.getInstance();

        currentUser.setUsername(session.getAttribute("username").toString());
        currentUser.setCourseTitle(session.getAttribute("courseTitle").toString());
        currentUser.setCorrectAnswer(quizResult.getCorrectAnswer());
        currentUser.setWrongAnswer(quizResult.getWrongAnswer());

        quizUserRepository.findByUsernameAndCourseTitle(currentUser.getUsername(), currentUser.getCourseTitle()).ifPresent(
                quizUserEntity -> {
                    throw new CustomErrorException("quizUserEntity", ErrorCodes.ENTITY_ALREADY_EXIST, HttpStatus.BAD_REQUEST);
                }
        );

        var result = quizUserRepository.save(quizUserMapper.toEntity(currentUser));
        return quizUserMapper.toDTO(result);
    }

    private QuizResultDTO getResult(QuestionFormDTO questionFormDTO) {
        int correct = 0;
        int wrong = 0;

        for (QuestionDTO question : questionFormDTO.getQuestionList())
            if (question.getAnswer() == question.getChoice()) {
                correct++;
            } else {
                wrong++;
            }

        return QuizResultDTO.builder().correctAnswer(correct).wrongAnswer(wrong).build();
    }
}
