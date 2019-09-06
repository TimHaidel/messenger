package by.itacademy.jd2.th.messenger.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import by.itacademy.jd2.th.messenger.dao.api.entity.table.IUserGroup;
import by.itacademy.jd2.th.messenger.dao.api.filter.UserGroupFilter;

public class UserGroupServiceTest extends AbstractTest {

	@Test
	public void testCreate() {
		final IUserGroup entity = saveNewUserGroup();

		final IUserGroup entityFromDb = userGroupService.get(entity.getId());

		assertNotNull(entityFromDb);
		assertEquals(entity.getName(), entityFromDb.getName());
		assertEquals(entity.getUsersCount().intValue(), entityFromDb.getUsersCount().intValue());
		assertNotNull(entityFromDb.getId());
		assertNotNull(entityFromDb.getCreated());
		assertNotNull(entityFromDb.getUpdated());
		assertTrue(entityFromDb.getCreated().equals(entityFromDb.getUpdated()));
	}

	@Test
	public void testCreateMultiple() {
		final int initialSize = userGroupService.getAll().size();

		final IUserGroup entity1 = userGroupService.createEntity();
		entity1.setName("Name-" + getRandomPrefix());
		entity1.setUsersCount(2);

		try {
			final IUserGroup entity2 = userGroupService.createEntity();
			userGroupService.save(entity1, entity2);
			fail("Group save should fail if name not specified");
		} catch (final Exception e) {
			assertEquals(initialSize, userAccountService.getAll().size());
		}

	}

	@Test
	public void testUpdate() throws InterruptedException {
		final IUserGroup entity = saveNewUserGroup();

		final String newName = entity.getName() + "_updated";
		entity.setName(newName);
		Thread.sleep(2000);
		final int newStatus = entity.getUsersCount();
		entity.setUsersCount(newStatus);
		Thread.sleep(2000);

		userGroupService.save(entity);

		final IUserGroup entityFromDb = userGroupService.get(entity.getId());

		assertNotNull(entityFromDb);
		assertEquals(entity.getName(), entityFromDb.getName());
		assertEquals(entity.getUsersCount().intValue(), entityFromDb.getUsersCount().intValue());
		assertNotNull(entityFromDb.getId());
		assertNotNull(entityFromDb.getCreated());
		assertNotNull(entityFromDb.getUpdated());
	}

	@Test
	public void testGetAll() {
		final int intialCount = userGroupService.getAll().size();

		final int randomObjectsCount = getRandomObjectsCount();
		for (int i = 0; i < randomObjectsCount; i++) {
			saveNewUserGroup();
		}

		final List<IUserGroup> allEntities = userGroupService.getAll();

		for (final IUserGroup entityFromDb : allEntities) {
			assertNotNull(entityFromDb.getName());
			assertNotNull(entityFromDb.getUsersCount());
			assertNotNull(entityFromDb.getId());
			assertNotNull(entityFromDb.getCreated());
			assertNotNull(entityFromDb.getUpdated());
		}

		assertEquals(randomObjectsCount + intialCount, allEntities.size());
	}

	@Test
	public void testDelete() {
		final IUserGroup entity = saveNewUserGroup();
		userGroupService.delete(entity.getId());
		assertNull(userGroupService.get(entity.getId()));
	}

	@Test
	public void testDeleteAll() {
		saveNewUserGroup();
		userGroupService.deleteAll();
		assertEquals(0, userGroupService.getAll().size());
	}

	@Test
	public void testFind() {
		for (int i = 0; i < 6; i++) {
			saveNewUserGroup();
		}

		UserGroupFilter filter = new UserGroupFilter();

		assertEquals(6, userGroupService.getCount(filter));
		assertEquals(6, userGroupService.find(filter).size());

		filter.setLimit(5);
		assertEquals(5, userGroupService.find(filter).size());

		filter.setOffset(5);
		assertEquals(1, userGroupService.find(filter).size());

		filter = new UserGroupFilter();

		filter.setSortColumn("id");
		filter.setSortOrder(true);
		List<IUserGroup> ascEntities = userGroupService.find(filter);
		verifyOrderById(ascEntities, true);

		filter.setSortOrder(false);
		List<IUserGroup> descEntitties = userGroupService.find(filter);
		verifyOrderById(descEntitties, false);

	}
}
