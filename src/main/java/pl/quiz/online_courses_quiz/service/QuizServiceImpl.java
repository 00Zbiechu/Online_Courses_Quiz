package pl.quiz.online_courses_quiz.service;

import lombok.RequiredArgsConstructor;
import org.apache.commons.math3.random.RandomDataGenerator;
import org.springframework.stereotype.Service;
import pl.quiz.online_courses_quiz.mapper.QuestionMapper;
import pl.quiz.online_courses_quiz.model.dto.QuestionDTO;
import pl.quiz.online_courses_quiz.model.dto.QuestionFormDTO;
import pl.quiz.online_courses_quiz.model.entity.QuestionEntity;
import pl.quiz.online_courses_quiz.model.entity.QuizUserEntity;
import pl.quiz.online_courses_quiz.repository.QuestionRepository;
import pl.quiz.online_courses_quiz.repository.ResultRepository;
import pl.quiz.online_courses_quiz.user.CurrentUser;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class QuizServiceImpl implements QuizService {

    private final QuestionRepository questionRepository;

    private final ResultRepository resultRepository;

    private final QuestionMapper questionMapper;
    private final RandomDataGenerator randomDataGenerator = new RandomDataGenerator();

    @Override
    public void setUserData(String courseTitle, String username) {
        CurrentUser.getInstance().setCourseTitle(courseTitle);
        CurrentUser.getInstance().setUsername(username);
    }

    @Override
    public QuestionFormDTO getQuestionsForLoggedUserAndCourseTitle() {
        List<QuestionEntity> allQuestions = questionRepository.findAllByCourseTitle(CurrentUser.getInstance().getCourseTitle());
        List<QuestionDTO> questionList = new ArrayList<>();

        //TODO: Send to error page when question list is empty

        for (int i = 0; i < 5; i++) {
            int rand = randomDataGenerator.nextInt(0, allQuestions.size() - 1);
            questionList.add(questionMapper.toDTO(allQuestions.get(rand)));
            allQuestions.remove(rand);
        }

        return QuestionFormDTO.builder().questionList(questionList).build();
    }

    @Override
    public int getResult(QuestionFormDTO questionFormDTO) {
        int correct = 0;

        for (QuestionDTO question : questionFormDTO.getQuestionList())
            if (question.getAnswer() == question.getChoice()) {
                correct++;
            }

        return correct;
    }

    @Override
    public void saveQuizResult(QuizUserEntity quizUserEntity) {
        resultRepository.save(quizUserEntity);
    }
}
