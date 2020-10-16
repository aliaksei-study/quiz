package com.example.quiz.model;


import com.example.quiz.model.enumeration.Difficulty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "question")
@Getter
@Setter
@NoArgsConstructor
public class Question extends AbstractAuditingEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "question_text")
    private String questionText;

    @Column(name = "image_path")
    private String imagePath;

    @Enumerated(EnumType.STRING)
    @Column(name = "difficulty_id")
    private Difficulty difficulty;

    @OneToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "question_id")
    Set<Answer> answers;

    public Question(String questionText, String imagePath, Difficulty difficulty, Category category, Set<Answer> answers) {
        this.questionText = questionText;
        this.imagePath = imagePath;
        this.difficulty = difficulty;
        this.category = category;
        this.answers = answers;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (null == obj || this.getClass() != obj.getClass()) {
            return false;
        }
        Question question = (Question) obj;
        return this.category == question.category && this.difficulty == question.difficulty &&
                (null != this.imagePath) && this.imagePath.equals(question.imagePath) &&
                (null != this.questionText) && this.questionText.equals(question.questionText);
    }

    @Override
    public int hashCode() {
        return (31 * ((null == questionText) ? 0 : questionText.hashCode()) +
                31 * ((null == imagePath) ? 0 : imagePath.hashCode()) +
                31 * ((null == difficulty) ? 0 : difficulty.hashCode()) +
                31 * ((null == category) ? 0 : category.hashCode()));
    }
}
