package by.itacademy.jd2.th.messenger.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.Test;

import by.itacademy.jd2.th.messenger.dao.api.entity.table.IAttachment;
import by.itacademy.jd2.th.messenger.dao.api.filter.AttachmentFilter;

public class AttachmentServiceTest extends AbstractTest {

	@Test
	public void testCreate() {
		final IAttachment entity = attachNewMessage();

		final IAttachment entityFromDb = attachmentService.get(entity.getId());

		assertNotNull(entityFromDb);
		assertEquals(entity.getContent(), entityFromDb.getContent());
		assertEquals(entity.getContentType().intValue(), entityFromDb.getContentType().intValue());
		assertNotNull(entityFromDb.getId());
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
		assertEquals(entity.getContentType().intValue(), entityFromDb.getContentType().intValue());

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

	@Test
	public void testFind() {
		for (int i = 0; i < 6; i++) {
			attachNewMessage();
		}

		AttachmentFilter filter = new AttachmentFilter();

		assertEquals(6, attachmentService.getCount(filter));
		assertEquals(6, attachmentService.find(filter).size());

		filter.setLimit(5);
		assertEquals(5, attachmentService.find(filter).size());

		filter.setOffset(5);
		assertEquals(1, attachmentService.find(filter).size());

		filter = new AttachmentFilter();

		filter.setSortColumn("id");
		filter.setSortOrder(true);
		List<IAttachment> ascEntities = attachmentService.find(filter);
		verifyOrderById(ascEntities, true);

		filter.setSortOrder(false);
		List<IAttachment> descEntities = attachmentService.find(filter);
		verifyOrderById(descEntities, false);
	}
}
