package by.itacademy.jd2.th.messenger.dao.api;

import java.util.List;

import by.itacademy.jd2.th.messenger.dao.api.entity.table.IContact;
import by.itacademy.jd2.th.messenger.dao.api.filter.ContactFilter;

public interface IContactDao extends IDao<IContact, Integer> {

	List<IContact> find(ContactFilter filter);

	long getCount(ContactFilter filter);

	void save(IContact... entities);

	IContact getFullInfo(Integer id);
}
