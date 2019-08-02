package by.itacademy.jd2.th.messenger.dao.api.entity.table;

public interface IMessage extends IBaseEntity {

    void setUserGroup(final IUserGroup bunch);

    IUserGroup getUserGroup();

    void setUser(final IUserAccount user);

    IUserAccount getUser();

    void setMessage(final String message);

    String getMessage();

    void setParentMessage(IMessage parrentMessage);

    IMessage getParrentMessage();

	void setAttachment(IAttachment attachment);

	IAttachment getAttachment();

}
