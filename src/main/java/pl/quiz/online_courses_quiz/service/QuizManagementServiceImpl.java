package pl.quiz.online_courses_quiz.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import pl.quiz.online_courses_quiz.exception.CustomErrorException;
import pl.quiz.online_courses_quiz.exception.errors.ErrorCodes;
import pl.quiz.online_courses_quiz.mapper.QuestionMapper;
import pl.quiz.online_courses_quiz.model.dto.QuestionDTO;
import pl.quiz.online_courses_quiz.model.dto.wrapper.QuestionsDTO;
import pl.quiz.online_courses_quiz.model.entity.QuestionDocument;
import pl.quiz.online_courses_quiz.repository.QuestionRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuizManagementServiceImpl implements QuizManagementService {

    private final QuestionRepository questionRepository;

    private final QuestionMapper questionMapper;

    @Override
    public QuestionsDTO getQuestionListForCourse(String courseTitle) {
        List<QuestionDocument> questionDocumentList = questionRepository.findAllByCourseTitle(courseTitle);
        return QuestionsDTO.builder().questionList(questionDocumentList.stream().map(questionMapper::toDTO).toList()).build();
    }

    @Override
    public QuestionsDTO deleteQuestion(String courseTitle, String title) {
        var question = questionRepository.findByCourseTitleAndTitle(courseTitle, title).orElseThrow(
                () -> new CustomErrorException("question", ErrorCodes.ENTITY_DOES_NOT_EXIST, HttpStatus.NOT_FOUND)
        );

        questionRepository.delete(question);
        return getQuestionListForCourse(courseTitle);
    }

    @Override
    public QuestionsDTO addQuestion(QuestionDTO questionDTO) {
        return null;
    }
}

