package by.itacademy.jd2.th.messenger.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.Test;

import by.itacademy.jd2.th.messenger.dao.api.entity.table.ISmile;
import by.itacademy.jd2.th.messenger.dao.api.entity.table.ISmileGroup;
import by.itacademy.jd2.th.messenger.dao.api.filter.SmileFilter;

public class SmileServiceTest extends AbstractTest {

	@Test
	public void testCreate() {
		final ISmile entity = saveNewSmile();

		final ISmile entityFromDb = smileService.getFullInfo(entity.getId());

		assertNotNull(entityFromDb);
		assertEquals(entity.getName(), entityFromDb.getName());
		assertEquals(entity.getMarker(), entityFromDb.getMarker());
		assertEquals(entity.getSmileGroup().getId(), entityFromDb.getSmileGroup().getId());
		assertNotNull(entityFromDb.getId());
	}

	@Test
	public void testUpdate() throws InterruptedException {
		final ISmile entity = saveNewSmile();

		final ISmileGroup smileGroup = saveNewSmileGroup();
		entity.setSmileGroup(smileGroup);
		Thread.sleep(2000);

		final String newName = "newName- " + getRandomPrefix();
		entity.setName(newName);
		Thread.sleep(2000);

		final String newMarker = "newMarker- " + getRandomPrefix();
		entity.setMarker(newMarker);
		Thread.sleep(2000);
		smileService.save(entity);

		final ISmile entityFromDb = smileService.getFullInfo(entity.getId());

		assertNotNull(entityFromDb);
		assertNotNull(entityFromDb.getId());
		assertEquals(entity.getName(), entityFromDb.getName());
		assertEquals(entity.getMarker(), entityFromDb.getMarker());
		assertEquals(entity.getSmileGroup().getId().intValue(), entityFromDb.getSmileGroup().getId().intValue());

	}

	@Test
	public void testGetAll() {
		final int intialCount = smileService.getAll().size();

		final int randomObjectsCount = getRandomObjectsCount();
		for (int i = 0; i < randomObjectsCount; i++) {
			saveNewSmile();
		}

		final List<ISmile> allEntities = smileService.getAll();

		for (final ISmile entityFromDb : allEntities) {
			assertNotNull(entityFromDb.getId());
			assertNotNull(entityFromDb.getName());
			assertNotNull(entityFromDb.getMarker());
			assertNotNull(entityFromDb.getSmileGroup());
		}

		assertEquals(randomObjectsCount + intialCount, allEntities.size());
	}

	@Test
	public void testDelete() {
		final ISmile entity = saveNewSmile();
		smileService.delete(entity.getId());
		assertNull(smileService.get(entity.getId()));
	}

	@Test
	public void testDeleteAll() {
		saveNewSmile();
		smileService.deleteAll();
		assertEquals(0, smileService.getAll().size());
	}

	@Test
	public void testFind() {
		for (int i = 0; i < 6; i++) {
			saveNewSmile();
		}

		SmileFilter filter = new SmileFilter();

		assertEquals(6, smileService.getCount(filter));
		assertEquals(6, smileService.find(filter).size());

		filter.setLimit(5);
		assertEquals(5, smileService.find(filter).size());

		filter.setOffset(5);
		assertEquals(1, smileService.find(filter).size());

		filter = new SmileFilter();

		filter.setSortColumn("id");
		filter.setSortOrder(true);
		List<ISmile> ascEntities = smileService.find(filter);
		verifyOrderById(ascEntities, true);

		filter.setSortOrder(false);
		List<ISmile> descEntities = smileService.find(filter);
		verifyOrderById(descEntities, false);
	}

}
