package by.itacademy.jd2.th.messenger.dao.orm.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.SingularAttribute;

import org.hibernate.jpa.criteria.OrderImpl;
import org.springframework.stereotype.Repository;

import by.itacademy.jd2.th.messenger.dao.api.IContactDao;
import by.itacademy.jd2.th.messenger.dao.api.entity.table.IContact;
import by.itacademy.jd2.th.messenger.dao.api.filter.ContactFilter;
import by.itacademy.jd2.th.messenger.dao.orm.impl.entity.Contact;
import by.itacademy.jd2.th.messenger.dao.orm.impl.entity.Contact_;

@Repository
public class ContactDaoImpl extends AbstractDaoImpl<IContact, Integer> implements IContactDao {

	protected ContactDaoImpl() {
		super(Contact.class);
	}

	@Override
	public IContact createEntity() {
		IContact contact = new Contact();
		return contact;
	}

	@Override
	public List<IContact> find(ContactFilter filter) {
		final EntityManager em = getEntityManager();
		final CriteriaBuilder cb = em.getCriteriaBuilder();

		final CriteriaQuery<IContact> cq = cb.createQuery(IContact.class);

		final Root<Contact> from = cq.from(Contact.class);
		if (filter.getInitiatorId() == null) {
			cq.select(from);
		} else {
			cq.select(from).where(cb.equal(from.get("initiator"), filter.getInitiatorId()));
		}
		from.fetch(Contact_.initiator, JoinType.LEFT);
		from.fetch(Contact_.acceptor, JoinType.LEFT);

		if (filter.getSortColumn() != null) {
			final SingularAttribute<? super Contact, ?> sortProperty = toMetamodelFormat(filter.getSortColumn());

			final Path<?> expression = from.get(sortProperty);
			cq.orderBy(new OrderImpl(expression, filter.getSortOrder()));
		}

		final TypedQuery<IContact> q = em.createQuery(cq);
		setPaging(filter, q);

		return q.getResultList();
	}

	private SingularAttribute<? super Contact, ?> toMetamodelFormat(final String sortColumn) {
		switch (sortColumn) {
		case "created":
			return Contact_.created;
		case "updated":
			return Contact_.updated;
		case "id":
			return Contact_.id;
		case "initiator":
			return Contact_.initiator;
		case "acceptor":
			return Contact_.acceptor;
		case "status":
			return Contact_.status;
		default:
			throw new UnsupportedOperationException("sorting is not supported by column:" + sortColumn);
		}
	}

	@Override
	public long getCount(ContactFilter filter) {
		final EntityManager em = getEntityManager();
		final CriteriaBuilder cb = em.getCriteriaBuilder();

		final CriteriaQuery<Long> cq = cb.createQuery(Long.class);
		final Root<Contact> from = cq.from(Contact.class); // select from
		cq.select(cb.count(from)); // select what? select count(*)
		final TypedQuery<Long> q = em.createQuery(cq);
		return q.getSingleResult(); // execute query
	}

	@Override
	public void save(IContact... entities) {
		throw new RuntimeException("Not implemented");

	}

	@Override
	public IContact getFullInfo(Integer id) {
		final EntityManager em = getEntityManager();
		final CriteriaBuilder cb = em.getCriteriaBuilder();

		final CriteriaQuery<IContact> cq = cb.createQuery(IContact.class);
		final Root<Contact> from = cq.from(Contact.class);

		cq.select(from);
		from.fetch(Contact_.initiator, JoinType.LEFT);
		from.fetch(Contact_.acceptor, JoinType.LEFT);

		cq.where(cb.equal(from.get(Contact_.id), id));

		final TypedQuery<IContact> q = em.createQuery(cq);

		return getSingleResult(q);
	}

}
