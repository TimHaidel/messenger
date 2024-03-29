package by.itacademy.jd2.th.messenger.dao.api;

import java.util.List;

import by.itacademy.jd2.th.messenger.dao.api.entity.table.IUserGroup;
import by.itacademy.jd2.th.messenger.dao.api.filter.UserGroupFilter;

public interface IUserGroupDao extends IDao<IUserGroup, Integer> {

	List<IUserGroup> find(UserGroupFilter filter);

	long getCount(UserGroupFilter filter);

	Integer findGroupId(Integer user1, Integer user2);

	void save(IUserGroup... entities);

	List<IUserGroup> getLoggedUserGroups(Integer loggedUserId);
}
