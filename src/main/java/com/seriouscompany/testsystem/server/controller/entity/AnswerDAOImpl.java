package com.seriouscompany.testsystem.server.controller.entity;

import com.seriouscompany.testsystem.server.entities.Answer;
import com.seriouscompany.testsystem.server.utils.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class AnswerDAOImpl implements GenericDao<Answer> {

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
    public Answer find(Integer id) {
        Answer answer = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            answer = (Answer) session.getNamedQuery("Answer.findById").setParameter("id", id).uniqueResult();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return answer;
    }

    @Override
    public void save(Answer entity) {
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

    @SuppressWarnings("unchecked")
    @Override
    public List<Answer> findAll() {
        List<Answer> answers = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            answers = (List<Answer>) session.getNamedQuery("Answer.findAll").list();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return answers;
    }

}
