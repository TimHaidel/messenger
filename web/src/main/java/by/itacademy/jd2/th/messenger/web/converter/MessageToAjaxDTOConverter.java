package by.itacademy.jd2.th.messenger.web.converter;

import java.util.function.Function;

import by.itacademy.jd2.th.messenger.dao.api.entity.table.IMessage;
import by.itacademy.jd2.th.messenger.web.dto.ajax.MessageAjaxDTO;
import by.itacademy.jd2.th.messenger.web.security.AuthHelper;

public class MessageToAjaxDTOConverter implements Function<IMessage, MessageAjaxDTO> {

	@Override
	public MessageAjaxDTO apply(IMessage entity) {
		MessageAjaxDTO ajaxDto = new MessageAjaxDTO();
		ajaxDto.setMessage(entity.getMessage());
		ajaxDto.setUserGroupId(entity.getUserGroup().getId());
		ajaxDto.setUserAccountId(AuthHelper.getLoggedUserId());
		return ajaxDto;
	}

}
