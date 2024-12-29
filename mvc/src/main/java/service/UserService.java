package service;

import model.User;

public class UserService {
    public boolean validateUser(User user) {
        // 模拟用户验证，用户名为 admin，密码为 123456
        return "admin".equals(user.getUserName()) && "123456".equals(user.getPassword());
    }
}