package com.seriouscompany.testsystem.server.entities;

import javax.persistence.*;
import java.util.List;

/**
 * @author Igor
 */
@Entity
@Table(name = "questions")
public class Question {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "formulations")
    private String formulation;

    @OneToMany(mappedBy = "question")
    private List<Answer> answers;

    @ManyToOne
    private Test test;

    @Column(name = "correct_answer")
    private int correctAnswer;

    public String getFormulation() {
        return formulation;
    }

    public void setFormulation(String formulation) {
        this.formulation = formulation;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(int correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
}
