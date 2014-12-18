package com.seriouscompany.testsystem.server.entities;

import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "tests")
@NamedQueries({
        @NamedQuery(name = "Test.findAll", query = "SELECT test FROM Test test")
})
public class Test {

    @Id
    @GeneratedValue
    @Column(name = "test_id")
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "test")
    private Collection<Question> questions;

    public Collection<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(Collection<Question> questions) {
        this.questions = questions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
            Test test = (Test) obj;
            return id == test.id;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        HashCodeBuilder hashCodeBuilder = new HashCodeBuilder();
        hashCodeBuilder
                .append(id)
                .append(name);
        return hashCodeBuilder.build();
    }

}
