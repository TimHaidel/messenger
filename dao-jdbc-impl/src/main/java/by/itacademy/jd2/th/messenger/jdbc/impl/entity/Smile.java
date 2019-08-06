package by.itacademy.jd2.th.messenger.jdbc.impl.entity;

import by.itacademy.jd2.th.messenger.dao.api.entity.table.ISmile;
import by.itacademy.jd2.th.messenger.dao.api.entity.table.ISmileGroup;

public class Smile extends BaseEntity implements ISmile {
	String name;
	String marker;
	ISmileGroup smileGroup;

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

}
