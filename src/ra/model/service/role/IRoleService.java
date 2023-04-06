package ra.model.service.role;

import ra.model.entity.RoleName;

import ra.model.entity.Role;
import java.util.List;

public interface IRoleService {
    List<Role> findAll();
    Role findByName(RoleName roleName);
}
