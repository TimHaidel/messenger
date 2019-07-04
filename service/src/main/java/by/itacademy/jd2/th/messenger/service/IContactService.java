package by.itacademy.jd2.th.messenger.service;

import java.util.List;

import by.itacademy.jd2.th.messenger.dao.api.entity.table.IContact;
import by.itacademy.jd2.th.messenger.dao.api.filter.ContactFilter;

public interface IContactService {

    long getCount(final ContactFilter filter);

    List<IContact> find(final ContactFilter filter);

    List<IContact> getAll();

    void deleteAll();

    void delete(final Integer id);

    IContact get(final Integer id);

    IContact createEntity();

    void save(final IContact entity);

    void save(final IContact... entities);

}
