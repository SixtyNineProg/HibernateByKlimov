package dao.impl;

import dao.Dao;
import dto.Order;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import utils.HibernateSessionFactoryUtil;

public class OrderDao implements Dao<Order, Integer> {

    @Override
    public void add(Order order) {
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            session.save(order);
            session.getTransaction().commit();
        }
    }

    @Override
    public Order findById(Integer id) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Order order = session.get(Order.class, id);
            if (order != null){
                Hibernate.initialize(order.getEmployee());
            }
            return order;
        }
    }

    @Override
    public void update(Order order) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.update(order);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(Order order) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.delete(order);
            session.getTransaction().commit();
        }
    }
}
