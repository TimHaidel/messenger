package by.itacademy.jd2.th.messenger.service;

import java.util.List;

import javax.transaction.Transactional;

import by.itacademy.jd2.th.messenger.dao.api.entity.table.IMessage;
import by.itacademy.jd2.th.messenger.dao.api.entity.table.IUserAccount;
import by.itacademy.jd2.th.messenger.dao.api.filter.MessageFilter;

public interface IMessageService {

	long getCount(final MessageFilter filter);

	List<IMessage> find(final MessageFilter filter);

	List<IMessage> getAll();

	@Transactional
	void deleteAll();

	@Transactional
	void delete(final Integer id);

	IMessage get(final Integer id);

	@Transactional
	void save(final IMessage... entities);

	@Transactional
	void save(final IMessage entity);

	IMessage createEntity();

	@Transactional
	void unpinMessage(IMessage message);

	@Transactional
	void pinMessage(Integer messageId, Integer userId);

	@Transactional
	void deleteAllPinned(Integer userId);

	IMessage getFullInfo(Integer id);

	List<IMessage> getPinnedMessage(final Integer id);

}
