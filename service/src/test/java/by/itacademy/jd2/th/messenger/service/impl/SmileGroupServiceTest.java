package by.itacademy.jd2.th.messenger.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.Test;

import by.itacademy.jd2.th.messenger.dao.api.entity.table.ISmileGroup;

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

}
