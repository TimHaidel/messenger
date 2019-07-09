package by.itacademy.jd2.th.messenger.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.Test;

import by.itacademy.jd2.th.messenger.dao.api.entity.table.IContact;
import by.itacademy.jd2.th.messenger.dao.api.entity.table.IUserAccount;

public class ContactServiceTest extends AbstractTest {

	@Test
	public void testCreate() {
		final IContact entity = saveNewContact();

		final IContact entityFromDb = contactService.get(entity.getId());

		assertNotNull(entityFromDb);
		assertEquals(entity.getInitiator().getId(), entityFromDb.getInitiator().getId());
		assertEquals(entity.getAcceptor().getId(), entityFromDb.getAcceptor().getId());
		assertEquals(entity.getStatus(), entityFromDb.getStatus());
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

		final IContact entityFromDb = contactService.get(entity.getId());

		assertNotNull(entityFromDb);
		assertNotNull(entityFromDb.getId());
		assertEquals(entity.getInitiator().getId(), entityFromDb.getInitiator().getId());
		assertEquals(entity.getAcceptor().getId(), entityFromDb.getAcceptor().getId());
		assertEquals(entity.getStatus(), entityFromDb.getStatus());

	}

	@Test
	public void testGetAll() {
		final int intialCount = contactService.getAll().size();

		final int randomObjectsCount = getRandomObjectsCount();
		for (int i = 0; i < randomObjectsCount; i++) {
			saveNewContact();
		}

		final List<IContact> allEntities = contactService.getAll();

		for (final IContact entityFromDb : allEntities) {
			assertNotNull(entityFromDb.getId());
			assertNotNull(entityFromDb.getInitiator().getId());
			assertNotNull(entityFromDb.getAcceptor().getId());
			assertNotNull(entityFromDb.getStatus());
		}

		assertEquals(randomObjectsCount + intialCount, allEntities.size());
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

}
