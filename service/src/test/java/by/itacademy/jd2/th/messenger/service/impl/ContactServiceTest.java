package by.itacademy.jd2.th.messenger.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.Test;

import by.itacademy.jd2.th.messenger.dao.api.entity.table.IContact;
import by.itacademy.jd2.th.messenger.dao.api.entity.table.IUserAccount;
import by.itacademy.jd2.th.messenger.dao.api.filter.ContactFilter;

public class ContactServiceTest extends AbstractTest {

	@Test
	public void testCreate() {
		final IContact entity = saveNewContact();

		final IContact entityFromDb = contactService.getFullInfo(entity.getId());

		assertNotNull(entityFromDb);
		assertEquals(entity.getInitiator().getId().intValue(), entityFromDb.getInitiator().getId().intValue());
		assertEquals(entity.getAcceptor().getId().intValue(), entityFromDb.getAcceptor().getId().intValue());
		assertEquals(entity.getStatus().intValue(), entityFromDb.getStatus().intValue());
		assertNotNull(entityFromDb.getId());
	}

	@Test
	public void testUpdate() throws InterruptedException {
		final IContact entity = saveNewContact();

		final IUserAccount initiator = saveNewUserAccount();
		entity.setInitiator(initiator);
		Thread.sleep(2000);

		final IUserAccount acceptor = saveNewUserAccount();
		entity.setAcceptor(acceptor);
		Thread.sleep(2000);

		entity.setStatus(getRandomObjectsCount());
		Thread.sleep(2000);
		contactService.save(entity);

		final IContact entityFromDb = contactService.getFullInfo(entity.getId());

		assertNotNull(entityFromDb);
		assertNotNull(entityFromDb.getId());
		assertEquals(entity.getInitiator().getId().intValue(), entityFromDb.getInitiator().getId().intValue());
		assertEquals(entity.getAcceptor().getId().intValue(), entityFromDb.getAcceptor().getId().intValue());
		assertEquals(entity.getStatus().intValue(), entityFromDb.getStatus().intValue());

	}

	@Test
	public void testDelete() {
		final IContact entity = saveNewContact();
		contactService.delete(entity.getId());
		assertNull(contactService.get(entity.getId()));
	}

	@Test
	public void testDeleteAll() {
		saveNewContact();
		contactService.deleteAll();
		assertEquals(0, contactService.getAll().size());
	}

	@Test
	public void testFind() {
		for (int i = 0; i < 6; i++) {
			saveNewContact();
		}

		ContactFilter filter = new ContactFilter();

		assertEquals(6, contactService.getCount(filter));
		assertEquals(6, contactService.find(filter).size());

		filter.setLimit(5);
		assertEquals(5, contactService.find(filter).size());

		filter.setOffset(5);
		assertEquals(1, contactService.find(filter).size());

		filter = new ContactFilter();

		filter.setSortColumn("id");
		filter.setSortOrder(true);
		List<IContact> ascEntities = contactService.find(filter);
		verifyOrderById(ascEntities, true);

		filter.setSortOrder(false);
		List<IContact> descEntities = contactService.find(filter);
		verifyOrderById(descEntities, false);
	}

}
