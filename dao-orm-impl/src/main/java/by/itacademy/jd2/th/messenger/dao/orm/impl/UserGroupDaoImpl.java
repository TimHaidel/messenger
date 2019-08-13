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

import by.itacademy.jd2.th.messenger.dao.api.IUserGroupDao;
import by.itacademy.jd2.th.messenger.dao.api.entity.table.IUserGroup;
import by.itacademy.jd2.th.messenger.dao.api.filter.UserGroupFilter;
import by.itacademy.jd2.th.messenger.dao.orm.impl.entity.UserGroup;
import by.itacademy.jd2.th.messenger.dao.orm.impl.entity.UserGroup_;

@Repository
public class UserGroupDaoImpl extends AbstractDaoImpl<IUserGroup, Integer> implements IUserGroupDao {

	protected UserGroupDaoImpl() {
		super(UserGroup.class);
	}

	@Override
	public IUserGroup createEntity() {
		IUserGroup userGroup = new UserGroup();
		return userGroup;
	}

	@Override
	public List<IUserGroup> find(UserGroupFilter filter) {
		final EntityManager em = getEntityManager();
		final CriteriaBuilder cb = em.getCriteriaBuilder();

		final CriteriaQuery<IUserGroup> cq = cb.createQuery(IUserGroup.class);

		final Root<UserGroup> from = cq.from(UserGroup.class);// select from
		cq.select(from); // select what? select *

		if (filter.getSortColumn() != null) {
			final SingularAttribute<? super UserGroup, ?> sortProperty = toMetamodelFormat(filter.getSortColumn());

			final Path<?> expression = from.get(sortProperty);
			cq.orderBy(new OrderImpl(expression, filter.getSortOrder()));
		}

		final TypedQuery<IUserGroup> q = em.createQuery(cq);
		setPaging(filter, q);

		return q.getResultList();
	}

	private SingularAttribute<? super UserGroup, ?> toMetamodelFormat(final String sortColumn) {
		switch (sortColumn) {
		case "created":
			return UserGroup_.created;
		case "updated":
			return UserGroup_.updated;
		case "id":
			return UserGroup_.id;
		case "name":
			return UserGroup_.name;
		case "status":
			return UserGroup_.status;
		default:
			throw new UnsupportedOperationException("sorting is not supported by column:" + sortColumn);
		}
	}

	@Override
	public long getCount(UserGroupFilter filter) {
		final EntityManager em = getEntityManager();
		final CriteriaBuilder cb = em.getCriteriaBuilder();

		final CriteriaQuery<Long> cq = cb.createQuery(Long.class);
		final Root<UserGroup> from = cq.from(UserGroup.class);
		cq.select(cb.count(from));

		final TypedQuery<Long> q = em.createQuery(cq);

		return q.getSingleResult();
	}

	@Override
	public void save(IUserGroup... entities) {
		throw new RuntimeException("Not implemented");

	}

}
