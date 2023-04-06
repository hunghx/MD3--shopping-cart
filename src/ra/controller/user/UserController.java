package ra.controller.user;

import ra.controller.user.IUserController;
import ra.dto.request.SignInDTO;
import ra.dto.request.SignUpDTO;
import ra.dto.response.ResponseMassage;
import ra.model.entity.Role;
import ra.model.entity.RoleName;
import ra.model.entity.User;
import ra.model.service.role.IRoleService;
import ra.model.service.role.RoleServiceIMPL;
import ra.model.service.user.IUserService;
import ra.model.service.user.UserService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserController implements IUserController {
    private static IRoleService roleService = new RoleServiceIMPL();

    private static IUserService userService = new UserService();


    @Override
    public List<User> findAll() {
        return userService.findAll();
    }

    @Override
    public void save(User user) {
        userService.save(user);
    }

    @Override
    public User findById(int id) {
        return userService.findById(id);
    }

    @Override
    public void delete(int id) {
        userService.delete(id);
    }

    @Override
    public List<User> searchByName(String searchName) {
        return userService.searchByName(searchName);
    }

    public ResponseMassage register(SignUpDTO sign) {
        if (userService.existedByUserName(sign.getUserName())) {
            return new ResponseMassage("userName is existed");
        }
        if (userService.existedByEmail(sign.getEmail())) {
            return new ResponseMassage("email is existed");
        }
        Set<Role> roleSet = new HashSet<>();
        Set<String> srtRole = sign.getStrRole();
        srtRole.forEach(role->{
            switch (role){
                case "admin":
                    roleSet.add(roleService.findByName(RoleName.ADMIN));
                    break;
                case "pm":
                    roleSet.add(roleService.findByName(RoleName.PM));
                    break;
                default:
                    roleSet.add(roleService.findByName(RoleName.USER));
            }
        });
        User user = new User(sign.getId(),sign.getName(), sign.getUserName(),sign.getEmail(),sign.getPassword(),sign.getRePassword(),roleSet,sign.isStatus());
        userService.save(user);
        return new ResponseMassage("register success!");
    }
    public ResponseMassage checkLogin(SignInDTO sign){
        if (userService.checkLogin(sign.getUserName(),sign.getPassword())){
            return new ResponseMassage("Login Success");
        }else {
            return new ResponseMassage("Login fail");
        }
    }
    public User getUserLogin(){
       return userService.getCurrentLogin();
    }
    public void updateUserLogin(User user){
        userService.updateUserLogin(user);
    }
    public void logOut(){
        userService.logOut();
    }
}
