package by.itacademy.jd2.th.messenger.service;

import java.util.List;

import javax.transaction.Transactional;

import by.itacademy.jd2.th.messenger.dao.api.entity.table.IAttachment;
import by.itacademy.jd2.th.messenger.dao.api.entity.table.IMessage;
import by.itacademy.jd2.th.messenger.dao.api.filter.AttachmentFilter;

public interface IAttachmentService {

	List<IAttachment> find(AttachmentFilter filter);

	long getCount(final AttachmentFilter filter);

	List<IAttachment> getAll();

	@Transactional
	void deleteAll();

	@Transactional
	void delete(final Integer id);

	IAttachment get(final Integer id);

	@Transactional
	void save(final IAttachment entity);

	@Transactional
	void update(final IAttachment entity);

	IAttachment createEntity();

}
