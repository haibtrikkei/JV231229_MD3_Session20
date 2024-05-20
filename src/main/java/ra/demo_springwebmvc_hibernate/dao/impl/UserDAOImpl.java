package ra.demo_springwebmvc_hibernate.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import ra.demo_springwebmvc_hibernate.dao.RoleDAO;
import ra.demo_springwebmvc_hibernate.dao.UserDAO;
import ra.demo_springwebmvc_hibernate.model.entity.Role;
import ra.demo_springwebmvc_hibernate.model.entity.RoleName;
import ra.demo_springwebmvc_hibernate.model.entity.User;

import java.util.HashSet;
import java.util.Set;
import org.mindrot.jbcrypt.BCrypt;

@Repository
@EnableTransactionManagement
public class UserDAOImpl implements UserDAO {
    @Autowired
    private SessionFactory sessionFactory;
    @Autowired
    private RoleDAO roleDAO;

    @Override
    @Transactional
    public boolean saveUser(User user) {
        Session session = sessionFactory.openSession();
        try{
            Role role = roleDAO.getRoleByRoleName(RoleName.ROLE_USER.toString());
            Set<Role> roles = new HashSet<>();
            roles.add(role);
            user.setRoleSet(roles);
            user.setPassword(BCrypt.hashpw(user.getPassword(),BCrypt.gensalt(12)));
            session.save(user);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public User getUserByUserNameAndPass(String username, String password) {
        Session session = sessionFactory.openSession();
        try {

        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            session.close();
        }
        return null;
    }
}
