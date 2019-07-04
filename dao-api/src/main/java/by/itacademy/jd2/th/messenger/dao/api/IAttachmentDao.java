package by.itacademy.jd2.th.messenger.dao.api;

import java.util.List;

import by.itacademy.jd2.th.messenger.dao.api.entity.table.IAttachment;
import by.itacademy.jd2.th.messenger.dao.api.filter.AttachmentFilter;

public interface IAttachmentDao extends IDao<IAttachment, Integer> {

    void save(IAttachment[] entities);

    List<IAttachment> find(AttachmentFilter filter);

    long getCount(AttachmentFilter filter);

}
