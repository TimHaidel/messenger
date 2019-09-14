package by.itacademy.jd2.th.messenger.dao.api;

import java.util.List;

import by.itacademy.jd2.th.messenger.dao.api.entity.table.IMessage;
import by.itacademy.jd2.th.messenger.dao.api.filter.MessageFilter;

public interface IMessageDao extends IDao<IMessage, Integer> {
	List<IMessage> find(MessageFilter filter);

	long getCount(MessageFilter filter);

	void save(IMessage... entities);

	void deletePinnedMessage(Integer messageId);

<<<<<<< HEAD
	void insertPinMessage(Integer messageId, Integer userAccountId);
=======
	void insertPinMessage(Integer messageId, Integer userId);
>>>>>>> d71f6ceb9b32cd04d849108686f943707fcfca4f

	IMessage getFullInfo(Integer id);

	List<Integer> getPinnedMessageIds(Integer id);

	void deleteAllPinnedMessages(Integer userId);
}
