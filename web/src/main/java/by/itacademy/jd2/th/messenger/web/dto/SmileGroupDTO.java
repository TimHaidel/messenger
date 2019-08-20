package by.itacademy.jd2.th.messenger.web.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SmileGroupDTO {
	private Integer id;
	@Size(min = 2, max = 6)
	private String name;

	@NotNull
	private Integer version;

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

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

}
