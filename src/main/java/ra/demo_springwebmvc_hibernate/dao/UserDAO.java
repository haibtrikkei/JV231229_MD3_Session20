package ra.demo_springwebmvc_hibernate.dao;

import ra.demo_springwebmvc_hibernate.model.entity.User;

public interface UserDAO {
    public boolean saveUser(User user);
    public User getUserByUserName(String username);
    public boolean checkPasswordUser(User user, String password);
}
