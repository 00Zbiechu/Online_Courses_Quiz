package pl.quiz.online_courses_quiz.mapper;

import org.mapstruct.Mapper;
import pl.quiz.online_courses_quiz.model.dto.QuizUserDTO;
import pl.quiz.online_courses_quiz.model.entity.QuizUserDocument;

@Mapper(componentModel = "spring")
public interface QuizUserMapper {

    QuizUserDocument toDocument(QuizUserDTO quizUserDTO);

    QuizUserDTO toDTO(QuizUserDocument quizUserDocument);
}
