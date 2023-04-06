package ra.model.service.user;

import ra.config.Config;
import ra.model.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserService implements IUserService {
    private static List<User> userList = new Config<User>().readFromFile(Config.PATH_USER);

    @Override
    public List<User> findAll() {
        return userList;
    }

    @Override
    public void save(User user) {
        if (findById(user.getUserId()) == null) {
            userList.add(user);
        } else {
            userList.set(userList.indexOf(findById(user.getUserId())), user);
        }
        new Config<User>().writeToFile(Config.PATH_USER, userList);
    }

    @Override
    public User findById(int id) {
        for (User user : userList) {
            if (user.getUserId() == id) {
                return user;
            }
        }
        return null;
    }

    @Override
    public void delete(int id) {
        for (User user : userList) {
            if (user.getUserId() == id) {
                userList.remove(user);
                new Config<User>().writeToFile(Config.PATH_USER, userList);
                return;
            }
        }
        System.out.println(" id not found! ");

    }

    @Override
    public List<User> searchByName(String searchName) {
        List<User> userListSearch = new ArrayList<>();
        for (User user : userList) {
            if (user.getUserName().toLowerCase().contains(searchName.toLowerCase())) {
                userListSearch.add(user);
            }
        }
        return userListSearch;
    }
    @Override
    public boolean existedByUserName(String userName) {
        for (User user : userList) {
            if (user.getUserName().equals(userName)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean existedByEmail(String email) {
        for (User user:userList) {
            if (user.getEmail().equals(email)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean checkLogin(String userName, String password) {
        List<User> users = new ArrayList<>();
        for (User user:userList) {
            if (user.getUserName().equals(userName)&&user.getPassword().equals(password)){
                users.add(user);
                new Config<User>().writeToFile(Config.PATH_CURRENT_ACCOUNT,users);
                return true;
            }
        }
        return false;
    }
    public User getCurrentLogin(){
        List<User> users = new Config<User>().readFromFile(Config.PATH_CURRENT_ACCOUNT);
        if (users.size()==0){
            return null;
        }else {
         User  currentUser = users.get(0);
         return currentUser;
        }
    }

    @Override
    public void updateUserLogin(User user) {
       List<User> users = new Config<User>().readFromFile(Config.PATH_CURRENT_ACCOUNT);
       users.set(0,user);
        new Config<User>().writeToFile(Config.PATH_CURRENT_ACCOUNT,users);
    }

    @Override
    public void logOut() {
        List<User> users = new Config<User>().readFromFile(Config.PATH_CURRENT_ACCOUNT);
        users.remove(0);
        new Config<User>().writeToFile(Config.PATH_CURRENT_ACCOUNT,users);
    }

}
