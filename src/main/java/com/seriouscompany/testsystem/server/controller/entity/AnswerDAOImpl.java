package com.seriouscompany.testsystem.server.controller.entity;

import com.seriouscompany.testsystem.server.entities.Answer;
import com.seriouscompany.testsystem.server.utils.HibernateUtil;
import org.hibernate.Session;

public class AnswerDAOImpl implements EntityDAO<Answer> {

    @Override
    public void delete(Answer entity) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(entity);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public void create(Answer entity) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(entity);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

}
