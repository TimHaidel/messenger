package by.itacademy.jd2.th.messenger.jdbc.impl.entity;

import by.itacademy.jd2.th.messenger.dao.api.entity.table.IUserAccount;
import by.itacademy.jd2.th.messenger.dao.api.entity.table.IUserGroup;
import by.itacademy.jd2.th.messenger.dao.api.entity.table.IUserToUserGroup;

public class UserToUserGroup implements IUserToUserGroup {
    Integer id;
    IUserGroup userGroup;
    IUserAccount user;
    Integer userGroupRole;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(final Integer id) {
        this.id = id;
    }

    @Override
    public IUserGroup getUserGroup() {
        return userGroup;
    }

    @Override
    public void setUserGroup(final IUserGroup userGroup) {
        this.userGroup = userGroup;
    }

    @Override
    public IUserAccount getUser() {
        return user;
    }

    @Override
    public void setUser(final IUserAccount user) {
        this.user = user;
    }

    @Override
    public Integer getUserGroupRole() {
        return userGroupRole;
    }

    @Override
    public void setUserGroupRole(final Integer userGroupRole) {
        this.userGroupRole = userGroupRole;
    }

    @Override
    public String toString() {
        return "UserToUserGroup [id=" + id + ", userGroup=" + userGroup + ", user=" + user + ", userGroupRole="
                + userGroupRole + "]";
    }

}
