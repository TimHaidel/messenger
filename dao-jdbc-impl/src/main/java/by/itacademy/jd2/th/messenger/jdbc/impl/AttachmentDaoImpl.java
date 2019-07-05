package by.itacademy.jd2.th.messenger.jdbc.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import org.springframework.stereotype.Repository;

import by.itacademy.jd2.th.messenger.dao.api.IAttachmentDao;
import by.itacademy.jd2.th.messenger.dao.api.entity.table.IAttachment;
import by.itacademy.jd2.th.messenger.dao.api.filter.AttachmentFilter;
import by.itacademy.jd2.th.messenger.jdbc.impl.entity.Attachment;
import by.itacademy.jd2.th.messenger.jdbc.impl.util.PreparedStatementAction;

@Repository
public class AttachmentDaoImpl extends AbstractDaoImpl<IAttachment, Integer> implements IAttachmentDao {

    @Override
    public IAttachment createEntity() {
        return new Attachment();
    }

    @Override
    public void update(final IAttachment entity) {

        executeStatement(new PreparedStatementAction<IAttachment>(
                String.format("update %s set content = ?, content_type = ?, updated = ? where id=?", getTableName())) {
            @Override
            public IAttachment doWithPreparedStatement(final PreparedStatement pStmt) throws SQLException {
                pStmt.setString(1, entity.getContent());
                pStmt.setInt(2, entity.getContentType());
                pStmt.setObject(3, entity.getUpdated(), Types.TIMESTAMP);
                pStmt.setInt(4, entity.getId());
                pStmt.executeUpdate();
                return entity;
            }
        });
    }

    @Override
    protected IAttachment parseRow(final ResultSet resultSet) throws SQLException {
        final IAttachment entity = createEntity();
        entity.setId((Integer) resultSet.getObject("id"));
        entity.setContent(resultSet.getString("content"));
        entity.setContentType(resultSet.getInt("content_type"));
        entity.setCreated(resultSet.getTimestamp("created"));
        entity.setUpdated(resultSet.getTimestamp("updated"));

        return entity;
    }

    @Override
    public void insert(final IAttachment entity) {

        executeStatement(new PreparedStatementAction<IAttachment>(
                String.format("insert into %s (content, content_type, created, updated, id) values(?,?,?,?, ?)",
                        getTableName()),
                true) {
            @Override
            public IAttachment doWithPreparedStatement(final PreparedStatement pStmt) throws SQLException {
                pStmt.setString(1, entity.getContent());
                pStmt.setInt(2, entity.getContentType());
                pStmt.setObject(3, entity.getCreated(), Types.TIMESTAMP);
                pStmt.setObject(4, entity.getUpdated(), Types.TIMESTAMP);
                pStmt.setInt(5, entity.getId());

                pStmt.executeUpdate();

                return entity;
            }
        });

    }

    @Override
    protected String getTableName() {
        return "attachment";
    }

    @Override
    public void save(final IAttachment[] entities) {
        throw new RuntimeException("not implemented");

    }

    @Override
    public List<IAttachment> find(final AttachmentFilter filter) {
        throw new RuntimeException("not implemented");
    }

    @Override
    public long getCount(final AttachmentFilter filter) {
        throw new RuntimeException("not implemented");
    }

}
