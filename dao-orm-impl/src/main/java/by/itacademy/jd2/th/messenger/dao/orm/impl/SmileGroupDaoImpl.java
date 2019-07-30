package by.itacademy.jd2.th.messenger.dao.orm.impl;

import java.util.List;

import javax.persistence.metamodel.SingularAttribute;

import org.springframework.stereotype.Repository;

import by.itacademy.jd2.th.messenger.dao.api.ISmileGroupDao;
import by.itacademy.jd2.th.messenger.dao.api.entity.table.ISmileGroup;
import by.itacademy.jd2.th.messenger.dao.api.filter.SmileGroupFilter;
import by.itacademy.jd2.th.messenger.dao.orm.impl.entity.SmileGroup;

@Repository
public class SmileGroupDaoImpl extends AbstractDaoImpl<ISmileGroup, Integer> implements ISmileGroupDao {

	protected SmileGroupDaoImpl() {
		super(SmileGroup.class);
	}

	@Override
	public ISmileGroup createEntity() {
		return new SmileGroup();
	}

	@Override
	public List<ISmileGroup> find(final SmileGroupFilter filter) {
		throw new RuntimeException("not implemented");
	}

	@Override
	public long getCount(final SmileGroupFilter filter) {
		throw new RuntimeException("not implemented");
	}

	private SingularAttribute<? super SmileGroup, ?> toMetamodelFormat(final String sortColumn) {
		throw new RuntimeException("not implemented");
	}

	@Override
	public void save(final ISmileGroup... entities) {
		throw new RuntimeException("not implemented");

	}

}
