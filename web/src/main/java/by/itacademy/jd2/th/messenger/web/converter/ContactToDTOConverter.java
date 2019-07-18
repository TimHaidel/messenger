package by.itacademy.jd2.th.messenger.web.converter;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import by.itacademy.jd2.th.messenger.dao.api.entity.table.IContact;
import by.itacademy.jd2.th.messenger.web.dto.ContactDTO;

@Component
public class ContactToDTOConverter implements Function<IContact, ContactDTO> {

	@Override
	public ContactDTO apply(IContact entity) {
		ContactDTO dto = new ContactDTO();
		dto.setId(entity.getId());
		dto.setInitiatorId(entity.getInitiator().getId());
		dto.setAcceptorId(entity.getAcceptor().getId());
		dto.setCreated(entity.getCreated());
		dto.setStatus(entity.getStatus());
		return dto;
	}

}
