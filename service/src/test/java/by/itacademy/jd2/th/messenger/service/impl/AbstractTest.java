package by.itacademy.jd2.th.messenger.service.impl;

import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import by.itacademy.jd2.th.messenger.dao.api.entity.table.IAttachment;
import by.itacademy.jd2.th.messenger.dao.api.entity.table.IContact;
import by.itacademy.jd2.th.messenger.dao.api.entity.table.IMessage;
import by.itacademy.jd2.th.messenger.dao.api.entity.table.IUserAccount;
import by.itacademy.jd2.th.messenger.dao.api.entity.table.IUserGroup;
import by.itacademy.jd2.th.messenger.dao.api.entity.table.IUserToUserGroup;
import by.itacademy.jd2.th.messenger.service.IAttachmentService;
import by.itacademy.jd2.th.messenger.service.IContactService;
import by.itacademy.jd2.th.messenger.service.IMessageService;
import by.itacademy.jd2.th.messenger.service.IUserAccountService;
import by.itacademy.jd2.th.messenger.service.IUserGroupService;
import by.itacademy.jd2.th.messenger.service.IUserToUserGroupService;

@SpringJUnitConfig(locations = "classpath:service-context.xml")
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
	protected IUserToUserGroupService userToUserGroupService;
	@Autowired
	protected IAttachmentService attachmentService;

	private static final Random RANDOM = new Random();

	@BeforeEach
	public void setUpMethod() {
		// clean DB recursive
		userToUserGroupService.deleteAll();
		messageService.deleteAll();
		userGroupService.deleteAll();
		contactService.deleteAll();
		userAccountService.deleteAll();
		attachmentService.deleteAll();

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

	protected IAttachment saveNewAttachment() {
		final IAttachment entity = attachmentService.createEntity();
		entity.setContent("content-" + getRandomPrefix());
		entity.setContentType(getRandomObjectsCount());
		attachmentService.save(entity);
		return entity;
	}

	protected IUserAccount saveNewUserAccount() {
		final IUserAccount entity = userAccountService.createEntity();
		entity.setFirstname("firstName-" + getRandomPrefix());
		entity.setLastname("lastName-" + getRandomPrefix());
		entity.setPassword("password-" + getRandomPrefix());
		entity.setEmail("email-" + getRandomPrefix());
		entity.setAvatar("avatar-" + getRandomPrefix());
		entity.setRole(1);
		userAccountService.save(entity);
		return entity;
	}

	protected IUserGroup saveNewUserGroup() {
		final IUserGroup entity = userGroupService.createEntity();
		entity.setName("Name-" + getRandomPrefix());
		entity.setStatus(1);

		userGroupService.save(entity);
		return entity;
	}

	protected IMessage saveNewMessage() {
		final IMessage entity = messageService.createEntity();
		entity.setMessage("message-" + getRandomPrefix());
		entity.setAttachment(saveNewAttachment());
		entity.setUserGroup(saveNewUserGroup());
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

	protected IUserToUserGroup saveNewUserToUserGroup() {
		final IUserToUserGroup entity = userToUserGroupService.createEntity();
		entity.setUser(saveNewUserAccount());
		entity.setUserGroup(saveNewUserGroup());
		entity.setUserGroupRole(getRandomObjectsCount());

		userToUserGroupService.save(entity);
		return entity;
	}
}