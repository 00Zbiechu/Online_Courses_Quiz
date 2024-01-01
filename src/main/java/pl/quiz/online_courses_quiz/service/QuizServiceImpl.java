package pl.quiz.online_courses_quiz.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pl.quiz.online_courses_quiz.model.dto.QuestionFormDTO;
import pl.quiz.online_courses_quiz.model.entity.QuestionEntity;
import pl.quiz.online_courses_quiz.model.entity.ResultEntity;
import pl.quiz.online_courses_quiz.repository.QuestionRepository;
import pl.quiz.online_courses_quiz.repository.ResultRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class QuizServiceImpl implements QuizService {

    private final QuestionRepository questionRepository;

    private final ResultRepository resultRepository;

    public QuestionFormDTO getQuestions() {
        List<QuestionEntity> allQuestions = questionRepository.findAll();
        List<QuestionEntity> questionList = new ArrayList<>();

        Random random = new Random();

        for (int i = 0; i < 5; i++) {
            int rand = random.nextInt(allQuestions.size());
            questionList.add(allQuestions.get(rand));
            allQuestions.remove(rand);
        }

        return QuestionFormDTO.builder().questionList(questionList).build();
    }

    public int getResult(QuestionFormDTO questionFormDTO) {

        int correct = 0;

        for (QuestionEntity question : questionFormDTO.getQuestionList())
            if (question.getAns() == question.getChose())
                correct++;

        return correct;
    }

    public void saveScore(ResultEntity resultEntity) {
        resultEntity.setUsername(resultEntity.getUsername());
        resultEntity.setTotalCorrect(resultEntity.getTotalCorrect());
        resultRepository.save(resultEntity);
    }

    public List<ResultEntity> getTopScore() {
        return resultRepository.findAll(Sort.by(Sort.Direction.DESC, "totalCorrect"));
    }
}
