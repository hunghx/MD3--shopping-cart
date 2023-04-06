package ra.model.service.user;

import ra.model.entity.User;
import ra.model.service.IGenericService;

public interface IUserService extends IGenericService<User> {
    boolean existedByUserName(String userName);
    boolean existedByEmail(String email);
    boolean checkLogin(String userName, String password);
    User getCurrentLogin();
    void updateUserLogin(User user);
    void logOut();

}
