package by.itacademy.jd2.th.messenger.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.Test;

import by.itacademy.jd2.th.messenger.dao.api.entity.table.IUserAccount;

public class UserAccountServiceTest extends AbstractTest {

    @Test
    public void testCreate() {
        final IUserAccount entity = saveNewUserAccount();

        final IUserAccount entityFromDb = userAccountService.get(entity.getId());

        assertNotNull(entityFromDb);
        assertEquals(entity.getFirstname(), entityFromDb.getFirstname());
        assertEquals(entity.getLastname(), entityFromDb.getLastname());
        assertNotNull(entityFromDb.getId());
        assertNotNull(entityFromDb.getCreated());
        assertNotNull(entityFromDb.getUpdated());
        assertTrue(entityFromDb.getCreated().equals(entityFromDb.getUpdated()));
    }

    @Test
    public void testCreateMultiple() {
        final int initialSize = userAccountService.getAll().size();

        final IUserAccount entity1 = userAccountService.createEntity();
        entity1.setFirstname("firstName-" + getRandomPrefix());
        entity1.setLastname("lastName-" + getRandomPrefix());
        entity1.setPassword("password-" + getRandomPrefix());
        entity1.setEmail("email-" + getRandomPrefix());
        entity1.setAvatar("avatar-" + getRandomPrefix());
        entity1.setRole(1);

        try {
            final IUserAccount entity2 = userAccountService.createEntity();
            userAccountService.save(entity1, entity2);
            fail("User save should fail if name not specified");
        } catch (final Exception e) {
            assertEquals(initialSize, userAccountService.getAll().size());
        }

    }

    @Test
    public void testUpdate() throws InterruptedException {
        final IUserAccount entity = saveNewUserAccount();

        final String newFirstname = entity.getFirstname() + "_updated";
        entity.setFirstname(newFirstname);
        Thread.sleep(2000);
        final String newLastname = entity.getLastname() + "_updated";
        entity.setLastname(newLastname);
        Thread.sleep(2000);
        final String newPassword = entity.getPassword() + "_updated";
        entity.setPassword(newPassword);
        Thread.sleep(2000);
        final String newEmail = entity.getEmail() + "_updated";
        entity.setEmail(newEmail);
        Thread.sleep(2000);
        final String newAvatar = entity.getAvatar() + "_updated";
        entity.setAvatar(newAvatar);
        Thread.sleep(2000);
        final int newRole = entity.getRole();
        entity.setRole(newRole);
        Thread.sleep(2000);
        userAccountService.save(entity);

        final IUserAccount entityFromDb = userAccountService.get(entity.getId());

        assertNotNull(entityFromDb);
        assertEquals(entity.getFirstname(), entityFromDb.getFirstname());
        assertEquals(entity.getLastname(), entityFromDb.getLastname());
        assertNotNull(entityFromDb.getId());
        assertNotNull(entityFromDb.getCreated());
        assertNotNull(entityFromDb.getUpdated());
    }

    @Test
    public void testGetAll() {
        final int intialCount = userAccountService.getAll().size();

        final int randomObjectsCount = getRandomObjectsCount();
        for (int i = 0; i < randomObjectsCount; i++) {
            saveNewUserAccount();
        }

        final List<IUserAccount> allEntities = userAccountService.getAll();

        for (final IUserAccount entityFromDb : allEntities) {
            assertNotNull(entityFromDb.getFirstname());
            assertNotNull(entityFromDb.getLastname());
            assertNotNull(entityFromDb.getId());
            assertNotNull(entityFromDb.getCreated());
            assertNotNull(entityFromDb.getUpdated());
        }

        assertEquals(randomObjectsCount + intialCount, allEntities.size());
    }

    @Test
    public void testDelete() {
        final IUserAccount entity = saveNewUserAccount();
        userAccountService.delete(entity.getId());
        assertNull(userAccountService.get(entity.getId()));
    }

    @Test
    public void testDeleteAll() {
        saveNewUserAccount();
        userAccountService.deleteAll();
        assertEquals(0, userAccountService.getAll().size());
    }

}