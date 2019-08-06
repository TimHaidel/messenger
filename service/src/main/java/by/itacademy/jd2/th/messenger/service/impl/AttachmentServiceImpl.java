package by.itacademy.jd2.th.messenger.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.itacademy.jd2.th.messenger.dao.api.IAttachmentDao;
import by.itacademy.jd2.th.messenger.dao.api.entity.table.IAttachment;
import by.itacademy.jd2.th.messenger.dao.api.entity.table.IMessage;
import by.itacademy.jd2.th.messenger.dao.api.filter.AttachmentFilter;
import by.itacademy.jd2.th.messenger.service.IAttachmentService;

@Service
public class AttachmentServiceImpl implements IAttachmentService {

	private final IAttachmentDao dao;

	@Autowired
	public AttachmentServiceImpl(final IAttachmentDao dao) {
		super();
		this.dao = dao;
	}

	@Override
	public IAttachment attachMessage(final IMessage message) {
		final IAttachment attachDao = dao.createEntity();
		attachDao.setId(message.getId());
		return attachDao;
	}

	@Override
	public IAttachment createEntity() {
		return dao.createEntity();
	}

	@Override
	public void save(final IAttachment entity) {
		final Date modifedOn = new Date();
		entity.setUpdated(modifedOn);
		if (entity.getId() == null) {
			entity.setCreated(modifedOn);
			dao.insert(entity);
		} else {
			dao.update(entity);
		}
	}

	@Override
	public void update(final IAttachment entity) {
		final Date modifedOn = new Date();
		entity.setUpdated(modifedOn);
		dao.update(entity);

	}

	@Override
	public IAttachment get(final Integer id) {
		final IAttachment entity = dao.get(id);
		return entity;
	}

	@Override
	public void delete(final Integer id) {
		dao.delete(id);
	}

	@Override
	public void deleteAll() {
		dao.deleteAll();
	}

	@Override
	public List<IAttachment> getAll() {
		final List<IAttachment> all = dao.selectAll();
		return all;
	}

	@Override
	public List<IAttachment> find(final AttachmentFilter filter) {
		return dao.find(filter);
	}

	@Override
	public long getCount(final AttachmentFilter filter) {
		return dao.getCount(filter);
	}

}
