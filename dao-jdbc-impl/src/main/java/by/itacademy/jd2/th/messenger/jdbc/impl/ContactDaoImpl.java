package by.itacademy.jd2.th.messenger.jdbc.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import by.itacademy.jd2.th.messenger.dao.api.IContactDao;
import by.itacademy.jd2.th.messenger.dao.api.IUserAccountDao;
import by.itacademy.jd2.th.messenger.dao.api.entity.table.IContact;
import by.itacademy.jd2.th.messenger.dao.api.entity.table.IUserAccount;
import by.itacademy.jd2.th.messenger.dao.api.filter.ContactFilter;
import by.itacademy.jd2.th.messenger.jdbc.impl.entity.Contact;
import by.itacademy.jd2.th.messenger.jdbc.impl.entity.UserAccount;
import by.itacademy.jd2.th.messenger.jdbc.impl.util.PreparedStatementAction;
import by.itacademy.jd2.th.messenger.jdbc.impl.util.SQLExecutionException;

@Repository
public class ContactDaoImpl extends AbstractDaoImpl<IContact, Integer> implements IContactDao {

	@Autowired
	IUserAccountDao userAccountDao;

	@Override
	public IContact createEntity() {
		return new Contact();
	}

	@Override
	public void update(final IContact entity) {
		executeStatement(new PreparedStatementAction<IContact>(String
				.format("update %s set initiator_id = ?, acceptor_id = ?, status = ? where id=?", getTableName())) {
			@Override
			public IContact doWithPreparedStatement(final PreparedStatement pStmt) throws SQLException {
				pStmt.setInt(1, entity.getInitiator().getId());
				pStmt.setInt(2, entity.getAcceptor().getId());
				pStmt.setInt(3, entity.getStatus());
				pStmt.setInt(4, entity.getId());
				pStmt.executeUpdate();
				return entity;
			}
		});

	}

	@Override
	public void insert(final IContact entity) {
		executeStatement(new PreparedStatementAction<IContact>(
				String.format("insert into %s (initiator_id, acceptor_id, status) values(?,?,?)", getTableName()),
				true) {
			@Override
			public IContact doWithPreparedStatement(final PreparedStatement pStmt) throws SQLException {
				pStmt.setInt(1, entity.getInitiator().getId());
				pStmt.setInt(2, entity.getAcceptor().getId());
				if (entity.getStatus() != null) {
					pStmt.setInt(3, entity.getStatus());
				}
				pStmt.executeUpdate();

				final ResultSet rs = pStmt.getGeneratedKeys();
				rs.next();
				final int id = rs.getInt("id");

				rs.close();

				entity.setId(id);
				return entity;
			}
		});

	}

	@Override
	protected IContact parseRow(final ResultSet resultSet, final Set<String> columns) throws SQLException {
		final IContact entity = createEntity();
		entity.setId((Integer) resultSet.getObject("id"));
		entity.setStatus(resultSet.getInt("status"));

		final Integer initiatorId = (Integer) resultSet.getObject("initiator_id");

		final IUserAccount initiator = new UserAccount();
		initiator.setId(initiatorId);
		entity.setInitiator(initiator);

		final Integer acceptorId = (Integer) resultSet.getObject("acceptor_id");
		final IUserAccount acceptor = new UserAccount();
		acceptor.setId(acceptorId);

		entity.setAcceptor(acceptor);

		return entity;
	}

	@Override
	protected String getTableName() {
		return "contact";
	}

	@Override
	public List<IContact> find(final ContactFilter filter) {
		final StringBuilder sqlTile = new StringBuilder("");
		appendSort(filter, sqlTile);
		appendPaging(filter, sqlTile);
		List<IContact> contacts = executeFindQuery(sqlTile.toString());

		for (IContact iContact : contacts) {

			iContact.setInitiator(userAccountDao.get(iContact.getInitiator().getId()));
			iContact.setAcceptor(userAccountDao.get(iContact.getAcceptor().getId()));
		}
		return contacts;
	}

	@Override
	public long getCount(final ContactFilter filter) {
		return executeCountQuery("");
	}

	@Override
	public void save(final IContact... entities) {
		try (Connection c = getConnection()) {
			c.setAutoCommit(false);
			try {

				for (final IContact entity : entities) {
					final PreparedStatement pStmt = c.prepareStatement(String
							.format("insert into %s (intiator_id, acceptor_id, status) values(?,?,?)", getTableName()),
							Statement.RETURN_GENERATED_KEYS);

					pStmt.setObject(1, entity.getInitiator());
					pStmt.setObject(2, entity.getAcceptor());
					pStmt.setInt(3, entity.getStatus());

					pStmt.executeUpdate();

					final ResultSet rs = pStmt.getGeneratedKeys();
					rs.next();
					final int id = rs.getInt("id");

					rs.close();
					pStmt.close();
					entity.setId(id);
				}

				// the same should be done in 'update' DAO method
				c.commit();
			} catch (final Exception e) {
				c.rollback();
				throw new RuntimeException(e);
			}

		} catch (final SQLException e) {
			throw new SQLExecutionException(e);
		}
	}

	@Override
	public IContact getFullInfo(Integer id) {
		throw new RuntimeException("Not implemented");
	}

}
