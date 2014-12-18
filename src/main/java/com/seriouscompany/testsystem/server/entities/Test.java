package com.seriouscompany.testsystem.server.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tests")
public class Test {

    @Id
    @Column(name = "test_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToMany(mappedBy = "que")
    private List<Question> questions;

    private String theme;
    private String name;
    private List<Question> questions;

    public Test() {
        this.questions = new ArrayList<>();
    }

    public Test(String theme, String name) {
        this.theme = theme;
        this.name = name;
        this.questions = new ArrayList<>();
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Question[] getQuestions() {
        return questions.toArray(new Question[questions.size()]);
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public void removeQuestionByIndex(int index) {
        questions.remove(index);
    }

    public boolean removeQuestionByName(Question question) {
        return questions.remove(question);
    }

    public Question getQuestion(int index) {
        return questions.get(index);
    }

    public void setQuestion(Question question, int index) {
        questions.set(index, question);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (this == obj) {
            return true;
        }

        if (obj instanceof Test) {
            Test anotherTest = (Test) obj;
            if (!theme.equals(anotherTest.theme)
                    || !name.equals(anotherTest.name)
                    || !questions.equals(anotherTest.questions)) {
                return false;
            }
        } else {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.theme);
        hash = 59 * hash + Objects.hashCode(this.name);
        hash = 59 * hash + Objects.hashCode(this.questions);
        return hash;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String lineSeparator = System.getProperty("line.separator");
        sb.append("Theme :")
                .append(lineSeparator)
                .append(theme)
                .append("Name :")
                .append(name);
        for (Question question : questions) {
            sb.append(lineSeparator).append(question);
        }
        return sb.toString();
    }

}
