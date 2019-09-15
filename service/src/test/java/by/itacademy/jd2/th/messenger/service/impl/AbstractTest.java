package by.itacademy.jd2.th.messenger.service.impl;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import by.itacademy.jd2.th.messenger.dao.api.entity.enums.Roles;
import by.itacademy.jd2.th.messenger.dao.api.entity.table.IAttachment;
import by.itacademy.jd2.th.messenger.dao.api.entity.table.IBaseEntity;
import by.itacademy.jd2.th.messenger.dao.api.entity.table.IContact;
import by.itacademy.jd2.th.messenger.dao.api.entity.table.IMessage;
import by.itacademy.jd2.th.messenger.dao.api.entity.table.ISmile;
import by.itacademy.jd2.th.messenger.dao.api.entity.table.ISmileGroup;
import by.itacademy.jd2.th.messenger.dao.api.entity.table.IUserAccount;
import by.itacademy.jd2.th.messenger.dao.api.entity.table.IUserGroup;
import by.itacademy.jd2.th.messenger.dao.api.entity.table.IUserToGroup;
import by.itacademy.jd2.th.messenger.service.IAttachmentService;
import by.itacademy.jd2.th.messenger.service.IContactService;
import by.itacademy.jd2.th.messenger.service.IMessageService;
import by.itacademy.jd2.th.messenger.service.ISmileGroupService;
import by.itacademy.jd2.th.messenger.service.ISmileService;
import by.itacademy.jd2.th.messenger.service.IUserAccountService;
import by.itacademy.jd2.th.messenger.service.IUserGroupService;
import by.itacademy.jd2.th.messenger.service.IUserToGroupService;

@SpringJUnitConfig(locations = "classpath:service-context-test.xml")
public abstract class AbstractTest {
	@Autowired
	protected IUserAccountService userAccountService;
	@Autowired
	protected IUserGroupService userGroupService;
	@Autowired
	protected IMessageService messageService;
	@Autowired
	protected IContactService contactService;
	@Autowired
	protected IUserToGroupService userToUserGroupService;
	@Autowired
	protected IAttachmentService attachmentService;
	@Autowired
	protected ISmileGroupService smileGroupService;
	@Autowired
	protected ISmileService smileService;

	private static final Random RANDOM = new Random();

	@BeforeEach
	public void setUpMethod() {
		// clean DB recursive
		userToUserGroupService.deleteAll();
		attachmentService.deleteAll();
		// messageService.deleteAllPinned();
		messageService.deleteAll();
		userGroupService.deleteAll();
		contactService.deleteAll();
		userAccountService.deleteAll();
		smileService.deleteAll();
		smileGroupService.deleteAll();
	}

	protected String getRandomPrefix() {
		return RANDOM.nextInt(99999) + "";
	}

	protected int getRandomObjectsCount() {
		return RANDOM.nextInt(9) + 1;
	}

	public Random getRANDOM() {
		return RANDOM;
	}

	protected IMessage pinNewMessage() {
		IMessage message = saveNewMessage();

		IUserAccount user = message.getUser();
		messageService.pinMessage(message.getId(), user.getId());
		return message;
	}

	protected IAttachment attachNewMessage() {
		IMessage newMessage = saveNewMessage();
		final IAttachment attachment = attachmentService.createEntity();
		attachment.setId(newMessage.getId());
		attachment.setMessage(newMessage);
		attachment.setContent("content-" + getRandomPrefix());
		attachment.setContentType(getRandomObjectsCount());
		attachmentService.save(attachment);
		return attachment;
	}

	protected IUserAccount saveNewUserAccount() {
		final IUserAccount entity = userAccountService.createEntity();
		entity.setFirstname("firstName-" + getRandomPrefix());
		entity.setLastname("lastName-" + getRandomPrefix());
		entity.setPassword("password-" + getRandomPrefix());
		entity.setEmail("email-" + getRandomPrefix());
		entity.setAvatar("avatar-" + getRandomPrefix());
		final Roles[] allRoles = Roles.values();
		final int randomIndex = Math.max(0, getRANDOM().nextInt(allRoles.length) - 1);
		entity.setRole(allRoles[randomIndex]);
		userAccountService.save(entity);
		return entity;
	}

	protected IUserGroup saveNewUserGroup() {
		final IUserGroup entity = userGroupService.createEntity();
		entity.setName("Name-" + getRandomPrefix());
		entity.setUsersCount(2);

		userGroupService.save(entity);
		return entity;
	}

	protected IMessage saveNewMessage() {
		final IMessage entity = messageService.createEntity();
		entity.setMessage("message-" + getRandomPrefix());
		entity.setUserGroup(saveNewUserGroup());
		entity.setUser(saveNewUserAccount());
		messageService.save(entity);
		return entity;
	}

	protected IMessage saveNewMessageWithGroup(IUserGroup userGroup) {
		final IMessage entity = messageService.createEntity();
		entity.setMessage("message-" + getRandomPrefix());
		entity.setUserGroup(userGroup);
		entity.setUser(saveNewUserAccount());
		messageService.save(entity);
		return entity;
	}

	protected IContact saveNewContact() {
		final IContact entity = contactService.createEntity();
		entity.setInitiator(saveNewUserAccount());
		entity.setAcceptor(saveNewUserAccount());
		entity.setStatus(13);
		contactService.save(entity);
		return entity;
	}

	protected IUserToGroup saveNewUserToUserGroup() {
		final IUserToGroup entity = userToUserGroupService.createEntity();
		entity.setUser(saveNewUserAccount());
		entity.setGroup(saveNewUserGroup());
		entity.setGroupRole(getRandomObjectsCount());

		userToUserGroupService.save(entity);
		return entity;
	}

	protected ISmileGroup saveNewSmileGroup() {
		final ISmileGroup entity = smileGroupService.createEntity();
		entity.setName("name- " + getRandomPrefix());
		smileGroupService.save(entity);
		return entity;
	}

	protected ISmile saveNewSmile() {
		final ISmile entity = smileService.createEntity();
		entity.setName("name- " + getRandomPrefix());
		entity.setMarker("marker- " + getRandomPrefix());
		entity.setSmileGroup(saveNewSmileGroup());
		smileService.save(entity);
		return entity;
	}

	protected IBaseEntity verifyOrderById(List<? extends IBaseEntity> ascEntities, boolean ascending) {
		IBaseEntity previousEntity = null;
		for (IBaseEntity entity : ascEntities) {
			if (previousEntity == null) {
				previousEntity = entity;
				continue;
			}
			if (ascending) {
				assertTrue(previousEntity.getId() < entity.getId());
			} else {
				assertTrue(previousEntity.getId() > entity.getId());
			}
			previousEntity = entity;
		}
		return previousEntity;
	}

}