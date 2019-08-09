package by.itacademy.jd2.th.messenger.dao.api;

import java.util.List;

import by.itacademy.jd2.th.messenger.dao.api.entity.table.IUserToGroup;
import by.itacademy.jd2.th.messenger.dao.api.filter.UserToUserGroupFilter;

public interface IUserToGroupDao extends IDao<IUserToGroup, Integer> {

	List<IUserToGroup> find(UserToUserGroupFilter filter);

	long getCount(UserToUserGroupFilter filter);

	void save(IUserToGroup... entities);

	IUserToGroup getFullInfo(Integer id);

}
