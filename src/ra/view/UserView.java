package ra.view;

import ra.controller.user.UserController;
import ra.dto.request.SignInDTO;
import ra.dto.request.SignUpDTO;
import ra.dto.response.ResponseMassage;
import ra.model.entity.Role;
import ra.model.entity.RoleName;
import ra.model.entity.User;
import ra.validate.Validate;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static ra.config.Config.scanner;
import static ra.validate.Validate.checkPhoneNumber;

public class UserView {
    UserController userController = new UserController();
    List<User> userList = userController.findAll();

    public void register() {
        int id = 0;
        if (userList.size()==0) {
            id = 1;
        }else
        {
            id = userList.get(userList.size() - 1).getUserId() + 1;
        }
        System.out.println("Enter the name: ");
        String name = scanner.nextLine();
        String userName = null;
        while (true) {
            System.out.println("Enter the user name: ");
            userName = scanner.nextLine();
            if (Validate.checkUserName(userName)){
                break;
            }else {

                System.err.println("Username must be at least 6 characters, please try again!");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        String email = null;
        while (true){
            System.out.println(" Enter the email: ");
            email = scanner.nextLine();
            if (Validate.checkEmail(email)){
                break;
            }else {
                System.err.println("invalid email format, please try again!");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        String password = null;
        while (true){
            System.out.println("Enter the password: ");
            password = scanner.nextLine();
            if (Validate.checkUserName(password)){
                break;
            }else {
                System.out.println("Password must be at least 6 characters, please try again!");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        String rePassword = null;
        while (true){
            System.out.println("Enter the re-Password");
            rePassword = scanner.nextLine();
            if (Validate.checkRePassword(password,rePassword)){
                break;
            }else {
                System.err.println("not match to password, please try again!");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        System.out.println("Enter the role: ");
        String role = scanner.nextLine();
        Set<String> strRole = new HashSet<>();
        strRole.add(role);
        SignUpDTO sign = new SignUpDTO(id,name,userName,email,password,rePassword,strRole,true);
        ResponseMassage massage = userController.register(sign);
        if (massage.getMassage().equals("userName is existed")){
            System.err.println("userName is existed, please try again!");
            register();
        }else if (massage.getMassage().equals("email is existed")){
            System.err.println("email is existed, please try again!");
            register();
        }else if (massage.getMassage().equals("register success!")){
            System.out.println("register success!");
        }
    }
    public void showListUser(){
        for (User user:userList) {
            System.out.println(user);
        }
    }
    public void formLogin(){
        System.out.println("=============LOGIN==============");
        while (true){
            SignInDTO sign = new SignInDTO();
            System.out.print("Enter the user name: ");
            sign.setUserName(scanner.nextLine());
            System.out.print("Enter the password: ");
            sign.setPassword(scanner.nextLine());
            ResponseMassage massage = userController.checkLogin(sign);
            if (massage.getMassage().equals("Login Success")){
               proFileView();
            }else {
                System.err.println("Login Fail, Please try again !");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                formLogin();
            }
        }
    }
    public User getUserLogin(){
       return userController.getUserLogin();
    }
    public void proFileView(){
        User userLogin = getUserLogin();
        if (userLogin!=null){
        Set<Role> roleSet = userLogin.getRoles();
        List<Role> roleList = new ArrayList<>(roleSet);
        if (roleList.get(0).getRoleName()== RoleName.ADMIN){
            Main.generalManager();
        }else if (roleList.get(0).getRoleName()== RoleName.PM){
            System.out.println("vao pm ");
            scanner.nextLine();
        }else {
            new Main().viewUser();
        }
        }
        Main.generalShop();
    }
    public void updateUser(){
        User userLogin = getUserLogin();
        System.out.print("Name change is: ");
        userLogin.setName(scanner.nextLine());
        System.out.print("Password change is: ");
        userLogin.setPassword(scanner.nextLine());
        while (true){
            System.out.print("Enter a new password: ");
            String rePassword = scanner.nextLine();
            if (userLogin.getPassword().equals(rePassword)){
                userLogin.setRePassword(rePassword);
                break;
            }else {
                System.err.println("not match to password, please try again!");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        System.out.println("Address change is: ");
        userLogin.setAddress(scanner.nextLine());
        while (true){
            System.out.println("Phone change is: ");
            String phoneNumber = scanner.nextLine();
            if (checkPhoneNumber(phoneNumber)){
                userLogin.setPhone(phoneNumber);
                break;
            }else {
                System.err.println("Phone number not format, please try again!");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        userController.save(userLogin);
        userController.updateUserLogin(userLogin);
        System.out.println("update success");
        proFileView();
    }
    public void logOut(){
        userController.logOut();
        proFileView();
    }

}
