package by.itacademy.jd2.th.messenger.dao.api;

import java.util.List;

import by.itacademy.jd2.th.messenger.dao.api.entity.table.ISmile;
import by.itacademy.jd2.th.messenger.dao.api.filter.SmileFilter;

public interface ISmileDao extends IDao<ISmile, Integer> {

    List<ISmile> find(SmileFilter filter);

    long getCount(SmileFilter filter);

    void save(ISmile[] entities);

}
