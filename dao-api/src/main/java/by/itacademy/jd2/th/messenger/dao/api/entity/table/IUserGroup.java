package by.itacademy.jd2.th.messenger.dao.api.entity.table;

public interface IUserGroup extends IBaseEntity {

	void setStatus(final int status);

	Integer getStatus();

	void setName(final String name);

	String getName();

}
