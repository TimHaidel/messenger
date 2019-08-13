package by.itacademy.jd2.th.messenger.dao.orm.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.SingularAttribute;

import org.hibernate.jpa.criteria.OrderImpl;
import org.springframework.stereotype.Repository;

import by.itacademy.jd2.th.messenger.dao.api.IAttachmentDao;
import by.itacademy.jd2.th.messenger.dao.api.entity.table.IAttachment;
import by.itacademy.jd2.th.messenger.dao.api.filter.AttachmentFilter;
import by.itacademy.jd2.th.messenger.dao.orm.impl.entity.Attachment;
import by.itacademy.jd2.th.messenger.dao.orm.impl.entity.Attachment_;

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
		final EntityManager em = getEntityManager();
		final CriteriaBuilder cb = em.getCriteriaBuilder();

		final CriteriaQuery<IAttachment> cq = cb.createQuery(IAttachment.class);

		final Root<Attachment> from = cq.from(Attachment.class);// select from smile
		cq.select(from); // select what? select *

		if (filter.getSortColumn() != null) {
			final SingularAttribute<? super Attachment, ?> sortProperty = toMetamodelFormat(filter.getSortColumn());

			final Path<?> expression = from.get(sortProperty);
			cq.orderBy(new OrderImpl(expression, filter.getSortOrder()));
		}

		final TypedQuery<IAttachment> q = em.createQuery(cq);
		setPaging(filter, q);

		return q.getResultList();
	}

	private SingularAttribute<? super Attachment, ?> toMetamodelFormat(final String sortColumn) {
		switch (sortColumn) {
		case "created":
			return Attachment_.created;
		case "updated":
			return Attachment_.updated;
		case "id":
			return Attachment_.id;
		case "content":
			return Attachment_.content;
		case "contentType":
			return Attachment_.contentType;
		case "message":
			return Attachment_.message;
		default:
			throw new UnsupportedOperationException("sorting is not supported by column:" + sortColumn);
		}
	}

	@Override
	public long getCount(AttachmentFilter filter) {
		final EntityManager em = getEntityManager();
		final CriteriaBuilder cb = em.getCriteriaBuilder();

		final CriteriaQuery<Long> cq = cb.createQuery(Long.class);
		final Root<Attachment> from = cq.from(Attachment.class); // select from
		cq.select(cb.count(from)); // select what? select count(*)
		final TypedQuery<Long> q = em.createQuery(cq);
		return q.getSingleResult(); // execute query
	}

}
