package by.itacademy.jd2.th.messenger.jdbc.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Repository;

import by.itacademy.jd2.th.messenger.dao.api.IMessageDao;
import by.itacademy.jd2.th.messenger.dao.api.entity.enums.Roles;
import by.itacademy.jd2.th.messenger.dao.api.entity.table.IMessage;
import by.itacademy.jd2.th.messenger.dao.api.entity.table.IUserAccount;
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

	public void deleteAllPinnedMessages() {
		executeStatement(new PreparedStatementAction<Integer>("delete from pinned_message") {
			@Override
			public Integer doWithPreparedStatement(final PreparedStatement prepareStatement) throws SQLException {
				final int executeUpdate = prepareStatement.executeUpdate();
				return executeUpdate;
			}
		});
	}

	@Override
	public void insertPinMessage(Integer messageId, Integer userId) {
		try (Connection c = getConnection()) {

			PreparedStatement stmt = c.prepareStatement("insert into pinned_message (message_id, user_id) values(?,?)");
			stmt.setInt(1, messageId);
			stmt.setInt(2, userId);
			stmt.executeUpdate();
			stmt.close();
		} catch (final SQLException e) {
			throw new SQLExecutionException(e);
		}
	}

	@Override
	public void deletePinnedMessage(IMessage message) {
		try (Connection c = getConnection()) {
			final PreparedStatement deleteStmt = c.prepareStatement("delete from pinned_message where messege_id=?");
			deleteStmt.setInt(1, message.getId());
			deleteStmt.executeUpdate();
			deleteStmt.close();
		} catch (final SQLException e) {
			throw new SQLExecutionException(e);
		}

	}

	@Override
	public List<IMessage> getPinnedMessage(Integer id) {
		IMessage entity = createEntity();
		List<IMessage> entities = new ArrayList<IMessage>();
		try (Connection c = getConnection()) {
			Statement statement = c.createStatement();
			statement.executeQuery("select * from pinned_message where message_id=" + id);

			final ResultSet resultSet = statement.getResultSet();

			final boolean hasNext = resultSet.next();
			int messageId = 0;
			if (hasNext) {
				messageId = resultSet.getInt(1);
				entity = get(messageId);
			}
			resultSet.close();

		} catch (final SQLException e) {
			throw new SQLExecutionException(e);
		}
		return entities;
	}

	@Override
	public void update(final IMessage entity) {
		executeStatement(new PreparedStatementAction<IMessage>(String.format(
				"update %s set message = ?, updated = ?, user_id = ?, group_id = ? where id=?", getTableName())) {
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

		final Integer gourpId = (Integer) resultSet.getObject("group_id");
		if (gourpId != null) {
			final UserGroup group = new UserGroup();
			group.setId(gourpId);
			if (columns.contains("name")) {
				group.setName(resultSet.getString("name"));
			}
			if (columns.contains("status")) {
				group.setUsersCount(resultSet.getInt("users_count"));
			}
			if (columns.contains("created")) {
				group.setCreated(resultSet.getDate("created"));
			}
			if (columns.contains("updated")) {
				group.setUpdated(resultSet.getDate("updated"));
			}
			entity.setUserGroup(group);

		}

		final Integer userId = (Integer) resultSet.getObject("user_id");
		if (userId != null) {
			final IUserAccount user = new UserAccount();
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
				user.setRole(Roles.valueOf(resultSet.getString("role")));
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
		final StringBuilder sqlTile = new StringBuilder("");
		appendSort(filter, sqlTile);
		appendPaging(filter, sqlTile);
		return executeFindQuery(sqlTile.toString());
	}

	@Override
	public long getCount(final MessageFilter filter) {
		return executeCountQuery("");
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
					pStmt.setInt(4, entity.getParentMessage().getId());
					pStmt.setInt(5, entity.getUser().getId());
					pStmt.setInt(6, entity.getUserGroup().getId());

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
	public IMessage getFullInfo(Integer id) {
		throw new RuntimeException("Not implemented");
	}

	@Override
	public void deleteAllPinnedMessages(Integer userId) {
		// TODO Auto-generated method stub

	}

}
