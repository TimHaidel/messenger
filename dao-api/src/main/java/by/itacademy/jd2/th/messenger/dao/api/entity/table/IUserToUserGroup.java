package by.itacademy.jd2.th.messenger.dao.api.entity.table;

public interface IUserToUserGroup {

    void setUserGroupRole(final Integer userGroupRole);

    Integer getUserGroupRole();

    void setUser(final IUserAccount user);

    IUserAccount getUser();

    void setUserGroup(final IUserGroup userGroup);

    IUserGroup getUserGroup();

    void setId(final Integer id);

    Integer getId();

}
