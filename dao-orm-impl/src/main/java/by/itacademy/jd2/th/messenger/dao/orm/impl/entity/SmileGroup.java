package by.itacademy.jd2.th.messenger.dao.orm.impl.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Version;

import by.itacademy.jd2.th.messenger.dao.api.entity.table.ISmileGroup;

@Entity

public class SmileGroup extends BaseEntity implements ISmileGroup {

	@Column
	private String name;

	@Column
	@Version
	private Integer version;

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
	public Integer getVersion() {
		return version;
	}

	@Override
	public void setVersion(Integer version) {
		this.version = version;
	}

}
