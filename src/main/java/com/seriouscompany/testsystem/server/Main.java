package com.seriouscompany.testsystem.server;

import com.seriouscompany.testsystem.server.controller.entity.AnswerDAOImpl;
import com.seriouscompany.testsystem.server.controller.entity.EntityDAO;
import com.seriouscompany.testsystem.server.entities.Answer;

public class Main {

    public static void main(String[] args) {
        EntityDAO<Answer> entityDAO = new AnswerDAOImpl();
        Answer answer = new Answer();
        answer.setContent("content");

        entityDAO.create(answer);
    }
}
