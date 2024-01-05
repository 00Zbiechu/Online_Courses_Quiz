package pl.quiz.online_courses_quiz.mapper;

import org.mapstruct.Mapper;
import pl.quiz.online_courses_quiz.model.dto.QuestionDTO;
import pl.quiz.online_courses_quiz.model.dto.QuestionFormDTO;
import pl.quiz.online_courses_quiz.model.entity.QuestionDocument;

@Mapper(componentModel = "spring")
public interface QuestionMapper {

    QuestionDTO toDTO(QuestionDocument questionDocument);

    QuestionFormDTO toQuestionFormDTO(QuestionDocument questionDocument);

    QuestionDocument toDocument(QuestionDTO questionDTO);
}
