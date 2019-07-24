package by.itacademy.jd2.th.messenger.web.converter;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import by.itacademy.jd2.th.messenger.dao.api.entity.table.IContact;
import by.itacademy.jd2.th.messenger.dao.api.entity.table.IUserAccount;
import by.itacademy.jd2.th.messenger.web.dto.ContactDTO;

@Component
public class ContactToDTOConverter implements Function<IContact, ContactDTO> {

	@Override
	public ContactDTO apply(IContact entity) {
		ContactDTO dto = new ContactDTO();
		dto.setId(entity.getId());
		dto.setCreated(entity.getCreated());
		dto.setStatus(entity.getStatus());

		IUserAccount initiator = entity.getInitiator();
		if (initiator != null) {
			dto.setInitiatorId(initiator.getId());
		}
		IUserAccount acceptor = entity.getAcceptor();
		if (acceptor != null) {
			dto.setAcceptorId(acceptor.getId());
		}

		return dto;
	}

}
