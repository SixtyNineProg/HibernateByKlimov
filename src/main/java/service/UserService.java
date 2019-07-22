package service;

import dao.impl.UserDao;
import dto.Auto;
import dto.User;

import java.util.List;

public class UserService{
    private UserDao userDao;

    public UserService() {
        this.userDao = new UserDao();
    }

    public User findById(int id) {
        return userDao.findById(id);
    }

    public void saveUser(User user) {
        userDao.save(user);
    }

    public void updateUser(User user) {
        userDao.update(user);
    }

    public void deleteUser(User user) {
        userDao.delete(user);
    }

    public Auto findAutoById(int id) {
        return null;
    }

    public List<User> findAll() {
        return null;
    }
}
