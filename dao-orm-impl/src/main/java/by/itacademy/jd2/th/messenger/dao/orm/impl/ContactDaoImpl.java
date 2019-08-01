package by.itacademy.jd2.th.messenger.dao.orm.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import by.itacademy.jd2.th.messenger.dao.api.IContactDao;
import by.itacademy.jd2.th.messenger.dao.api.entity.table.IContact;
import by.itacademy.jd2.th.messenger.dao.api.filter.ContactFilter;
import by.itacademy.jd2.th.messenger.dao.orm.impl.entity.Contact;

@Repository
public class ContactDaoImpl extends AbstractDaoImpl<IContact, Integer> implements IContactDao {

	protected ContactDaoImpl() {
		super(Contact.class);
	}

	@Override
	public IContact createEntity() {
		IContact contact = new Contact();
		return contact;
	}

	@Override
	public List<IContact> find(ContactFilter filter) {
		throw new RuntimeException("Not implemented");
	}

	@Override
	public long getCount(ContactFilter filter) {
		throw new RuntimeException("Not implemented");
	}

	@Override
	public void save(IContact... entities) {
		throw new RuntimeException("Not implemented");

	}

}
