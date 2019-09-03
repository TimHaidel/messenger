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
import by.itacademy.jd2.th.messenger.web.dto.ajax.MessageAjaxDTO;

@Component
public class MessageFromAjaxDTOConverter implements Function<MessageAjaxDTO, IMessage> {

	@Autowired
	IMessageService messageService;
	@Autowired
	IUserAccountService userAccountService;
	@Autowired
	IUserGroupService userGroupService;

	@Override
	public IMessage apply(MessageAjaxDTO ajaxDto) {
		IMessage entity = messageService.createEntity();
		entity.setMessage(ajaxDto.getMessage());

		IUserAccount user = userAccountService.createEntity();
		user.setId(ajaxDto.getId());
		entity.setUser(user);

		IUserGroup userGroup = userGroupService.createEntity();
		userGroup.setId(ajaxDto.getId());
		entity.setUserGroup(userGroup);

		return entity;
	}

}
