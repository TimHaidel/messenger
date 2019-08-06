package by.itacademy.jd2.th.messenger.service.impl;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.Test;

import by.itacademy.jd2.th.messenger.dao.api.entity.table.ISmileGroup;
import by.itacademy.jd2.th.messenger.dao.api.filter.SmileGroupFilter;

public class SmileGroupServiceTest extends AbstractTest {

	@Test
	public void testCreate() {
		final ISmileGroup entity = saveNewSmileGroup();

		final ISmileGroup entityFromDb = smileGroupService.get(entity.getId());

		assertNotNull(entityFromDb);
		assertEquals(entity.getName(), entityFromDb.getName());
		assertNotNull(entityFromDb.getId());
	}

	@Test
	public void testUpdate() throws InterruptedException {
		final ISmileGroup entity = saveNewSmileGroup();

		final String newName = "newName- " + getRandomPrefix();
		entity.setName(newName);
		Thread.sleep(2000);

		smileGroupService.save(entity);

		final ISmileGroup entityFromDb = smileGroupService.get(entity.getId());

		assertNotNull(entityFromDb);
		assertNotNull(entityFromDb.getId());
		assertEquals(entity.getName(), entityFromDb.getName());
	}

	@Test
	public void testGetAll() {
		final int intialCount = smileGroupService.getAll().size();

		final int randomObjectsCount = getRandomObjectsCount();
		for (int i = 0; i < randomObjectsCount; i++) {
			saveNewSmileGroup();
		}

		final List<ISmileGroup> allEntities = smileGroupService.getAll();

		for (final ISmileGroup entityFromDb : allEntities) {
			assertNotNull(entityFromDb.getId());
			assertNotNull(entityFromDb.getName());
		}

		assertEquals(randomObjectsCount + intialCount, allEntities.size());
	}

	@Test
	public void testDelete() {
		final ISmileGroup entity = saveNewSmileGroup();
		smileGroupService.delete(entity.getId());
		assertNull(smileGroupService.get(entity.getId()));
	}

	@Test
	public void testDeleteAll() {
		saveNewContact();
		smileGroupService.deleteAll();
		assertEquals(0, smileGroupService.getAll().size());
	}

	@Test
	public void testFind() {
		for (int i = 0; i < 6; i++) {
			saveNewSmileGroup();
		}

		SmileGroupFilter filter = new SmileGroupFilter();

		assertEquals(6, smileGroupService.getCount(filter));
		assertEquals(6, smileGroupService.find(filter).size());

		filter.setLimit(5);
		assertEquals(5, smileGroupService.find(filter).size());

		filter.setOffset(5);
		assertEquals(1, smileGroupService.find(filter).size());

		filter = new SmileGroupFilter();

		filter.setSortColumn("id");
		filter.setSortOrder(true);
		List<ISmileGroup> ascBrands = smileGroupService.find(filter);
		verifyOrderById(ascBrands, true);

		filter.setSortOrder(false);
		List<ISmileGroup> descBrands = smileGroupService.find(filter);
		verifyOrderById(descBrands, false);
	}
	
	protected void verifyOrderById(List<ISmileGroup> ascBrands, boolean ascending) {
		ISmileGroup previousEntity = null;
		for (ISmileGroup entity : ascBrands) {
			if (previousEntity == null) {
				previousEntity = entity;
				continue;
			}
			if (ascending) {
				assertTrue(previousEntity.getId().intValue() < entity.getId().intValue());
			} else {
				assertTrue(previousEntity.getId().intValue() > entity.getId().intValue());
			}
			previousEntity = entity;
		}
	}

}
