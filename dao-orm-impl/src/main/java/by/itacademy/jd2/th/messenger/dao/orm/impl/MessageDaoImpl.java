package by.itacademy.jd2.th.messenger.dao.orm.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import by.itacademy.jd2.th.messenger.dao.api.IMessageDao;
import by.itacademy.jd2.th.messenger.dao.api.entity.table.IMessage;
import by.itacademy.jd2.th.messenger.dao.api.entity.table.IUserAccount;
import by.itacademy.jd2.th.messenger.dao.api.filter.MessageFilter;
import by.itacademy.jd2.th.messenger.dao.orm.impl.entity.Message;

@Repository
public class MessageDaoImpl extends AbstractDaoImpl<IMessage, Integer> implements IMessageDao {

	protected MessageDaoImpl() {
		super(Message.class);
	}

	@Override
	public IMessage createEntity() {
		IMessage message = new Message();
		return message;
	}

	@Override
	public List<IMessage> find(MessageFilter filter) {
		throw new RuntimeException("Not implemented");
	}

	@Override
	public long getCount(MessageFilter filter) {
		throw new RuntimeException("Not implemented");
	}

	@Override
	public void save(IMessage... entities) {
		throw new RuntimeException("Not implemented");

	}

	@Override
	public void deletePinnedMessage(IMessage message) {
		throw new RuntimeException("Not implemented");

	}

	@Override
	public void insertPinMessage(IMessage message, IUserAccount user) {
		throw new RuntimeException("Not implemented");

	}

	@Override
	public IMessage getPinnedMessage(Integer id) {
		throw new RuntimeException("Not implemented");
	}

	@Override
	public void deleteAllPinnedMessages() {
		throw new RuntimeException("Not implemented");

	}

}
