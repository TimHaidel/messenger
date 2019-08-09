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

import by.itacademy.jd2.th.messenger.dao.api.IUserAccountDao;
import by.itacademy.jd2.th.messenger.dao.api.IUserGroupDao;
import by.itacademy.jd2.th.messenger.dao.api.IUserToGroupDao;
import by.itacademy.jd2.th.messenger.dao.api.entity.enums.Roles;
import by.itacademy.jd2.th.messenger.dao.api.entity.table.IUserAccount;
import by.itacademy.jd2.th.messenger.dao.api.entity.table.IUserGroup;
import by.itacademy.jd2.th.messenger.dao.api.entity.table.IUserToGroup;
import by.itacademy.jd2.th.messenger.dao.api.filter.UserToUserGroupFilter;
import by.itacademy.jd2.th.messenger.jdbc.impl.entity.User2Group;
import by.itacademy.jd2.th.messenger.jdbc.impl.entity.UserAccount;
import by.itacademy.jd2.th.messenger.jdbc.impl.entity.UserGroup;
import by.itacademy.jd2.th.messenger.jdbc.impl.util.PreparedStatementAction;
import by.itacademy.jd2.th.messenger.jdbc.impl.util.SQLExecutionException;

@Repository
public class UserToGroupDaoImpl extends AbstractDaoImpl<IUserToGroup, Integer> implements IUserToGroupDao {

	private final IUserAccountDao userAccountDao;
	private final IUserGroupDao userGroupDao;

	@Autowired
	public UserToGroupDaoImpl(final IUserAccountDao userAccountDao, final IUserGroupDao userGroupDao) {
		super();
		this.userAccountDao = userAccountDao;
		this.userGroupDao = userGroupDao;
	}

	@Override
	public IUserToGroup createEntity() {
		return new User2Group();
	}

	@Override
	public void update(final IUserToGroup entity) {
		try (Connection c = getConnection()) {
			c.setAutoCommit(false);
			try {
				executeStatement(new PreparedStatementAction<IUserToGroup>(String
						.format("update %s set group_id = ?, user_id = ?, group_role = ? where id=?", getTableName())) {
					@Override
					public IUserToGroup doWithPreparedStatement(final PreparedStatement pStmt) throws SQLException {
						pStmt.setInt(1, entity.getGroup().getId());
						pStmt.setInt(2, entity.getUser().getId());
						pStmt.setInt(3, entity.getGroupRole());
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
	protected IUserToGroup parseRow(final ResultSet resultSet, final Set<String> columns) throws SQLException {
		final IUserToGroup entity = createEntity();
		entity.setId((Integer) resultSet.getObject("id"));
		entity.setGroupRole(resultSet.getInt("group_role"));

		final Integer userGroupId = (Integer) resultSet.getObject("group_id");
		if (userGroupId != null) {
			final IUserGroup userGroup = new UserGroup();
			userGroup.setId(userGroupId);
			if (columns.contains("name")) {
				userGroup.setName(resultSet.getString("name"));
			}
			if (columns.contains("status")) {
				userGroup.setStatus(resultSet.getInt("status"));
			}
			if (columns.contains("created")) {
				userGroup.setCreated(resultSet.getDate("created"));
			}
			if (columns.contains("updated")) {
				userGroup.setUpdated(resultSet.getDate("updated"));
			}
			entity.setGroup(userGroup);

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
	public void insert(final IUserToGroup entity) {

		executeStatement(new PreparedStatementAction<IUserToGroup>(
				String.format("insert into %s (group_id, user_id, group_role) values(?,?,?)", getTableName()), true) {
			@Override
			public IUserToGroup doWithPreparedStatement(final PreparedStatement pStmt) throws SQLException {
				pStmt.setInt(1, entity.getGroup().getId());
				pStmt.setInt(2, entity.getUser().getId());
				pStmt.setInt(3, entity.getGroupRole());

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
	public List<IUserToGroup> find(final UserToUserGroupFilter filter) {
		throw new RuntimeException("not implemented");
	}

	@Override
	public long getCount(final UserToUserGroupFilter filter) {
		throw new RuntimeException("not implemented");
	}

	@Override
	public void save(final IUserToGroup... entities) {
		try (Connection c = getConnection()) {
			c.setAutoCommit(false);
			try {

				for (final IUserToGroup entity : entities) {
					final PreparedStatement pStmt = c.prepareStatement(String
							.format("insert into %s (group_id, user_id, group_role) values(?,?,?)", getTableName()),
							Statement.RETURN_GENERATED_KEYS);

					pStmt.setInt(1, entity.getGroup().getId());
					pStmt.setInt(2, entity.getUser().getId());
					pStmt.setInt(3, entity.getGroupRole());

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

	@Override
	public IUserToGroup getFullInfo(Integer id) {
		throw new RuntimeException("not implemented");
	}

}
