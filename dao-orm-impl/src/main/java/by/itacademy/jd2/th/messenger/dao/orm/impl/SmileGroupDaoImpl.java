package by.itacademy.jd2.th.messenger.dao.orm.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.SingularAttribute;

import org.springframework.stereotype.Repository;

import by.itacademy.jd2.th.messenger.dao.api.ISmileGroupDao;
import by.itacademy.jd2.th.messenger.dao.api.entity.table.ISmileGroup;
import by.itacademy.jd2.th.messenger.dao.api.filter.SmileGroupFilter;
import by.itacademy.jd2.th.messenger.dao.orm.impl.entity.SmileGroup;
import by.itacademy.jd2.th.messenger.dao.orm.impl.entity.SmileGroup_;

@Repository
public class SmileGroupDaoImpl extends AbstractDaoImpl<ISmileGroup, Integer> implements ISmileGroupDao {

	protected SmileGroupDaoImpl() {
		super(SmileGroup.class);
	}

	@Override
	public ISmileGroup createEntity() {
		return new SmileGroup();
	}

	@Override
	public List<ISmileGroup> find(final SmileGroupFilter filter) {
		final EntityManager em = getEntityManager();
		final CriteriaBuilder cb = em.getCriteriaBuilder();

		final CriteriaQuery<ISmileGroup> cq = cb.createQuery(ISmileGroup.class);

		final Root<SmileGroup> from = cq.from(SmileGroup.class);// select from smile group
		cq.select(from); // select what? select *

		final TypedQuery<ISmileGroup> q = em.createQuery(cq);
		setPaging(filter, q);

		return q.getResultList();
	}

	@Override
	public long getCount(final SmileGroupFilter filter) {
		final EntityManager em = getEntityManager();
		final CriteriaBuilder cb = em.getCriteriaBuilder();

		final CriteriaQuery<Long> cq = cb.createQuery(Long.class);
		final Root<SmileGroup> from = cq.from(SmileGroup.class); // select from brand
		cq.select(cb.count(from)); // select what? select count(*)
		final TypedQuery<Long> q = em.createQuery(cq);
		return q.getSingleResult(); // execute query
	}

	private SingularAttribute<? super SmileGroup, ?> toMetamodelFormat(final String sortColumn) {
		switch (sortColumn) {
		case "id":
			return SmileGroup_.id;
		case "name":
			return SmileGroup_.name;
		case "created":
			return SmileGroup_.created;
		case "updated":
			return SmileGroup_.updated;
		default:
			throw new UnsupportedOperationException("sorting is not supported by column:" + sortColumn);
		}
	}

	@Override
	public void save(final ISmileGroup... entities) {
		throw new RuntimeException("not implemented");

	}

}
