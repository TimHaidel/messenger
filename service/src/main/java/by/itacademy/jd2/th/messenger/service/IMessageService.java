package by.itacademy.jd2.th.messenger.service;

import java.util.List;

import by.itacademy.jd2.th.messenger.dao.api.entity.table.IMessage;
import by.itacademy.jd2.th.messenger.dao.api.filter.MessageFilter;

public interface IMessageService {

    long getCount(final MessageFilter filter);

    List<IMessage> find(final MessageFilter filter);

    List<IMessage> getAll();

    void deleteAll();

    void delete(final Integer id);

    IMessage get(final Integer id);

    void save(final IMessage... entities);

    void save(final IMessage entity);

    IMessage createEntity();

}
