package by.itacademy.jd2.th.messenger.dao.orm.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
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
import by.itacademy.jd2.th.messenger.dao.orm.impl.entity.UserGroup_;

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

		final Root<Message> from = cq.from(Message.class);

		Integer userGroupId = filter.getUserGroupId();
		if (userGroupId == null) {
			cq.select(from).orderBy(cb.asc(from.get(Message_.created)));
		} else {
			cq.select(from).orderBy(cb.asc(from.get(Message_.created)))
					.where(cb.equal(from.get(Message_.userGroup).get(UserGroup_.id), filter.getUserGroupId()));

		}
		from.fetch(Message_.user, JoinType.LEFT);
		from.fetch(Message_.attachment, JoinType.LEFT);
		from.fetch(Message_.parentMessage, JoinType.LEFT);
		from.fetch(Message_.userGroup, JoinType.LEFT);

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
		final Root<Message> from = cq.from(Message.class);
		cq.select(cb.count(from));
		final TypedQuery<Long> q = em.createQuery(cq);
		return q.getSingleResult();
	}

	@Override
	public IMessage getFullInfo(Integer id) {
		final EntityManager em = getEntityManager();
		final CriteriaBuilder cb = em.getCriteriaBuilder();

		final CriteriaQuery<IMessage> cq = cb.createQuery(IMessage.class);
		final Root<Message> from = cq.from(Message.class);

		cq.select(from);
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
	public void insertPinMessage(Integer messageId, Integer userId) {
		final EntityManager em = getEntityManager();

		// native query
		Query q = em.createNativeQuery("INSERT INTO pinned_message (message_id, user_id) VALUES (?, ?)");
		q.setParameter(1, messageId);
		q.setParameter(2, userId);
		q.executeUpdate();

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
