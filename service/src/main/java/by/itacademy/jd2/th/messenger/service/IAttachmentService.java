package by.itacademy.jd2.th.messenger.service;

import java.util.List;

import by.itacademy.jd2.th.messenger.dao.api.entity.table.IAttachment;
import by.itacademy.jd2.th.messenger.dao.api.entity.table.IMessage;
import by.itacademy.jd2.th.messenger.dao.api.filter.AttachmentFilter;

public interface IAttachmentService {

    List<IAttachment> find(AttachmentFilter filter);

    long getCount(final AttachmentFilter filter);

    List<IAttachment> getAll();

    void deleteAll();

    void delete(final Integer id);

    IAttachment get(final Integer id);

    void save(final IAttachment entity);

    IAttachment attachMessage(final IMessage message);

	void update(final IAttachment entity);

}
