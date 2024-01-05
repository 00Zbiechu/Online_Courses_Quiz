package pl.quiz.online_courses_quiz.service;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import pl.quiz.online_courses_quiz.exception.CustomErrorException;
import pl.quiz.online_courses_quiz.exception.errors.ErrorCodes;
import pl.quiz.online_courses_quiz.mapper.QuestionMapper;
import pl.quiz.online_courses_quiz.mapper.QuizUserMapper;
import pl.quiz.online_courses_quiz.model.dto.CourseTitleAndUsernameDTO;
import pl.quiz.online_courses_quiz.model.dto.QuestionFormDTO;
import pl.quiz.online_courses_quiz.model.dto.QuizResultDTO;
import pl.quiz.online_courses_quiz.model.dto.QuizUserDTO;
import pl.quiz.online_courses_quiz.model.dto.wrapper.QuestionsFormDTO;
import pl.quiz.online_courses_quiz.model.entity.QuestionDocument;
import pl.quiz.online_courses_quiz.repository.QuestionRepository;
import pl.quiz.online_courses_quiz.repository.QuizUserRepository;
import pl.quiz.online_courses_quiz.validator.QuizUserValidator;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuizServiceImpl implements QuizService {

    private final QuestionRepository questionRepository;

    private final QuizUserRepository quizUserRepository;

    private final QuizUserValidator quizUserValidator;

    private final QuestionMapper questionMapper;

    private final QuizUserMapper quizUserMapper;

    private final HttpSession session;

    @Override
    public void setUserData(CourseTitleAndUsernameDTO courseTitleAndUsernameDTO) {
        quizUserValidator.validateQuizUserInstanceForSettingCurrentUser(courseTitleAndUsernameDTO.getUsername(), courseTitleAndUsernameDTO.getCourseTitle());
        session.setAttribute("username", courseTitleAndUsernameDTO.getUsername());
        session.setAttribute("courseTitle", courseTitleAndUsernameDTO.getCourseTitle());
    }

    @Override
    public QuestionsFormDTO getQuestionsForLoggedUserAndCourseTitle() {
        validateIsUsernameOrCourseTitleIsNotNull();
        List<QuestionDocument> questionDocumentList = questionRepository.findAllByCourseTitle(session.getAttribute("courseTitle").toString());

        if (questionDocumentList.isEmpty()) {
            throw new CustomErrorException("questions", ErrorCodes.ENTITY_DOES_NOT_EXIST, HttpStatus.NOT_FOUND);
        }

        return QuestionsFormDTO.builder().questionFormList(questionDocumentList.stream().map(questionMapper::toQuestionFormDTO).toList()).build();
    }

    @Override
    public QuizUserDTO saveQuizResult(QuestionsFormDTO questionsFormDTO) {
        var quizResult = getResult(questionsFormDTO);
        validateIsUsernameOrCourseTitleIsNotNull();

        var currentUser = QuizUserDTO.builder()
                .username(session.getAttribute("username").toString())
                .courseTitle(session.getAttribute("courseTitle").toString())
                .correctAnswer(quizResult.getCorrectAnswer())
                .wrongAnswer(quizResult.getWrongAnswer())
                .build();

        quizUserRepository.findByUsernameAndCourseTitle(currentUser.getUsername(), currentUser.getCourseTitle()).ifPresent(
                quizUserDocumentEntity -> {
                    throw new CustomErrorException("quizUserDocumentEntity", ErrorCodes.ENTITY_ALREADY_EXIST, HttpStatus.BAD_REQUEST);
                }
        );

        var result = quizUserRepository.save(quizUserMapper.toDocument(currentUser));
        return quizUserMapper.toDTO(result);
    }

    private QuizResultDTO getResult(QuestionsFormDTO questionsFormDTO) {
        int correct = 0;
        int wrong = 0;

        for (QuestionFormDTO question : questionsFormDTO.getQuestionFormList())
            if (question.getAnswer() == question.getChoice()) {
                correct++;
            } else {
                wrong++;
            }

        return QuizResultDTO.builder().correctAnswer(correct).wrongAnswer(wrong).build();
    }

    private void validateIsUsernameOrCourseTitleIsNotNull() {
        var username = session.getAttribute("username");
        var courseTitle = session.getAttribute("courseTitle");

        if (username == null || courseTitle == null) {
            throw new CustomErrorException("sessionData", ErrorCodes.FIELD_REQUIRED, HttpStatus.BAD_REQUEST);
        }
    }
}
