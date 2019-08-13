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
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.stereotype.Repository;

import by.itacademy.jd2.th.messenger.dao.api.ISmileDao;
import by.itacademy.jd2.th.messenger.dao.api.entity.table.ISmile;
import by.itacademy.jd2.th.messenger.dao.api.filter.SmileFilter;
import by.itacademy.jd2.th.messenger.dao.orm.impl.entity.Smile;
import by.itacademy.jd2.th.messenger.dao.orm.impl.entity.Smile_;

@Repository
public class SmileDaoImpl extends AbstractDaoImpl<ISmile, Integer> implements ISmileDao {

	protected SmileDaoImpl() {
		super(Smile.class);
	}

	@Override
	public ISmile createEntity() {
		ISmile smile = new Smile();
		return smile;
	}

	@Override
	public List<ISmile> find(SmileFilter filter) {
		final EntityManager em = getEntityManager();
		final CriteriaBuilder cb = em.getCriteriaBuilder();

		final CriteriaQuery<ISmile> cq = cb.createQuery(ISmile.class);

		final Root<Smile> from = cq.from(Smile.class);// select from smile
		cq.select(from); // select what? select *

		from.fetch(Smile_.smileGroup, JoinType.LEFT);

		if (filter.getSortColumn() != null) {
			final SingularAttribute<? super Smile, ?> sortProperty = toMetamodelFormat(filter.getSortColumn());

			final Path<?> expression = from.get(sortProperty);
			cq.orderBy(new OrderImpl(expression, filter.getSortOrder()));
		}

		final TypedQuery<ISmile> q = em.createQuery(cq);
		setPaging(filter, q);

		return q.getResultList();
	}

	private SingularAttribute<? super Smile, ?> toMetamodelFormat(final String sortColumn) {
		switch (sortColumn) {
		case "created":
			return Smile_.created;
		case "updated":
			return Smile_.updated;
		case "id":
			return Smile_.id;
		case "name":
			return Smile_.name;
		case "marker":
			return Smile_.marker;
		default:
			throw new UnsupportedOperationException("sorting is not supported by column:" + sortColumn);
		}
	}

	@Override
	public long getCount(SmileFilter filter) {
		final EntityManager em = getEntityManager();
		final CriteriaBuilder cb = em.getCriteriaBuilder();

		final CriteriaQuery<Long> cq = cb.createQuery(Long.class);
		final Root<Smile> from = cq.from(Smile.class); // select from
		cq.select(cb.count(from)); // select what? select count(*)
		final TypedQuery<Long> q = em.createQuery(cq);
		return q.getSingleResult(); // execute query
	}

	@Override
	public void save(ISmile[] entities) {
		throw new RuntimeException("Not implemented");

	}

	@Override
	public ISmile getFullInfo(Integer id) {
		final EntityManager em = getEntityManager();
		final CriteriaBuilder cb = em.getCriteriaBuilder();

		final CriteriaQuery<ISmile> cq = cb.createQuery(ISmile.class);
		final Root<Smile> from = cq.from(Smile.class);

		cq.select(from); // define what need to be selected
		from.fetch(Smile_.smileGroup, JoinType.LEFT);

		cq.where(cb.equal(from.get(Smile_.id), id));

		final TypedQuery<ISmile> q = em.createQuery(cq);

		return getSingleResult(q);
	}

	@Override
	public List<ISmile> search(String text) {

		EntityManager em = getEntityManager();
		FullTextEntityManager fullTextEntityManager = org.hibernate.search.jpa.Search.getFullTextEntityManager(em);

		// create native Lucene query unsing the query DSL
		// alternatively you can write the Lucene query using the Lucene query
		// parser
		// or the Lucene programmatic API. The Hibernate Search DSL is
		// recommended though
		QueryBuilder qb = fullTextEntityManager.getSearchFactory().buildQueryBuilder().forEntity(Smile.class).get();
		org.apache.lucene.search.Query luceneQuery = qb.keyword().onFields("marker").matching(text).createQuery();

		// wrap Lucene query in a javax.persistence.Query
		javax.persistence.Query jpaQuery = fullTextEntityManager.createFullTextQuery(luceneQuery, Smile.class);

		return jpaQuery.getResultList();

	}

}
