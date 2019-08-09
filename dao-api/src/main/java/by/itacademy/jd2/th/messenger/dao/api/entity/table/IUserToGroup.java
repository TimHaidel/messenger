package by.itacademy.jd2.th.messenger.dao.api.entity.table;

public interface IUserToGroup extends IBaseEntity {

	void setUser(final IUserAccount user);

	IUserAccount getUser();

	void setGroup(IUserGroup group);

	IUserGroup getGroup();

	void setGroupRole(Integer groupRole);

	Integer getGroupRole();

}
