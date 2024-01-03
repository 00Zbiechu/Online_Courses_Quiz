package pl.quiz.online_courses_quiz.mapper;

import org.mapstruct.Mapper;
import pl.quiz.online_courses_quiz.model.dto.QuizUserDTO;
import pl.quiz.online_courses_quiz.model.entity.QuizUserEntity;

@Mapper(componentModel = "spring")
public interface QuizUserMapper {

    QuizUserEntity toEntity(QuizUserDTO quizUserDTO);

    QuizUserDTO toDTO(QuizUserEntity quizUserEntity);
}
