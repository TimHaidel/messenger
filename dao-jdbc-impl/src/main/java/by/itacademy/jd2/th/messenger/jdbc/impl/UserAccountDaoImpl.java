package by.itacademy.jd2.th.messenger.jdbc.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.List;

import org.springframework.stereotype.Repository;

import by.itacademy.jd2.th.messenger.dao.api.IUserAccountDao;
import by.itacademy.jd2.th.messenger.dao.api.entity.enums.Roles;
import by.itacademy.jd2.th.messenger.dao.api.entity.table.IUserAccount;
import by.itacademy.jd2.th.messenger.dao.api.filter.UserAccountFilter;
import by.itacademy.jd2.th.messenger.jdbc.impl.entity.UserAccount;
import by.itacademy.jd2.th.messenger.jdbc.impl.util.PreparedStatementAction;
import by.itacademy.jd2.th.messenger.jdbc.impl.util.SQLExecutionException;
import by.itacademy.jd2.th.messenger.jdbc.impl.util.StatementAction;

@Repository
public class UserAccountDaoImpl extends AbstractDaoImpl<IUserAccount, Integer> implements IUserAccountDao {

	@Override
	public IUserAccount createEntity() {
		return new UserAccount();
	}

	@Override
	public void update(final IUserAccount entity) {
		executeStatement(new PreparedStatementAction<IUserAccount>(String.format(
				"update %s set firstname = ?, updated = ?, lastname = ?, password = ?, email = ?, role = ?, avatar = ? where id=?",
				getTableName())) {
			@Override
			public IUserAccount doWithPreparedStatement(final PreparedStatement pStmt) throws SQLException {
				pStmt.setString(1, entity.getFirstname());
				pStmt.setObject(2, entity.getUpdated(), Types.TIMESTAMP);
				pStmt.setString(3, entity.getLastname());
				pStmt.setString(4, entity.getPassword());
				pStmt.setString(5, entity.getEmail());
				pStmt.setString(6, entity.getRole().name());
				pStmt.setString(7, entity.getAvatar());
				pStmt.setInt(8, entity.getId());
				pStmt.executeUpdate();
				return entity;
			}
		});
	}

	@Override
	protected IUserAccount parseRow(final ResultSet resultSet) throws SQLException {
		final IUserAccount entity = createEntity();
		entity.setId((Integer) resultSet.getObject("id"));
		entity.setFirstname(resultSet.getString("firstname"));
		entity.setCreated(resultSet.getTimestamp("created"));
		entity.setUpdated(resultSet.getTimestamp("updated"));
		entity.setLastname(resultSet.getString("lastname"));
		entity.setPassword(resultSet.getString("password"));
		entity.setEmail(resultSet.getString("email"));
		entity.setRole(Roles.valueOf(resultSet.getString("role")));
		entity.setAvatar(resultSet.getString("avatar"));
		return entity;
	}

	@Override
	public void insert(final IUserAccount entity) {

		executeStatement(new PreparedStatementAction<IUserAccount>(String.format(
				"insert into %s (firstname, created, updated, lastname, password, email, role, avatar) values(?,?,?,?,?,?,?,?)",
				getTableName()), true) {
			@Override
			public IUserAccount doWithPreparedStatement(final PreparedStatement pStmt) throws SQLException {
				pStmt.setString(1, entity.getFirstname());
				pStmt.setObject(2, entity.getCreated(), Types.TIMESTAMP);
				pStmt.setObject(3, entity.getUpdated(), Types.TIMESTAMP);
				pStmt.setString(4, entity.getLastname());
				pStmt.setString(5, entity.getPassword());
				pStmt.setString(6, entity.getEmail());
				pStmt.setString(7, entity.getRole().name());
				pStmt.setString(8, entity.getAvatar());

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
	protected String getTableName() {
		return "user_account";
	}

	@Override
	public List<IUserAccount> find(final UserAccountFilter filter) {
		final StringBuilder sqlTile = new StringBuilder("");
		appendSort(filter, sqlTile);
		appendPaging(filter, sqlTile);
		return executeFindQuery(sqlTile.toString());
	}

	@Override
	public long getCount(final UserAccountFilter filter) {
		return executeCountQuery("");
	}

	@Override
	public void save(final IUserAccount... entities) {
		try (Connection c = getConnection()) {
			c.setAutoCommit(false);
			try {

				for (final IUserAccount entity : entities) {
					final PreparedStatement pStmt = c.prepareStatement(String.format(
							"insert into %s (firstname, created, updated, lastname, password, email, role, avatar) values(?,?,?,?,?,?,?,?)",
							getTableName()), Statement.RETURN_GENERATED_KEYS);

					pStmt.setString(1, entity.getFirstname());
					pStmt.setObject(2, entity.getCreated(), Types.TIMESTAMP);
					pStmt.setObject(3, entity.getUpdated(), Types.TIMESTAMP);
					pStmt.setString(4, entity.getLastname());
					pStmt.setString(5, entity.getPassword());
					pStmt.setString(6, entity.getEmail());
					pStmt.setString(7, entity.getRole().name());
					pStmt.setString(8, entity.getAvatar());

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
	public IUserAccount findNickname(String email) {
		StatementAction<IUserAccount> action = (statement) -> {
			statement.executeQuery(String.format("select * from user_account where email='%s'", email));

			final ResultSet resultSet = statement.getResultSet();

			final boolean hasNext = resultSet.next();
			IUserAccount result = null;
			if (hasNext) {
				result = parseRow(resultSet);
			}

			resultSet.close();
			return result;
		};
		IUserAccount entityById = executeStatement(action);
		return entityById;

	}

	@Override
	public List<IUserAccount> findForAutocomplete(String field) {
		// TODO Auto-generated method stub
		return null;
	}

}
