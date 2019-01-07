package cglib;

import cglib.UserServiceCglib;
import cglib.UserService;

public class TestCglib {
    public static void main(String [] args){
        UserServiceCglib userServiceCglib = new UserServiceCglib();
        UserService userService = new UserService();
        UserService userService1 = (UserService) userServiceCglib.getInstance(userService);
        userService1.editUser();
//        userService1.addUser();
    }
}
