package service;



import dao.UserDAO;
import dto.Pageable;
import model.User;

import java.util.List;

public class UserService {
    private UserDAO userDAO = new UserDAO();

    public List<User> findAll(Pageable pageable) {
        return userDAO.findAll(pageable);
    }
    public User findById(int id) {
        return userDAO.findById(id);
    }
    public User findByUsername(String username) {
        return userDAO.findByUsername(username);
    }
    public void create(User user) {
        userDAO.insertUsers(user);
    }
    public void updatePassword(User user) {
        userDAO.updatePassword(user);
    }
    public void updateInfo(User user) {
        userDAO.updateInfo(user);
    }
}
