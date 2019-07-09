package by.itacademy.jd2.th.messenger.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import by.itacademy.jd2.th.messenger.dao.api.entity.table.IAttachment;

public class AttachmentServiceTest extends AbstractTest {

	@Test
	public void testCreate() {
		final IAttachment entity = attachNewMessage();

		final IAttachment entityFromDb = attachmentService.get(entity.getId());

		assertNotNull(entityFromDb);
		assertEquals(entity.getContent(), entityFromDb.getContent());
		assertEquals(entity.getContentType(), entityFromDb.getContentType());
		assertNotNull(entityFromDb.getId());
		assertNotNull(entityFromDb.getCreated());
		assertNotNull(entityFromDb.getUpdated());
		assertTrue(entityFromDb.getCreated().equals(entityFromDb.getUpdated()));
	}

	@Test
	public void testUpdate() throws InterruptedException {
		final IAttachment entity = attachNewMessage();

		final String newContent = "new content- " + getRandomPrefix();
		entity.setContent(newContent);
		Thread.sleep(2000);

		final Integer newContentType = getRandomObjectsCount();
		entity.setContentType(newContentType);
		Thread.sleep(2000);

		attachmentService.update(entity);

		final IAttachment entityFromDb = attachmentService.get(entity.getId());

		assertNotNull(entityFromDb);
		assertNotNull(entityFromDb.getId());
		assertEquals(entity.getContent(), entityFromDb.getContent());
		assertEquals(entity.getContentType(), entityFromDb.getContentType());

	}

	@Test
	public void testGetAll() {
		final int intialCount = attachmentService.getAll().size();

		final int randomObjectsCount = getRandomObjectsCount();
		for (int i = 0; i < randomObjectsCount; i++) {
			attachNewMessage();
		}

		final List<IAttachment> allEntities = attachmentService.getAll();

		for (final IAttachment entityFromDb : allEntities) {
			assertNotNull(entityFromDb.getId());
			assertNotNull(entityFromDb.getContent());
			assertNotNull(entityFromDb.getContentType());
		}

		assertEquals(randomObjectsCount + intialCount, allEntities.size());
	}

	@Test
	public void testDelete() {
		final IAttachment entity = attachNewMessage();
		attachmentService.delete(entity.getId());
		assertNull(attachmentService.get(entity.getId()));
	}

	@Test
	public void testDeleteAll() {
		attachNewMessage();
		attachmentService.deleteAll();
		assertEquals(0, attachmentService.getAll().size());
	}

}
