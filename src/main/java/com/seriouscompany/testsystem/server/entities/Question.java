package com.seriouscompany.testsystem.server.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "questions",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"formulation"})
        }
)
public class Question {

    @Id
    @GeneratedValue
    @Column(name = "question_id")
    private int id;

    @Column(name = "formulation")
    private String formulation;

    @OneToMany(mappedBy = "question")
    private List<Answer> answers;

    @ManyToOne
    @JoinColumn(name = "test_id")
    private Test test;

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

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }
}
