package dao.impl;

import dao.Dao;
import dto.CookedDish;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class CookedDishDao implements Dao<CookedDish,Integer> {

    private final SessionFactory factory;

    public CookedDishDao(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void add(CookedDish cookedDish) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            session.save(cookedDish);
            session.getTransaction().commit();
        }
    }

    @Override
    public CookedDish findById(Integer id) {
        try (Session session = factory.openSession()) {
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
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            session.update(cookedDish);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(CookedDish cookedDish) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            session.delete(cookedDish);
            session.getTransaction().commit();
        }
    }
}
