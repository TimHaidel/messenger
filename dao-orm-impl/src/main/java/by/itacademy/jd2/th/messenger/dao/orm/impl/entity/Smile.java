package by.itacademy.jd2.th.messenger.dao.orm.impl.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import by.itacademy.jd2.th.messenger.dao.api.entity.table.ISmile;
import by.itacademy.jd2.th.messenger.dao.api.entity.table.ISmileGroup;

@Entity
public class Smile implements ISmile {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column
	private String name;
	@Column
	private String marker;
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = SmileGroup.class)
	private ISmileGroup smileGroup;

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

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
