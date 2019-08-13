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

import by.itacademy.jd2.th.messenger.dao.api.IMessageDao;
import by.itacademy.jd2.th.messenger.dao.api.entity.table.IMessage;
import by.itacademy.jd2.th.messenger.dao.api.entity.table.IUserAccount;
import by.itacademy.jd2.th.messenger.dao.api.filter.MessageFilter;
import by.itacademy.jd2.th.messenger.dao.orm.impl.entity.Message;
import by.itacademy.jd2.th.messenger.dao.orm.impl.entity.Message_;
import by.itacademy.jd2.th.messenger.dao.orm.impl.entity.Smile;

@Repository
public class MessageDaoImpl extends AbstractDaoImpl<IMessage, Integer> implements IMessageDao {

	protected MessageDaoImpl() {
		super(Message.class);
	}

	@Override
	public IMessage createEntity() {
		IMessage message = new Message();
		return message;
	}

	@Override
	public List<IMessage> find(MessageFilter filter) {
		final EntityManager em = getEntityManager();
		final CriteriaBuilder cb = em.getCriteriaBuilder();

		final CriteriaQuery<IMessage> cq = cb.createQuery(IMessage.class);

		final Root<Message> from = cq.from(Message.class);// select from smile
		cq.select(from); // select what? select *

		if (filter.getSortColumn() != null) {
			final SingularAttribute<? super Message, ?> sortProperty = toMetamodelFormat(filter.getSortColumn());

			final Path<?> expression = from.get(sortProperty);
			cq.orderBy(new OrderImpl(expression, filter.getSortOrder()));
		}

		final TypedQuery<IMessage> q = em.createQuery(cq);
		setPaging(filter, q);

		return q.getResultList();
	}

	private SingularAttribute<? super Message, ?> toMetamodelFormat(final String sortColumn) {
		switch (sortColumn) {
		case "created":
			return Message_.created;
		case "updated":
			return Message_.updated;
		case "id":
			return Message_.id;
		case "attachment":
			return Message_.attachment;
		case "message":
			return Message_.message;
		case "parentMessage":
			return Message_.parentMessage;
		case "user":
			return Message_.user;
		case "userGroup":
			return Message_.userGroup;
		default:
			throw new UnsupportedOperationException("sorting is not supported by column:" + sortColumn);
		}
	}

	@Override
	public long getCount(MessageFilter filter) {
		final EntityManager em = getEntityManager();
		final CriteriaBuilder cb = em.getCriteriaBuilder();

		final CriteriaQuery<Long> cq = cb.createQuery(Long.class);
		final Root<Message> from = cq.from(Message.class); // select from
		cq.select(cb.count(from)); // select what? select count(*)
		final TypedQuery<Long> q = em.createQuery(cq);
		return q.getSingleResult(); // execute query
	}

	@Override
	public IMessage getFullInfo(Integer id) {
		final EntityManager em = getEntityManager();
		final CriteriaBuilder cb = em.getCriteriaBuilder();

		final CriteriaQuery<IMessage> cq = cb.createQuery(IMessage.class);
		final Root<Message> from = cq.from(Message.class);

		cq.select(from); // define what need to be selected
		from.fetch(Message_.attachment, JoinType.LEFT);
		from.fetch(Message_.parentMessage, JoinType.LEFT);
		from.fetch(Message_.user, JoinType.LEFT);
		from.fetch(Message_.userGroup, JoinType.LEFT);

		cq.where(cb.equal(from.get(Message_.id), id));

		final TypedQuery<IMessage> q = em.createQuery(cq);

		return getSingleResult(q);
	}

	@Override
	public void save(IMessage... entities) {
		throw new RuntimeException("Not implemented");

	}

	@Override
	public void deletePinnedMessage(IMessage message) {
		throw new RuntimeException("Not implemented");

	}

	@Override
	public void insertPinMessage(IMessage message, IUserAccount user) {
		throw new RuntimeException("Not implemented");

	}

	@Override
	public IMessage getPinnedMessage(Integer id) {
		throw new RuntimeException("Not implemented");
	}

	@Override
	public void deleteAllPinnedMessages() {
		throw new RuntimeException("Not implemented");

	}

}