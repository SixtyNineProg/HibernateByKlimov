package dao;

import dto.Auto;
import dto.User;

import java.util.List;

public interface InterfaceUserDao {
    User findById(int id);
    void save(User user);
    void update(User user);
    void delete(User user);
    Auto findAutoById(int id);
    List<User> findAll();
}
