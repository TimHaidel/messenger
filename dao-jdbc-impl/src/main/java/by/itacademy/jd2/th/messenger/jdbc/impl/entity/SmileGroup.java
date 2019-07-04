package by.itacademy.jd2.th.messenger.jdbc.impl.entity;

import by.itacademy.jd2.th.messenger.dao.api.entity.table.ISmileGroup;

public class SmileGroup implements ISmileGroup {

    Integer id;
    String name;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(final Integer id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(final String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SmileGroup [id=" + id + ", name=" + name + "]";
    }

}
