package pl.quiz.online_courses_quiz.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Result")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResultEntity extends BaseEntity {

    private String username;

    private int totalCorrect = 0;
}
