package by.itacademy.jd2.th.messenger.jdbc.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Repository;

import by.itacademy.jd2.th.messenger.dao.api.IMessageDao;
import by.itacademy.jd2.th.messenger.dao.api.entity.table.IMessage;
import by.itacademy.jd2.th.messenger.dao.api.filter.MessageFilter;
import by.itacademy.jd2.th.messenger.jdbc.impl.entity.Message;
import by.itacademy.jd2.th.messenger.jdbc.impl.entity.UserAccount;
import by.itacademy.jd2.th.messenger.jdbc.impl.entity.UserGroup;
import by.itacademy.jd2.th.messenger.jdbc.impl.util.PreparedStatementAction;
import by.itacademy.jd2.th.messenger.jdbc.impl.util.SQLExecutionException;

@Repository
public class MessageDaoImpl extends AbstractDaoImpl<IMessage, Integer> implements IMessageDao {

	@Override
	public IMessage createEntity() {
		return new Message();
	}

	@Override
	public void update(final IMessage entity) {
		executeStatement(new PreparedStatementAction<IMessage>(String.format(
				"update %s set message = ?, updated = ?, user_id = ?, bunch_id = ? where id=?", getTableName())) {
			@Override
			public IMessage doWithPreparedStatement(final PreparedStatement pStmt) throws SQLException {
				pStmt.setString(1, entity.getMessage());
				pStmt.setObject(2, entity.getUpdated(), Types.TIMESTAMP);
				pStmt.setInt(3, entity.getUser().getId());
				pStmt.setInt(4, entity.getUserGroup().getId());
				pStmt.setInt(5, entity.getId());
				pStmt.executeUpdate();
				return entity;
			}
		});

	}

	@Override
	public void insert(final IMessage entity) {

		executeStatement(new PreparedStatementAction<IMessage>(
				String.format("insert into %s (message, created, updated, user_id, group_id) values(?,?,?,?,?)",
						getTableName()),
				true) {
			@Override
			public IMessage doWithPreparedStatement(final PreparedStatement pStmt) throws SQLException {
				pStmt.setString(1, entity.getMessage());
				pStmt.setObject(2, entity.getUpdated(), Types.TIMESTAMP);
				pStmt.setObject(3, entity.getUpdated(), Types.TIMESTAMP);

				pStmt.setInt(4, entity.getUser().getId());
				pStmt.setInt(5, entity.getUserGroup().getId());
				pStmt.executeUpdate();

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
	protected IMessage parseRow(final ResultSet resultSet, final Set<String> columns) throws SQLException {
		final IMessage entity = createEntity();
		entity.setId((Integer) resultSet.getObject("id"));
		entity.setCreated(resultSet.getTimestamp("created"));
		entity.setUpdated(resultSet.getTimestamp("updated"));
		entity.setMessage(resultSet.getString("message"));

		// entity.setParentMessage(resultSet.getInt("parent_message"));

		final Integer bunchId = (Integer) resultSet.getObject("bunch_id");
		if (bunchId != null) {
			final UserGroup bunch = new UserGroup();
			bunch.setId(bunchId);
			if (columns.contains("name")) {
				bunch.setName(resultSet.getString("name"));
			}
			if (columns.contains("status")) {
				bunch.setStatus(resultSet.getInt("status"));
			}
			if (columns.contains("created")) {
				bunch.setCreated(resultSet.getDate("created"));
			}
			if (columns.contains("updated")) {
				bunch.setUpdated(resultSet.getDate("updated"));
			}
			entity.setUserGroup(bunch);

		}

		final Integer userId = (Integer) resultSet.getObject("user_id");
		if (userId != null) {
			final UserAccount user = new UserAccount();
			user.setId(userId);
			if (columns.contains("firstname")) {
				user.setFirstname(resultSet.getString("firstname"));
			}
			if (columns.contains("lastname")) {
				user.setLastname(resultSet.getString("lastname"));
			}
			if (columns.contains("password")) {
				user.setPassword(resultSet.getString("password"));
			}
			if (columns.contains("email")) {
				user.setEmail(resultSet.getString("email"));
			}
			if (columns.contains("avatar")) {
				user.setAvatar(resultSet.getString("avatar"));
			}
			if (columns.contains("role")) {
				user.setRole(resultSet.getInt("role"));
			}
			if (columns.contains("created")) {
				user.setCreated(resultSet.getDate("created"));
			}
			if (columns.contains("updated")) {
				user.setUpdated(resultSet.getDate("updated"));
			}

			entity.setUser(user);
		}
		return entity;
	}

	@Override
	protected String getTableName() {
		return "message";
	}

	@Override
	public List<IMessage> find(final MessageFilter filter) {
		throw new RuntimeException("not implemented");
	}

	@Override
	public long getCount(final MessageFilter filter) {
		throw new RuntimeException("not implemented");
	}

	@Override
	public void save(final IMessage... entities) {
		try (Connection c = getConnection()) {
			c.setAutoCommit(false);
			try {

				for (final IMessage entity : entities) {
					final PreparedStatement pStmt = c.prepareStatement(String.format(
							"insert into %s (message, created, updated, parent_message, user_id, bunch_id) values(?,?,?,?,?,?)",
							getTableName()), Statement.RETURN_GENERATED_KEYS);

					pStmt.setString(1, entity.getMessage());
					pStmt.setObject(2, entity.getUpdated(), Types.TIMESTAMP);
					pStmt.setObject(3, entity.getUpdated(), Types.TIMESTAMP);
					pStmt.setInt(4, entity.getParrentMessage().getId());
					pStmt.setInt(5, entity.getUser().getId());
					pStmt.setInt(6, entity.getUserGroup().getId());
					pStmt.executeUpdate();

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

}
