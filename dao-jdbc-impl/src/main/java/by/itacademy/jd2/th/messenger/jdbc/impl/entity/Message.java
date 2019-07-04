package by.itacademy.jd2.th.messenger.jdbc.impl.entity;

import by.itacademy.jd2.th.messenger.dao.api.entity.table.IAttachment;
import by.itacademy.jd2.th.messenger.dao.api.entity.table.IMessage;
import by.itacademy.jd2.th.messenger.dao.api.entity.table.IUserAccount;
import by.itacademy.jd2.th.messenger.dao.api.entity.table.IUserGroup;

public class Message extends BaseEntity implements IMessage {
    String message;
    IMessage parrentMessage;
    IUserAccount user;
    IUserGroup userGroup;
    IAttachment attachment;

    @Override
    public IAttachment getAttachment() {
        return attachment;
    }

    @Override
    public void setAttachment(final IAttachment attachment) {
        this.attachment = attachment;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public void setMessage(final String message) {
        this.message = message;
    }

    @Override
    public IMessage getParrentMessage() {
        return parrentMessage;
    }

    @Override
    public void setParentMessage(final IMessage parrentMessage) {
        this.parrentMessage = parrentMessage;
    }

    @Override
    public IUserAccount getUser() {
        return user;
    }

    @Override
    public void setUser(final IUserAccount user) {
        this.user = user;
    }

    @Override
    public IUserGroup getUserGroup() {
        return userGroup;
    }

    @Override
    public void setUserGroup(final IUserGroup group) {
        this.userGroup = group;
    }

}
