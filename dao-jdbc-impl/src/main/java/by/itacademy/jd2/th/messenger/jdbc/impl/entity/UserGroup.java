package by.itacademy.jd2.th.messenger.jdbc.impl.entity;

import by.itacademy.jd2.th.messenger.dao.api.entity.table.IUserGroup;

public class UserGroup extends BaseEntity implements IUserGroup {
    private String name;
    private int status;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(final String name) {
        this.name = name;
    }

    @Override
    public int getStatus() {
        return status;
    }

    @Override
    public void setStatus(final int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "UserGroup [name=" + name + ", status=" + status + "]";
    }

}
