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

		IUserAccount user = entity.getUser();
		if (user != null) {
			dto.setUser(user);
		}

		IMessage parentMessage = entity.getParentMessage();
		if (parentMessage != null) {
			dto.setParentMessage(parentMessage.getId());
		}

		IUserGroup userGroup = entity.getUserGroup();
		if (userGroup != null) {
			dto.setUserGroup(userGroup);
		}
		return dto;
	}

}
