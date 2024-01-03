package pl.quiz.online_courses_quiz.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "QUESTION")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuestionEntity extends BaseEntity {

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, name = "option_a")
    private String optionA;

    @Column(nullable = false, name = "option_b")
    private String optionB;

    @Column(nullable = false, name = "option_c")
    private String optionC;

    @Column(nullable = false)
    private int answer;

    private int choice;

    @Column(length = 30, nullable = false)
    private String courseTitle;
}
