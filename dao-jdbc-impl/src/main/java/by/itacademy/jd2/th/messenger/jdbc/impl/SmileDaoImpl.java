package by.itacademy.jd2.th.messenger.jdbc.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Repository;

import by.itacademy.jd2.th.messenger.dao.api.ISmileDao;
import by.itacademy.jd2.th.messenger.dao.api.entity.table.ISmile;
import by.itacademy.jd2.th.messenger.dao.api.entity.table.ISmileGroup;
import by.itacademy.jd2.th.messenger.dao.api.filter.SmileFilter;
import by.itacademy.jd2.th.messenger.jdbc.impl.entity.Smile;
import by.itacademy.jd2.th.messenger.jdbc.impl.entity.SmileGroup;
import by.itacademy.jd2.th.messenger.jdbc.impl.util.PreparedStatementAction;

@Repository
public class SmileDaoImpl extends AbstractDaoImpl<ISmile, Integer> implements ISmileDao {

	@Override
	public ISmile createEntity() {
		return new Smile();
	}

	@Override
	public void update(final ISmile entity) {

		executeStatement(new PreparedStatementAction<ISmile>(
				String.format("update %s set name = ?, marker = ?, smile_group_id = ? where id=?", getTableName())) {
			@Override
			public ISmile doWithPreparedStatement(final PreparedStatement pStmt) throws SQLException {
				pStmt.setString(1, entity.getName());
				pStmt.setString(2, entity.getMarker());
				pStmt.setInt(3, entity.getSmileGroup().getId());
				pStmt.setInt(4, entity.getId());
				pStmt.executeUpdate();
				return entity;
			}
		});

	}

	@Override
	protected ISmile parseRow(final ResultSet resultSet, final Set<String> columns) throws SQLException {
		final ISmile entity = createEntity();
		entity.setId((Integer) resultSet.getObject("id"));
		entity.setName(resultSet.getString("name"));
		entity.setMarker(resultSet.getString("marker"));

		final Integer smileGroupId = (Integer) resultSet.getObject("smile_group_id");
		if (smileGroupId != null) {
			final ISmileGroup smileGroup = new SmileGroup();
			smileGroup.setId(smileGroupId);
			if (columns.contains("name")) {
				smileGroup.setName(resultSet.getString("name"));
			}

			entity.setSmileGroup(smileGroup);

		}

		return entity;
	}

	@Override
	public void insert(final ISmile entity) {

		executeStatement(new PreparedStatementAction<ISmile>(
				String.format("insert into %s (name, marker, smile_group_id) values(?, ?, ?)", getTableName()), true) {
			@Override
			public ISmile doWithPreparedStatement(final PreparedStatement pStmt) throws SQLException {
				pStmt.setString(1, entity.getName());
				pStmt.setString(2, entity.getMarker());
				pStmt.setInt(3, entity.getSmileGroup().getId());

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
		return "smile";
	}

	@Override
	public List<ISmile> find(final SmileFilter filter) {
		throw new RuntimeException("not implemented");
	}

	@Override
	public long getCount(final SmileFilter filter) {
		throw new RuntimeException("not implemented");
	}

	@Override
	public void save(final ISmile[] entities) {
		throw new RuntimeException("not implemented");

	}

}
