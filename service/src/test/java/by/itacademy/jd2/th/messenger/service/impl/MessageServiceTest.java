package by.itacademy.jd2.th.messenger.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.Test;

import by.itacademy.jd2.th.messenger.dao.api.entity.table.IMessage;
import by.itacademy.jd2.th.messenger.dao.api.entity.table.IUserAccount;
import by.itacademy.jd2.th.messenger.dao.api.entity.table.IUserGroup;

public class MessageServiceTest extends AbstractTest {

    @Test
    public void testCreate() {
        final IMessage entity = saveNewMessage();

        final IMessage entityFromDb = messageService.get(entity.getId());

        assertNotNull(entityFromDb);
        assertEquals(entity.getMessage(), entityFromDb.getMessage());
        // assertEquals(entity.getParrentMessage().getId(),
        // entityFromDb.getParrentMessage().getId());
        assertEquals(entity.getUser().getId(), entityFromDb.getUser().getId());
        assertEquals(entity.getUserGroup().getId(), entityFromDb.getUserGroup().getId());
        assertNotNull(entityFromDb.getId());
        assertNotNull(entityFromDb.getCreated());
        assertNotNull(entityFromDb.getUpdated());

        assertTrue(entityFromDb.getCreated().equals(entityFromDb.getUpdated()));
    }

    @Test
    public void testCreateMultiple() {
        final int initialSize = messageService.getAll().size();

        final IMessage entity1 = messageService.createEntity();
        entity1.setUserGroup(saveNewUserGroup());
        entity1.setUser(saveNewUserAccount());
        entity1.setMessage("message-" + getRandomPrefix());
        try {
            final IMessage entity2 = messageService.createEntity();
            messageService.save(entity1, entity2);
            fail("Message save should fail if name not specified");
        } catch (final Exception e) {
            assertEquals(initialSize, messageService.getAll().size());
        }

    }

    @Test
    public void testUpdate() throws InterruptedException {
        final IMessage entity = saveNewMessage();

        final IUserAccount newUser = entity.getUser();
        entity.setUser(newUser);
        Thread.sleep(2000);
        final IUserGroup newBunch = entity.getUserGroup();
        entity.setUserGroup(newBunch);
        Thread.sleep(2000);
        entity.setMessage("message-" + getRandomPrefix());

        messageService.save(entity);

        final IMessage entityFromDb = messageService.get(entity.getId());

        assertNotNull(entityFromDb);
        assertEquals(entity.getUser().getId(), entityFromDb.getUser().getId());
        assertEquals(entity.getUserGroup().getId(), entityFromDb.getUserGroup().getId());
        assertEquals(entity.getMessage(), entityFromDb.getMessage());
        assertNotNull(entityFromDb.getId());
    }

    @Test
    public void testGetAll() {
        final int intialCount = messageService.getAll().size();

        final int randomObjectsCount = getRandomObjectsCount();
        for (int i = 0; i < randomObjectsCount; i++) {
            saveNewMessage();
        }

        final List<IMessage> allEntities = messageService.getAll();

        for (final IMessage entityFromDb : allEntities) {
            assertNotNull(entityFromDb.getUser());
            assertNotNull(entityFromDb.getUserGroup());
            assertNotNull(entityFromDb.getId());
            assertNotNull(entityFromDb.getMessage());
        }

        assertEquals(randomObjectsCount + intialCount, allEntities.size());
    }

    @Test
    public void testDelete() {
        final IMessage entity = saveNewMessage();
        messageService.delete(entity.getId());
        assertNull(messageService.get(entity.getId()));
    }

    @Test
    public void testDeleteAll() {
        saveNewMessage();
        messageService.deleteAll();
        assertEquals(0, messageService.getAll().size());
    }

}
