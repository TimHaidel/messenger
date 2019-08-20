package by.itacademy.jd2.th.messenger.jdbc.impl.entity;

import by.itacademy.jd2.th.messenger.dao.api.entity.table.ISmileGroup;

public class SmileGroup extends BaseEntity implements ISmileGroup {

	String name;

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
		return "SmileGroup [name=" + name + "]";
	}

	@Override
	public void setVersion(Integer version) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer getVersion() {
		// TODO Auto-generated method stub
		return null;
	}

}
