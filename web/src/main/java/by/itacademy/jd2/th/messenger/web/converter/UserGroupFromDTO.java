package by.itacademy.jd2.th.messenger.web.converter;

import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import by.itacademy.jd2.th.messenger.dao.api.entity.table.IUserGroup;
import by.itacademy.jd2.th.messenger.service.IUserGroupService;
import by.itacademy.jd2.th.messenger.web.dto.UserGroupDTO;

@Component
public class UserGroupFromDTO implements Function<UserGroupDTO, IUserGroup> {

	@Autowired
	IUserGroupService userGroupService;

	@Override
	public IUserGroup apply(UserGroupDTO dto) {
		IUserGroup entity = userGroupService.createEntity();
		entity.setCreated(dto.getCreated());
		entity.setId(dto.getId());
		entity.setName(dto.getName());
		entity.setUsersCount(dto.getStatus());
		entity.setUpdated(dto.getUpdated());
		return entity;
	}

}
