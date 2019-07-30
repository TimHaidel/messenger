package by.itacademy.jd2.th.messenger.dao.orm.impl.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import by.itacademy.jd2.th.messenger.dao.api.entity.table.ISmileGroup;

@Entity
public class SmileGroup extends BaseEntity implements ISmileGroup {
	@Column
	String name;

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(final String name) {
		this.name = name;
	}

}
