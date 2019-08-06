package by.itacademy.jd2.th.messenger.dao.orm.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

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
		throw new RuntimeException("Not implemented");
	}

	@Override
	public long getCount(SmileFilter filter) {
		throw new RuntimeException("Not implemented");
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

}
