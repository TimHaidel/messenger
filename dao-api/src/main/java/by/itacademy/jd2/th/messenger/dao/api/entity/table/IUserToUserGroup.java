package by.itacademy.jd2.th.messenger.dao.api.entity.table;

public interface IUserToUserGroup extends IBaseEntity {

	void setUserGroupRole(final Integer userGroupRole);

	Integer getUserGroupRole();

	void setUser(final IUserAccount user);

	IUserAccount getUser();

	void setGroup(IUserGroup group);

	IUserGroup getGroup();

}
