package by.itacademy.jd2.th.messenger.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.Test;

import by.itacademy.jd2.th.messenger.dao.api.entity.table.IUserAccount;
import by.itacademy.jd2.th.messenger.dao.api.entity.table.IUserGroup;
import by.itacademy.jd2.th.messenger.dao.api.entity.table.IUserToUserGroup;

public class UserToUserGroupServiceTest extends AbstractTest {

    @Test
    public void testCreate() {
        final IUserToUserGroup entity = saveNewUserToUserGroup();

        final IUserToUserGroup entityFromDb = userToUserGroupService.get(entity.getId());

        assertNotNull(entityFromDb);
        assertNotNull(entityFromDb.getId());
        assertEquals(entity.getUserGroupRole(), entityFromDb.getUserGroupRole());
        assertEquals(entity.getUserGroup().getId(), entityFromDb.getUserGroup().getId());
        assertEquals(entity.getUser().getId(), entityFromDb.getUser().getId());

    }

    @Test
    public void testCreateMultiple() {
        final int initialSize = userToUserGroupService.getAll().size();

        final IUserToUserGroup entity1 = userToUserGroupService.createEntity();
        entity1.setUser(saveNewUserAccount());
        entity1.setUserGroup(saveNewUserGroup());
        entity1.setUserGroupRole(getRandomObjectsCount());
        try {
            final IUserToUserGroup entity2 = userToUserGroupService.createEntity();
            userToUserGroupService.save(entity1, entity2);
            fail("UserToBunch save should fail if name not specified");
        } catch (final Exception e) {
            assertEquals(initialSize, userToUserGroupService.getAll().size());
        }

    }

    @Test
    public void testUpdate() throws InterruptedException {
        final IUserToUserGroup entity = saveNewUserToUserGroup();

        final IUserAccount newUser = entity.getUser();
        entity.setUser(newUser);
        Thread.sleep(2000);
        final IUserGroup newBunch = entity.getUserGroup();
        entity.setUserGroup(newBunch);
        Thread.sleep(2000);
        entity.setUserGroupRole(getRandomObjectsCount());

        userToUserGroupService.save(entity);

        final IUserToUserGroup entityFromDb = userToUserGroupService.get(entity.getId());

        assertNotNull(entityFromDb);
        assertEquals(entity.getUser().getId(), entityFromDb.getUser().getId());
        assertEquals(entity.getUserGroup().getId(), entityFromDb.getUserGroup().getId());
        assertEquals(entity.getUserGroupRole(), entityFromDb.getUserGroupRole());
        assertNotNull(entityFromDb.getId());
    }

    @Test
    public void testGetAll() {
        final int intialCount = userToUserGroupService.getAll().size();

        final int randomObjectsCount = getRandomObjectsCount();
        for (int i = 0; i < randomObjectsCount; i++) {
            saveNewUserToUserGroup();
        }

        final List<IUserToUserGroup> allEntities = userToUserGroupService.getAll();

        for (final IUserToUserGroup entityFromDb : allEntities) {
            assertNotNull(entityFromDb.getUser());
            assertNotNull(entityFromDb.getUserGroup());
            assertNotNull(entityFromDb.getId());
            assertNotNull(entityFromDb.getUserGroupRole());
        }

        assertEquals(randomObjectsCount + intialCount, allEntities.size());
    }

    @Test
    public void testDelete() {
        final IUserToUserGroup entity = saveNewUserToUserGroup();
        userToUserGroupService.delete(entity.getId());
        assertNull(userToUserGroupService.get(entity.getId()));
    }

    @Test
    public void testDeleteAll() {
        saveNewUserToUserGroup();
        userToUserGroupService.deleteAll();
        assertEquals(0, userToUserGroupService.getAll().size());
    }

}
