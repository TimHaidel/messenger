package by.itacademy.jd2.th.messenger.dao.api;

import java.util.List;

import by.itacademy.jd2.th.messenger.dao.api.entity.table.ISmileGroup;
import by.itacademy.jd2.th.messenger.dao.api.filter.SmileGroupFilter;

public interface ISmileGroupDao extends IDao<ISmileGroup, Integer> {

    List<ISmileGroup> find(SmileGroupFilter filter);

    long getCount(SmileGroupFilter filter);

    void save(ISmileGroup... entities);

}
