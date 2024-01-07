package pl.quiz.online_courses_quiz.mapper;

import org.mapstruct.Mapper;
import pl.quiz.online_courses_quiz.model.document.QuestionDocument;
import pl.quiz.online_courses_quiz.model.dto.QuestionDTO;
import pl.quiz.online_courses_quiz.model.dto.QuestionFormDTO;

@Mapper(componentModel = "spring")
public interface QuestionMapper {

    QuestionDTO toDTO(QuestionDocument questionDocument);

    QuestionFormDTO toQuestionFormDTO(QuestionDocument questionDocument);

    QuestionDocument toDocument(QuestionDTO questionDTO);
}
