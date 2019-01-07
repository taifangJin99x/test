package jdkProxy;

public class UserServiceImpl implements UserService {
    @Override
    public void addUser() {
        System.out.println("添加用户");
    }

    @Override
    public void editUser() {
        System.out.println("编辑用户");
    }
}
