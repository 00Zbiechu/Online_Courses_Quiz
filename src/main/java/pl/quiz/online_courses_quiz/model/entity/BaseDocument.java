package pl.quiz.online_courses_quiz.model.entity;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
public class BaseDocument {

    @Id
    private String id;
}
