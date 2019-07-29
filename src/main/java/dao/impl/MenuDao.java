package dao.impl;

import dao.Dao;
import dto.Menu;
import org.hibernate.Session;
import utils.HibernateSessionFactoryUtil;

public class MenuDao implements Dao<Menu, Integer> {

    @Override
    public void add(Menu menu) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.save(menu);
            session.getTransaction().commit();
        }
    }

    @Override
    public Menu findById(Integer id) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            return session.get(Menu.class, id);
        }
    }

    @Override
    public void update(Menu menu) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.update(menu);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(Menu menu) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.delete(menu);
            session.getTransaction().commit();
        }
    }
}
