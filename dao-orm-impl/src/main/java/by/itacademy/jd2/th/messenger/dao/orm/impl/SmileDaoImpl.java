package by.itacademy.jd2.th.messenger.dao.orm.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import by.itacademy.jd2.th.messenger.dao.api.ISmileDao;
import by.itacademy.jd2.th.messenger.dao.api.entity.table.ISmile;
import by.itacademy.jd2.th.messenger.dao.api.filter.SmileFilter;
import by.itacademy.jd2.th.messenger.dao.orm.impl.entity.Smile;

@Repository
public class SmileDaoImpl extends AbstractDaoImpl<ISmile, Integer> implements ISmileDao {

	protected SmileDaoImpl() {
		super(Smile.class);
	}

	@Override
	public ISmile createEntity() {
		ISmile smile = new Smile();
		return smile;
	}

	@Override
	public List<ISmile> find(SmileFilter filter) {
		throw new RuntimeException("Not implemented");
	}

	@Override
	public long getCount(SmileFilter filter) {
		throw new RuntimeException("Not implemented");
	}

	@Override
	public void save(ISmile[] entities) {
		throw new RuntimeException("Not implemented");

	}

}
