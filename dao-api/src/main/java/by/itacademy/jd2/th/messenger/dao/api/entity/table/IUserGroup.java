package by.itacademy.jd2.th.messenger.dao.api.entity.table;

public interface IUserGroup extends IBaseEntity {

	void setName(final String name);

	String getName();

	void setUsersCount(Integer usersCount);

	Integer getUsersCount();

}
