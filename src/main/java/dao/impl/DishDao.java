package dao.impl;

import dao.Dao;
import dto.Dish;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import utils.HibernateSessionFactoryUtil;

public class DishDao implements Dao<Dish, Integer> {

    @Override
    public void add(Dish dish) {
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            session.save(dish);
            session.getTransaction().commit();
        }
    }

    @Override
    public Dish findById(Integer id) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Dish dish = session.get(Dish.class, id);
            if (dish != null){
                Hibernate.initialize(dish.getIngredients());
                Hibernate.initialize(dish.getMenus());
            }
            return dish;
        }
    }

    @Override
    public void update(Dish dish) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.update(dish);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(Dish dish) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.delete(dish);
            session.getTransaction().commit();
        }
    }
}
