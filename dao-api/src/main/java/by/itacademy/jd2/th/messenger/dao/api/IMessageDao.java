package by.itacademy.jd2.th.messenger.dao.api;

import java.util.List;

import by.itacademy.jd2.th.messenger.dao.api.entity.table.IMessage;
import by.itacademy.jd2.th.messenger.dao.api.filter.MessageFilter;

public interface IMessageDao extends IDao<IMessage, Integer> {
	List<IMessage> find(MessageFilter filter);

	long getCount(MessageFilter filter);

	void save(IMessage... entities);

	void deletePinnedMessage(Integer messageId);

	void insertPinMessage(Integer messageId, Integer userAccountId);

	List<Integer> getPinnedMessageIds(Integer id);

	void deleteAllPinnedMessages(Integer userId);

	IMessage getFullInfo(Integer id);
}
