package by.itacademy.jd2.th.messenger.jdbc.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Repository;

import by.itacademy.jd2.th.messenger.dao.api.ISmileGroupDao;
import by.itacademy.jd2.th.messenger.dao.api.entity.table.ISmileGroup;
import by.itacademy.jd2.th.messenger.dao.api.filter.SmileGroupFilter;
import by.itacademy.jd2.th.messenger.jdbc.impl.entity.SmileGroup;
import by.itacademy.jd2.th.messenger.jdbc.impl.util.PreparedStatementAction;

@Repository
public class SmileGroupDaoImpl extends AbstractDaoImpl<ISmileGroup, Integer> implements ISmileGroupDao {

    @Override
    public ISmileGroup createEntity() {
        return new SmileGroup();
    }

    @Override
    public void update(final ISmileGroup entity) {
        executeStatement(new PreparedStatementAction<ISmileGroup>(
                String.format("update %s set name = ? where id=?", getTableName())) {
            @Override
            public ISmileGroup doWithPreparedStatement(final PreparedStatement pStmt) throws SQLException {
                pStmt.setString(1, entity.getName());
                pStmt.setInt(2, entity.getId());
                pStmt.executeUpdate();
                return entity;
            }
        });

    }

    @Override
    protected ISmileGroup parseRow(final ResultSet resultSet) throws SQLException {
        final ISmileGroup entity = createEntity();
        entity.setId((Integer) resultSet.getObject("id"));
        entity.setName(resultSet.getString("name"));

        return entity;
    }

    @Override
    public void insert(final ISmileGroup entity) {
        executeStatement(new PreparedStatementAction<ISmileGroup>(
                String.format("insert into %s (name) values(?)", getTableName()), true) {
            @Override
            public ISmileGroup doWithPreparedStatement(final PreparedStatement pStmt) throws SQLException {
                pStmt.setString(1, entity.getName());

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
        return "smile_group";
    }

    @Override
    public List<ISmileGroup> find(final SmileGroupFilter filter) {
        throw new RuntimeException("not implemented");
    }

    @Override
    public long getCount(final SmileGroupFilter filter) {
        throw new RuntimeException("not implemented");
    }

    @Override
    public void save(final ISmileGroup... entities) {
        throw new RuntimeException("not implemented");

    }

}
