package ra.model.entity;

import java.io.Serializable;
import java.util.StringJoiner;

public class Catalog implements Serializable {
    private int id;
    private String name;
    private Boolean status;

    public Catalog() {
    }

    public Catalog(int id, String name, Boolean status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Catalog.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("name='" + name + "'")
                .toString();
    }
}
