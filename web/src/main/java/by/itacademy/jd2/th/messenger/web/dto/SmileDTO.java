package by.itacademy.jd2.th.messenger.web.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SmileDTO {

	private Integer id;
	@Size(min = 2, max = 10)
	private String name;
	private String marker;
	@NotNull
	private Integer smileGroupId;

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

	public Integer getSmileGroupId() {
		return smileGroupId;
	}

	public void setSmileGroupId(Integer smileGroupId) {
		this.smileGroupId = smileGroupId;
	}

}
