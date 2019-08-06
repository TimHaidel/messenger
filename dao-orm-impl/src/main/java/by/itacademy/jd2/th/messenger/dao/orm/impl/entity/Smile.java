package by.itacademy.jd2.th.messenger.dao.orm.impl.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import by.itacademy.jd2.th.messenger.dao.api.entity.table.ISmile;
import by.itacademy.jd2.th.messenger.dao.api.entity.table.ISmileGroup;

@Entity
public class Smile extends BaseEntity implements ISmile {

	@Column
	private String name;
	@Column
	private String marker;
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = SmileGroup.class)
	private ISmileGroup smileGroup;

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(final String name) {
		this.name = name;
	}

	@Override
	public String getMarker() {
		return marker;
	}

	@Override
	public void setMarker(final String marker) {
		this.marker = marker;
	}

	@Override
	public ISmileGroup getSmileGroup() {
		return smileGroup;
	}

	@Override
	public void setSmileGroup(final ISmileGroup smileGroup) {
		this.smileGroup = smileGroup;
	}

	@Override
	public String toString() {
		return "Smile [name=" + name + ", marker=" + marker + ", smileGroup=" + smileGroup + "]";
	}

}
