package by.itacademy.jd2.th.messenger.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.Test;

import by.itacademy.jd2.th.messenger.dao.api.entity.table.IUserAccount;
import by.itacademy.jd2.th.messenger.dao.api.entity.table.IUserGroup;
import by.itacademy.jd2.th.messenger.dao.api.entity.table.IUserToGroup;
import by.itacademy.jd2.th.messenger.dao.api.filter.UserToUserGroupFilter;

public class UserToGroupServiceTest extends AbstractTest {

	@Test
	public void testCreate() {
		final IUserToGroup entity = saveNewUserToUserGroup();

		final IUserToGroup entityFromDb = userToUserGroupService.getFullInfo(entity.getId());

		assertNotNull(entityFromDb);
		assertNotNull(entityFromDb.getId());
		assertEquals(entity.getGroupRole(), entityFromDb.getGroupRole());
		assertEquals(entity.getGroup().getId(), entityFromDb.getGroup().getId());
		assertEquals(entity.getUser().getId(), entityFromDb.getUser().getId());

	}

	@Test
	public void testCreateMultiple() {
		final int initialSize = userToUserGroupService.getAll().size();

		final IUserToGroup entity1 = userToUserGroupService.createEntity();
		entity1.setUser(saveNewUserAccount());
		entity1.setGroup(saveNewUserGroup());
		entity1.setGroupRole(getRandomObjectsCount());
		try {
			final IUserToGroup entity2 = userToUserGroupService.createEntity();
			userToUserGroupService.save(entity1, entity2);
			fail("UserToBunch save should fail if name not specified");
		} catch (final Exception e) {
			assertEquals(initialSize, userToUserGroupService.getAll().size());
		}

	}

	@Test
	public void testUpdate() throws InterruptedException {
		final IUserToGroup entity = saveNewUserToUserGroup();

		final IUserAccount newUser = entity.getUser();
		entity.setUser(newUser);
		Thread.sleep(2000);
		final IUserGroup newBunch = entity.getGroup();
		entity.setGroup(newBunch);
		Thread.sleep(2000);
		entity.setGroupRole(getRandomObjectsCount());

		userToUserGroupService.save(entity);

		final IUserToGroup entityFromDb = userToUserGroupService.getFullInfo(entity.getId());

		assertNotNull(entityFromDb);
		assertEquals(entity.getUser().getId(), entityFromDb.getUser().getId());
		assertEquals(entity.getGroup().getId(), entityFromDb.getGroup().getId());
		assertEquals(entity.getGroupRole(), entityFromDb.getGroupRole());
		assertNotNull(entityFromDb.getId());
	}

	@Test
	public void testGetAll() {
		final int intialCount = userToUserGroupService.getAll().size();

		final int randomObjectsCount = getRandomObjectsCount();
		for (int i = 0; i < randomObjectsCount; i++) {
			saveNewUserToUserGroup();
		}

		final List<IUserToGroup> allEntities = userToUserGroupService.getAll();

		for (final IUserToGroup entityFromDb : allEntities) {
			assertNotNull(entityFromDb.getUser());
			assertNotNull(entityFromDb.getGroup());
			assertNotNull(entityFromDb.getId());
			assertNotNull(entityFromDb.getGroupRole());
		}

		assertEquals(randomObjectsCount + intialCount, allEntities.size());
	}

	@Test
	public void testDelete() {
		final IUserToGroup entity = saveNewUserToUserGroup();
		userToUserGroupService.delete(entity.getId());
		assertNull(userToUserGroupService.get(entity.getId()));
	}

	@Test
	public void testDeleteAll() {
		saveNewUserToUserGroup();
		userToUserGroupService.deleteAll();
		assertEquals(0, userToUserGroupService.getAll().size());
	}

	@Test
	public void testFind() {
		for (int i = 0; i < 6; i++) {
			saveNewUserToUserGroup();
		}

		UserToUserGroupFilter filter = new UserToUserGroupFilter();

		assertEquals(6, userToUserGroupService.getCount(filter));
		assertEquals(6, userToUserGroupService.find(filter).size());

		filter.setLimit(5);
		assertEquals(5, userToUserGroupService.find(filter).size());

		filter.setOffset(5);
		assertEquals(1, userToUserGroupService.find(filter).size());

		filter = new UserToUserGroupFilter();

		filter.setSortColumn("id");
		filter.setSortOrder(true);
		List<IUserToGroup> ascEntities = userToUserGroupService.find(filter);
		verifyOrderById(ascEntities, true);

		filter.setSortOrder(false);
		List<IUserToGroup> descEntities = userToUserGroupService.find(filter);
		verifyOrderById(descEntities, false);
	}

}
