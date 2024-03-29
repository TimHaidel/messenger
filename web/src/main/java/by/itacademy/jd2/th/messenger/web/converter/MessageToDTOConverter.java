package by.itacademy.jd2.th.messenger.web.converter;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import by.itacademy.jd2.th.messenger.dao.api.entity.table.IMessage;
import by.itacademy.jd2.th.messenger.dao.api.entity.table.IUserAccount;
import by.itacademy.jd2.th.messenger.dao.api.entity.table.IUserGroup;
import by.itacademy.jd2.th.messenger.web.dto.MessageDTO;

@Component
public class MessageToDTOConverter implements Function<IMessage, MessageDTO> {

	@Override
	public MessageDTO apply(IMessage entity) {
		MessageDTO dto = new MessageDTO();
		dto.setId(entity.getId());
		dto.setMessage(entity.getMessage());
		dto.setCreated(entity.getCreated());
		dto.setUpdated(entity.getUpdated());
		if (entity.getUser() != null) {
			dto.setUserName(entity.getUser().getFirstname() + " " + entity.getUser().getLastname());
		}

		IUserAccount user = entity.getUser();
		if (user != null) {
			dto.setUserId(entity.getUser().getId());
			;
		}

		IUserGroup userGroup = entity.getUserGroup();
		if (userGroup != null) {
			dto.setUserGroupId(entity.getUserGroup().getId());
		}
		return dto;
	}

}
