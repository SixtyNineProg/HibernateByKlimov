package dao.impl;

import dao.Dao;
import dto.Ingredient;
import org.hibernate.Session;
import utils.HibernateSessionFactoryUtil;

public class IngredientDao implements Dao<Ingredient, Integer> {

    @Override
    public void add(Ingredient ingredient) {
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            session.save(ingredient);
            session.getTransaction().commit();
        }
    }

    @Override
    public Ingredient findById(Integer id) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            return session.get(Ingredient.class, id);
        }
    }

    @Override
    public void update(Ingredient ingredient) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.update(ingredient);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(Ingredient ingredient) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.delete(ingredient);
            session.getTransaction().commit();
        }
    }
}
