package ra.model.entity;

import java.io.Serializable;
import java.util.StringJoiner;

public class Role implements Serializable {
    private int id;
    private RoleName roleName;

    public Role() {
    }

    public Role(int id, RoleName roleName) {
        this.id = id;
        this.roleName = roleName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public RoleName getRoleName() {
        return roleName;
    }

    public void setRoleName(RoleName roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Role.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("roleName=" + roleName)
                .toString();
    }
}
