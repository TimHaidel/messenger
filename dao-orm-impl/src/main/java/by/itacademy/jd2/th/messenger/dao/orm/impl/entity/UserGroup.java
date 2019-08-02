package by.itacademy.jd2.th.messenger.dao.orm.impl.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import by.itacademy.jd2.th.messenger.dao.api.entity.table.IUserGroup;

@Entity
public class UserGroup extends BaseEntity implements IUserGroup {
	@Column
	private String name;
	@Column
	private Integer status;

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(final String name) {
		this.name = name;
	}

	@Override
	public int getStatus() {
		return status;
	}

	@Override
	public void setStatus(final int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "UserGroup [name=" + name + ", status=" + status + "]";
	}

}
