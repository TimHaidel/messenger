package by.itacademy.jd2.th.messenger.web.dto;

import by.itacademy.jd2.th.messenger.dao.api.entity.table.ISmileGroup;

public class SmileDTO {

	private Integer id;
	private String name;
	private String marker;
	private ISmileGroup smileGroup;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMarker() {
		return marker;
	}

	public void setMarker(String marker) {
		this.marker = marker;
	}

	public ISmileGroup getSmileGroup() {
		return smileGroup;
	}

	public void setSmileGroup(ISmileGroup SmileGroup) {
		this.smileGroup = SmileGroup;
	}

}
