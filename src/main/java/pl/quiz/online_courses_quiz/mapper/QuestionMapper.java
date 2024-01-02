package pl.quiz.online_courses_quiz.mapper;

import org.mapstruct.Mapper;
import pl.quiz.online_courses_quiz.model.dto.QuestionDTO;
import pl.quiz.online_courses_quiz.model.entity.QuestionEntity;

@Mapper(componentModel = "spring")
public interface QuestionMapper {

    QuestionEntity toEntity(QuestionDTO questionDTO);

    QuestionDTO toDTO(QuestionEntity questionEntity);
}
