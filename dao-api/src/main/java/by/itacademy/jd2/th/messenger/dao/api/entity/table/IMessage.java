package by.itacademy.jd2.th.messenger.dao.api.entity.table;

import java.util.Set;

public interface IMessage extends IBaseEntity {

	void setUserGroup(final IUserGroup bunch);

	IUserGroup getUserGroup();

	void setUser(final IUserAccount user);

	IUserAccount getUser();

	void setMessage(final String message);

	String getMessage();

	void setAttachment(IAttachment attachment);

	IAttachment getAttachment();

	void setUserAccounts(Set<IUserAccount> userAccounts);

	Set<IUserAccount> getUserAccounts();

	void setParentMessage(IMessage parentMessage);

	IMessage getParentMessage();

}
