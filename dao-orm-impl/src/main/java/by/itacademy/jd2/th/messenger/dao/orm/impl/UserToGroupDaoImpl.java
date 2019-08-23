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

import by.itacademy.jd2.th.messenger.dao.api.IUserToGroupDao;
import by.itacademy.jd2.th.messenger.dao.api.entity.table.IUserToGroup;
import by.itacademy.jd2.th.messenger.dao.api.filter.UserToUserGroupFilter;
import by.itacademy.jd2.th.messenger.dao.orm.impl.entity.Smile_;
import by.itacademy.jd2.th.messenger.dao.orm.impl.entity.UserToGroup;
import by.itacademy.jd2.th.messenger.dao.orm.impl.entity.UserToGroup_;

@Repository
public class UserToGroupDaoImpl extends AbstractDaoImpl<IUserToGroup, Integer> implements IUserToGroupDao {

	protected UserToGroupDaoImpl() {
		super(UserToGroup.class);
	}

	@Override
	public IUserToGroup createEntity() {
		IUserToGroup userToUserGroup = new UserToGroup();
		return userToUserGroup;
	}

	@Override
	public List<IUserToGroup> find(UserToUserGroupFilter filter) {
		final EntityManager em = getEntityManager();
		final CriteriaBuilder cb = em.getCriteriaBuilder();

		final CriteriaQuery<IUserToGroup> cq = cb.createQuery(IUserToGroup.class);

		final Root<UserToGroup> from = cq.from(UserToGroup.class);
		cq.select(from);

		if (filter.getSortColumn() != null) {
			final SingularAttribute<? super UserToGroup, ?> sortProperty = toMetamodelFormat(filter.getSortColumn());

			final Path<?> expression = from.get(sortProperty);
			cq.orderBy(new OrderImpl(expression, filter.getSortOrder()));
		}

		final TypedQuery<IUserToGroup> q = em.createQuery(cq);
		setPaging(filter, q);

		return q.getResultList();
	}

	private SingularAttribute<? super UserToGroup, ?> toMetamodelFormat(final String sortColumn) {
		switch (sortColumn) {
		case "created":
			return UserToGroup_.created;
		case "updated":
			return UserToGroup_.updated;
		case "id":
			return UserToGroup_.id;
		case "user":
			return UserToGroup_.user;
		case "group":
			return UserToGroup_.group;
		case "groupRole":
			return UserToGroup_.groupRole;
		default:
			throw new UnsupportedOperationException("sorting is not supported by column:" + sortColumn);
		}
	}

	@Override
	public long getCount(UserToUserGroupFilter filter) {
		final EntityManager em = getEntityManager();
		final CriteriaBuilder cb = em.getCriteriaBuilder();

		final CriteriaQuery<Long> cq = cb.createQuery(Long.class);
		final Root<UserToGroup> from = cq.from(UserToGroup.class); // select from brand
		cq.select(cb.count(from)); // select what? select count(*)
		final TypedQuery<Long> q = em.createQuery(cq);
		return q.getSingleResult(); // execute query
	}

	@Override
	public void save(IUserToGroup... entities) {
		for (IUserToGroup entity : entities) {
			insert(entity);
		}

	}

	@Override
	public IUserToGroup getFullInfo(Integer id) {
		final EntityManager em = getEntityManager();
		final CriteriaBuilder cb = em.getCriteriaBuilder();

		final CriteriaQuery<IUserToGroup> cq = cb.createQuery(IUserToGroup.class);
		final Root<UserToGroup> from = cq.from(UserToGroup.class);

		cq.select(from); // define what need to be selected
		from.fetch(UserToGroup_.user, JoinType.LEFT);
		from.fetch(UserToGroup_.group, JoinType.LEFT);

		cq.where(cb.equal(from.get(Smile_.id), id));

		final TypedQuery<IUserToGroup> q = em.createQuery(cq);

		return getSingleResult(q);
	}

}
