package by.itacademy.jd2.th.messenger.web.converter;

import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import by.itacademy.jd2.th.messenger.dao.api.entity.table.IContact;
import by.itacademy.jd2.th.messenger.dao.api.entity.table.IUserAccount;
import by.itacademy.jd2.th.messenger.service.IContactService;
import by.itacademy.jd2.th.messenger.service.IUserAccountService;
import by.itacademy.jd2.th.messenger.web.dto.ContactDTO;

@Component
public class ContactFromDTOConverter implements Function<ContactDTO, IContact> {

	@Autowired
	IContactService contactService;
	@Autowired
	IUserAccountService userAccountService;

	@Override
	public IContact apply(ContactDTO dto) {
		IContact entity = contactService.createEntity();
		entity.setId(dto.getId());
		entity.setStatus(dto.getStatus());
		entity.setCreated(dto.getCreated());

		IUserAccount initiator = userAccountService.createEntity();
		initiator.setId(dto.getInitiatorId());
		IUserAccount acceptor = userAccountService.createEntity();
		acceptor.setId(dto.getAcceptorId());

		entity.setInitiator(initiator);
		entity.setAcceptor(acceptor);
		return entity;
	}

}
