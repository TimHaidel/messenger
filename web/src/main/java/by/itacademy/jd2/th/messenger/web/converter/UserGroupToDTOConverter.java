package by.itacademy.jd2.th.messenger.web.converter;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import by.itacademy.jd2.th.messenger.dao.api.entity.table.IUserGroup;
import by.itacademy.jd2.th.messenger.web.dto.UserGroupDTO;

@Component
public class UserGroupToDTOConverter implements Function<IUserGroup, UserGroupDTO> {

	@Override
	public UserGroupDTO apply(IUserGroup entity) {
		UserGroupDTO dto = new UserGroupDTO();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setStatus(entity.getStatus());
		dto.setCreated(entity.getCreated());
		dto.setUpdated(entity.getUpdated());
		return dto;
	}

}
