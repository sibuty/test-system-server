package com.seriouscompany.testsystem.server.entities;

import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;

@Entity
@Table(name = "answers")
@NamedQueries({
        @NamedQuery(name = "Answer.findAll",    query = "SELECT answer FROM Answer answer"),
        @NamedQuery(name = "Answer.findById",   query = "SELECT answer FROM Answer answer where id = :id")
})
public class Answer {

    @Id
    @Column(name = "answer_id")
    @GeneratedValue
    private int id;

    @Column(name = "is_correct")
    private boolean isCorrect;

    @Column(name = "content")
    private String content;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean isCorrect) {
        this.isCorrect = isCorrect;
    }


    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof Answer) {
            Answer answer = (Answer) obj;
            return id == answer.id;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        HashCodeBuilder hashCodeBuilder = new HashCodeBuilder();
        hashCodeBuilder
                .append(id)
                .append(content);
        return hashCodeBuilder.build();
    }

}
