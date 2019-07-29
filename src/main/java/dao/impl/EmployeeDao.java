package dao.impl;

import dao.Dao;
import dto.Employee;
import org.hibernate.Session;
import utils.HibernateSessionFactoryUtil;

public class EmployeeDao implements Dao<Employee, Integer> {

    @Override
    public void add(Employee employee) {
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            session.save(employee);
            session.getTransaction().commit();
        }
    }

    @Override
    public Employee findById(Integer id) {
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            return session.get(Employee.class, id);
        }
    }

    @Override
    public void update(Employee employee) {
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            session.update(employee);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(Employee entity) {
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            session.delete(entity);
            session.getTransaction().commit();
        }
    }
}
