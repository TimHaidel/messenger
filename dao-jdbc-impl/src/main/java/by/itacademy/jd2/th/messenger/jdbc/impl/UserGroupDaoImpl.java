package by.itacademy.jd2.th.messenger.jdbc.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import org.springframework.stereotype.Repository;

import by.itacademy.jd2.th.messenger.dao.api.IUserGroupDao;
import by.itacademy.jd2.th.messenger.dao.api.entity.table.IUserGroup;
import by.itacademy.jd2.th.messenger.dao.api.filter.UserGroupFilter;
import by.itacademy.jd2.th.messenger.jdbc.impl.entity.UserGroup;
import by.itacademy.jd2.th.messenger.jdbc.impl.util.PreparedStatementAction;

@Repository
public class UserGroupDaoImpl extends AbstractDaoImpl<IUserGroup, Integer> implements IUserGroupDao {

	@Override
	public IUserGroup createEntity() {
		return new UserGroup();
	}

	@Override
	public void update(final IUserGroup entity) {
		executeStatement(new PreparedStatementAction<IUserGroup>(
				String.format("update %s set name = ?, status = ?, updated = ? where id=?", getTableName())) {
			@Override
			public IUserGroup doWithPreparedStatement(final PreparedStatement pStmt) throws SQLException {
				pStmt.setString(1, entity.getName());
				pStmt.setInt(2, entity.getUsersCount());
				pStmt.setObject(3, entity.getUpdated(), Types.TIMESTAMP);
				pStmt.setInt(4, entity.getId());
				pStmt.executeUpdate();
				return entity;
			}
		});
	}

	@Override
	protected IUserGroup parseRow(final ResultSet resultSet) throws SQLException {
		final IUserGroup entity = createEntity();
		entity.setId((Integer) resultSet.getObject("id"));
		entity.setName(resultSet.getString("name"));
		entity.setCreated(resultSet.getTimestamp("created"));
		entity.setUpdated(resultSet.getTimestamp("updated"));
		entity.setUsersCount(resultSet.getInt("users_count"));

		return entity;
	}

	@Override
	public void insert(final IUserGroup entity) {

		executeStatement(new PreparedStatementAction<IUserGroup>(
				String.format("insert into %s (name, status, created, updated) values(?,?,?,?)", getTableName()),
				true) {
			@Override
			public IUserGroup doWithPreparedStatement(final PreparedStatement pStmt) throws SQLException {
				pStmt.setString(1, entity.getName());
				pStmt.setInt(2, entity.getUsersCount());
				pStmt.setObject(3, entity.getCreated(), Types.TIMESTAMP);
				pStmt.setObject(4, entity.getUpdated(), Types.TIMESTAMP);

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
		return "user_group";
	}

	@Override
	public List<IUserGroup> find(final UserGroupFilter filter) {
		final StringBuilder sqlTile = new StringBuilder("");
		appendSort(filter, sqlTile);
		appendPaging(filter, sqlTile);
		return executeFindQuery(sqlTile.toString());
	}

	@Override
	public long getCount(final UserGroupFilter filter) {
		return executeCountQuery("");
	}

	@Override
	public void save(final IUserGroup... entities) {
		throw new RuntimeException("not implemented");

	}

}
