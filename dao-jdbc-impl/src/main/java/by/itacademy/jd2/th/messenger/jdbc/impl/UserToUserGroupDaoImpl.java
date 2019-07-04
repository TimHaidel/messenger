package by.itacademy.jd2.th.messenger.jdbc.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Repository;

import by.itacademy.jd2.th.messenger.dao.api.IUserToUserGroupDao;
import by.itacademy.jd2.th.messenger.dao.api.entity.table.IUserToUserGroup;
import by.itacademy.jd2.th.messenger.dao.api.filter.UserToUserGroupFilter;
import by.itacademy.jd2.th.messenger.jdbc.impl.entity.UserAccount;
import by.itacademy.jd2.th.messenger.jdbc.impl.entity.UserGroup;
import by.itacademy.jd2.th.messenger.jdbc.impl.entity.UserToUserGroup;
import by.itacademy.jd2.th.messenger.jdbc.impl.util.PreparedStatementAction;
import by.itacademy.jd2.th.messenger.jdbc.impl.util.SQLExecutionException;

@Repository
public class UserToUserGroupDaoImpl extends AbstractDaoImpl<IUserToUserGroup, Integer> implements IUserToUserGroupDao {

	@Override
	public IUserToUserGroup createEntity() {
		return new UserToUserGroup();
	}

	@Override
	public void update(final IUserToUserGroup entity) {
		try (Connection c = getConnection()) {
			c.setAutoCommit(false);
			try {
				executeStatement(new PreparedStatementAction<IUserToUserGroup>(String
						.format("update %s set group_id = ?, user_id = ?, group_role = ? where id=?", getTableName())) {
					@Override
					public IUserToUserGroup doWithPreparedStatement(final PreparedStatement pStmt) throws SQLException {
						pStmt.setInt(1, entity.getUserGroup().getId());
						pStmt.setInt(2, entity.getUser().getId());
						pStmt.setInt(3, entity.getUserGroupRole());
						pStmt.setInt(4, entity.getId());
						pStmt.executeUpdate();
						return entity;
					}
				});

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
	protected IUserToUserGroup parseRow(final ResultSet resultSet, final Set<String> columns) throws SQLException {
		final IUserToUserGroup entity = createEntity();
		entity.setId((Integer) resultSet.getObject("id"));
		entity.setUserGroupRole(resultSet.getInt("group_role"));

		final Integer userGroupId = (Integer) resultSet.getObject("group_id");
		if (userGroupId != null) {
			final UserGroup bunch = new UserGroup();
			bunch.setId(userGroupId);
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
	public void insert(final IUserToUserGroup entity) {

		executeStatement(new PreparedStatementAction<IUserToUserGroup>(
				String.format("insert into %s (group_id, user_id, group_role) values(?,?,?)", getTableName()), true) {
			@Override
			public IUserToUserGroup doWithPreparedStatement(final PreparedStatement pStmt) throws SQLException {
				pStmt.setInt(1, entity.getUserGroup().getId());
				pStmt.setInt(2, entity.getUser().getId());
				pStmt.setInt(3, entity.getUserGroupRole());
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
	protected String getTableName() {
		return "user_2_group";
	}

	@Override
	public List<IUserToUserGroup> find(final UserToUserGroupFilter filter) {
		throw new RuntimeException("not implemented");
	}

	@Override
	public long getCount(final UserToUserGroupFilter filter) {
		throw new RuntimeException("not implemented");
	}

	@Override
	public void save(final IUserToUserGroup... entities) {
		try (Connection c = getConnection()) {
			c.setAutoCommit(false);
			try {

				for (final IUserToUserGroup entity : entities) {
					final PreparedStatement pStmt = c.prepareStatement(String
							.format("insert into %s (group_id, user_id, group_role) values(?,?,?)", getTableName()),
							Statement.RETURN_GENERATED_KEYS);

					pStmt.setInt(1, entity.getUserGroup().getId());
					pStmt.setInt(2, entity.getUser().getId());
					pStmt.setInt(3, entity.getUserGroupRole());

					pStmt.executeUpdate();

					final ResultSet rs = pStmt.getGeneratedKeys();
					rs.next();
					final int id = rs.getInt("id");

					rs.close();
					pStmt.close();
					entity.setId(id);
				}

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
