package by.itacademy.jd2.th.messenger.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.itacademy.jd2.th.messenger.dao.api.IAttachmentDao;
import by.itacademy.jd2.th.messenger.dao.api.IMessageDao;
import by.itacademy.jd2.th.messenger.dao.api.entity.table.IMessage;
import by.itacademy.jd2.th.messenger.dao.api.entity.table.IUserAccount;
import by.itacademy.jd2.th.messenger.dao.api.filter.MessageFilter;
import by.itacademy.jd2.th.messenger.service.IMessageService;

@Service
public class MessageServiceImpl implements IMessageService {

	private IMessageDao dao;
	private IAttachmentDao attachmentDao;

	@Autowired
	public MessageServiceImpl(IMessageDao dao, IAttachmentDao attachmentDao) {
		super();
		this.dao = dao;
		this.attachmentDao = attachmentDao;
	}

	@Override
	public List<IMessage> getPinnedMessage(final Integer id) {
		final List<Integer> messageIds = dao.getPinnedMessageIds(id);
		
		
		List<IMessage> messages  =new ArrayList<IMessage>();
		for (Integer mId : messageIds) {
			
			messages.add(getFullInfo(mId));
			
		}
		
		return messages;
	}

	@Override
	public void pinMessage(Integer messageId, Integer userId) {

		dao.insertPinMessage(messageId, userId);

	}

	@Override
	public void unpinMessage(Integer messageId) {

		dao.deletePinnedMessage(messageId);

	}

	@Override
	public IMessage createEntity() {
		return dao.createEntity();
	}

	@Override
	public void save(final IMessage entity) {
		final Date modifedOn = new Date();
		entity.setUpdated(modifedOn);
		if (entity.getId() == null) {
			entity.setCreated(modifedOn);
			dao.insert(entity);
		} else {
			dao.update(entity);
		}
	}

	@Override
	public void save(final IMessage... entities) {
		final Date modified = new Date();
		for (final IMessage iMessage : entities) {

			iMessage.setUpdated(modified);
			iMessage.setCreated(modified);

		}

		dao.save(entities);
	}

	@Override
	public IMessage get(final Integer id) {
		final IMessage entity = dao.get(id);
		return entity;
	}

	@Override
	public void delete(final Integer id) {
		attachmentDao.delete(id);
		dao.delete(id);
	}

	@Override
	public void deleteAll() {
		dao.deleteAll();
	}

	@Override
	public void deleteAllPinned(Integer userId) {
		dao.deleteAllPinnedMessages(userId);

	}

	@Override
	public List<IMessage> getAll() {
		final List<IMessage> all = dao.selectAll();
		return all;
	}

	@Override
	public List<IMessage> find(final MessageFilter filter) {
		return dao.find(filter);
	}

	@Override
	public long getCount(final MessageFilter filter) {
		return dao.getCount(filter);
	}

	@Override
	public IMessage getFullInfo(Integer id) {
		return dao.getFullInfo(id);
	}
}
