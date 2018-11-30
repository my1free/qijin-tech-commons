package tech.qijin.commons.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.qijin.commons.test.dao.UserDao;
import tech.qijin.commons.test.model.User;

import java.util.List;

/**
 * @author michealyang
 * @date 2018/11/28
 * 开始做眼保健操：←_← ↑_↑ →_→ ↓_↓
 **/
@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public List<User> getUsers() {
        return userDao.getUsers();
    }

    public List<User> getUser(int id) {
        return userDao.getUser(id);
    }
}
