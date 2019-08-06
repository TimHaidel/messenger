package by.itacademy.jd2.th.messenger.dao.orm.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import by.itacademy.jd2.th.messenger.dao.api.IAttachmentDao;
import by.itacademy.jd2.th.messenger.dao.api.entity.table.IAttachment;
import by.itacademy.jd2.th.messenger.dao.api.filter.AttachmentFilter;
import by.itacademy.jd2.th.messenger.dao.orm.impl.entity.Attachment;

@Repository
public class AttachmentDaoImpl extends AbstractDaoImpl<IAttachment, Integer> implements IAttachmentDao {

	protected AttachmentDaoImpl() {
		super(Attachment.class);
	}

	@Override
	public IAttachment createEntity() {
		IAttachment attachment = new Attachment();
		return attachment;
	}

	@Override
	public void save(IAttachment[] entities) {
		throw new RuntimeException("Not implimented");

	}

	@Override
	public List<IAttachment> find(AttachmentFilter filter) {
		throw new RuntimeException("Not implimented");
	}

	@Override
	public long getCount(AttachmentFilter filter) {
		throw new RuntimeException("Not implimented");
	}

}
