package pl.quiz.online_courses_quiz.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Question")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuestionEntity extends BaseEntity {

    private String title;

    private String optionA;

    private String optionB;

    private String optionC;

    private int ans;

    private int chose;
}
