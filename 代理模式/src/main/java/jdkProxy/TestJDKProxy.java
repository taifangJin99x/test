package jdkProxy;

public class TestJDKProxy {
    public static void main(String[] args) {
        UserService userService = (UserService) new JDKUserServiceProxy(new UserServiceImpl()).getInstance();
        userService.addUser();
    }
}
