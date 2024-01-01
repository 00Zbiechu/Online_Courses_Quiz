package pl.quiz.online_courses_quiz.service;

import pl.quiz.online_courses_quiz.model.dto.QuestionFormDTO;
import pl.quiz.online_courses_quiz.model.entity.ResultEntity;

import java.util.List;

public interface QuizService {

    QuestionFormDTO getQuestions();

    int getResult(QuestionFormDTO questionFormDTO);

    void saveScore(ResultEntity resultEntity);

    List<ResultEntity> getTopScore();
}
