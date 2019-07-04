package by.itacademy.jd2.th.messenger.jdbc.impl.entity;

import java.util.Date;

import by.itacademy.jd2.th.messenger.dao.api.entity.table.IBaseEntity;

public class BaseEntity implements IBaseEntity {
    private Integer id;
    private Date created;
    private Date updated;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public Date getCreated() {
        return created;
    }

    @Override
    public void setCreated(Date created) {
        this.created = created;
    }

    @Override
    public Date getUpdated() {
        return updated;
    }

    @Override
    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    @Override
    public String toString() {
        return "BaseEntity [id=" + id + ", created=" + created + ", updated=" + updated + "]";
    }

}
