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

import by.itacademy.jd2.th.messenger.dao.api.IUserAccountDao;
import by.itacademy.jd2.th.messenger.dao.api.entity.table.IUserAccount;
import by.itacademy.jd2.th.messenger.dao.api.filter.UserAccountFilter;
import by.itacademy.jd2.th.messenger.dao.orm.impl.entity.UserAccount;
import by.itacademy.jd2.th.messenger.dao.orm.impl.entity.UserAccount_;

@Repository
public class UserAccountDaoImpl extends AbstractDaoImpl<IUserAccount, Integer> implements IUserAccountDao {

	protected UserAccountDaoImpl() {
		super(UserAccount.class);
	}

	@Override
	public IUserAccount createEntity() {
		IUserAccount user = new UserAccount();
		return user;
	}

	@Override
	public List<IUserAccount> find(UserAccountFilter filter) {
		final EntityManager em = getEntityManager();
		final CriteriaBuilder cb = em.getCriteriaBuilder();

		final CriteriaQuery<IUserAccount> cq = cb.createQuery(IUserAccount.class);

		final Root<UserAccount> from = cq.from(UserAccount.class);
		cq.select(from);

		if (filter.getSortColumn() != null) {
			final SingularAttribute<? super UserAccount, ?> sortProperty = toMetamodelFormat(filter.getSortColumn());

			final Path<?> expression = from.get(sortProperty);
			cq.orderBy(new OrderImpl(expression, filter.getSortOrder()));
		}

		final TypedQuery<IUserAccount> q = em.createQuery(cq);
		setPaging(filter, q);

		return q.getResultList();
	}

	@Override
	public List<IUserAccount> findForAutocomplete(String field) {
		final EntityManager em = getEntityManager();
		final CriteriaBuilder cb = em.getCriteriaBuilder();

		final CriteriaQuery<IUserAccount> cq = cb.createQuery(IUserAccount.class);

		final Root<UserAccount> from = cq.from(UserAccount.class);
		cq.select(from).where(cb.like(from.get(UserAccount_.email), field + "%"));

		final TypedQuery<IUserAccount> q = em.createQuery(cq);

		return q.getResultList();
	}

	private SingularAttribute<? super UserAccount, ?> toMetamodelFormat(final String sortColumn) {
		switch (sortColumn) {
		case "created":
			return UserAccount_.created;
		case "updated":
			return UserAccount_.updated;
		case "id":
			return UserAccount_.id;
		case "avatar":
			return UserAccount_.avatar;
		case "email":
			return UserAccount_.email;
		case "firstname":
			return UserAccount_.firstname;
		case "lastname":
			return UserAccount_.lastname;
		case "password":
			return UserAccount_.password;
		case "phone":
			return UserAccount_.phone;
		case "role":
			return UserAccount_.role;

		default:
			throw new UnsupportedOperationException("sorting is not supported by column:" + sortColumn);
		}
	}

	@Override
	public long getCount(UserAccountFilter filter) {
		final EntityManager em = getEntityManager();
		final CriteriaBuilder cb = em.getCriteriaBuilder();

		final CriteriaQuery<Long> cq = cb.createQuery(Long.class);
		final Root<UserAccount> from = cq.from(UserAccount.class); // select from
		cq.select(cb.count(from)); // select what? select count(*)
		final TypedQuery<Long> q = em.createQuery(cq);
		return q.getSingleResult(); // execute query
	}

	@Override
	public void save(IUserAccount... entities) {
		throw new RuntimeException("Not implemented");
	}

	@Override
	public IUserAccount findNickname(String username) {
		final EntityManager em = getEntityManager();
		final CriteriaBuilder cb = em.getCriteriaBuilder();

		final CriteriaQuery<UserAccount> cq = cb.createQuery(UserAccount.class);
		final Root<UserAccount> from = cq.from(UserAccount.class);
		cq.select(from).where(cb.equal(from.get("email"), username));
		final TypedQuery<UserAccount> q = em.createQuery(cq);
		return q.getSingleResult();
	}

}
