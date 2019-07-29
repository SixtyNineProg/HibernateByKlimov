package dao.impl;

import dao.Dao;
import dto.CookedDish;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import utils.HibernateSessionFactoryUtil;

public class CookedDishDao implements Dao<CookedDish,Integer> {

    @Override
    public void add(CookedDish cookedDish) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.save(cookedDish);
            session.getTransaction().commit();
        }
    }

    @Override
    public CookedDish findById(Integer id) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            CookedDish dish = session.get(CookedDish.class, id);
            if (dish != null){
                Hibernate.initialize(dish.getEmployee());
                Hibernate.initialize(dish.getOrder().getEmployee());
            }
            return dish;
        }
    }

    @Override
    public void update(CookedDish cookedDish) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.update(cookedDish);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(CookedDish cookedDish) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.delete(cookedDish);
            session.getTransaction().commit();
        }
    }
}
