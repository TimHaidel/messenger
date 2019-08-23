package by.itacademy.jd2.th.messenger.web.converter;

import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import by.itacademy.jd2.th.messenger.dao.api.entity.table.IMessage;
import by.itacademy.jd2.th.messenger.dao.api.entity.table.IUserAccount;
import by.itacademy.jd2.th.messenger.dao.api.entity.table.IUserGroup;
import by.itacademy.jd2.th.messenger.service.IMessageService;
import by.itacademy.jd2.th.messenger.service.IUserAccountService;
import by.itacademy.jd2.th.messenger.service.IUserGroupService;
import by.itacademy.jd2.th.messenger.web.dto.MessageDTO;

@Component
public class MessageFromDTOConverter implements Function<MessageDTO, IMessage> {

	@Autowired
	IMessageService messageService;
	@Autowired
	IUserAccountService userAccountService;
	@Autowired
	IUserGroupService userGroupService;

	@Override
	public IMessage apply(MessageDTO dto) {
		IMessage entity = messageService.createEntity();
		entity.setId(dto.getId());
		entity.setMessage(dto.getMessage());
		entity.setCreated(dto.getCreated());

		IMessage parentMessage = messageService.createEntity();
		parentMessage.setId(dto.getParentMessage());
		entity.setParentMessage(parentMessage);

		IUserAccount user = dto.getUser();
		// userAccountService.createEntity();
		// user.setId(dto.getId());
		// user.setFirstname(dto.getUser().getFirstname());
		// user.setLastname(dto.getUser().getLastname());
		// user.setCreated(dto.getUser().getCreated());
		// user.setUpdated(dto.getUser().getUpdated());
		// user.setEmail(dto.getUser().getEmail());
		// user.setPhone(dto.getUser().getPhone());
		// user.setPassword(dto.getUser().getPassword());
		// user.setRole(dto.getUser().getRole());
		// user.setAvatar(dto.getUser().getAvatar());
		entity.setUser(user);

		IUserGroup userGroup = dto.getUserGroup();
		entity.setUserGroup(userGroup);

		return entity;
	}

}
