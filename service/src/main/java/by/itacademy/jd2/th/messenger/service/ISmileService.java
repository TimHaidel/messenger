package by.itacademy.jd2.th.messenger.service;

import java.util.List;

import by.itacademy.jd2.th.messenger.dao.api.entity.table.ISmile;
import by.itacademy.jd2.th.messenger.dao.api.filter.SmileFilter;

public interface ISmileService {

    void save(final ISmile... entities);

    long getCount(final SmileFilter filter);

    List<ISmile> find(final SmileFilter filter);

    List<ISmile> getAll();

    void deleteAll();

    void delete(final Integer id);

    ISmile get(final Integer id);

    void save(final ISmile entity);

    ISmile createEntity();

}
