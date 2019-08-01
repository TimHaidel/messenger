package by.itacademy.jd2.th.messenger.dao.orm.impl.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import by.itacademy.jd2.th.messenger.dao.api.entity.enums.Roles;
import by.itacademy.jd2.th.messenger.dao.api.entity.table.IUserAccount;

@Entity
public class UserAccount extends BaseEntity implements IUserAccount {
	@Column
	private String firstname;
	@Column
	private String lastname;
	@Column
	private String password;
	@Column
	private String email;
	@Column
	private String phone;
	@Column
	private Roles role;
	@Column
	private String avatar;

	@Override
	public String getFirstname() {
		return firstname;
	}

	@Override
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	@Override
	public String getLastname() {
		return lastname;
	}

	@Override
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String getEmail() {
		return email;
	}

	@Override
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String getPhone() {
		return phone;
	}

	@Override
	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public Roles getRole() {
		return role;
	}

	@Override
	public void setRole(Roles role) {
		this.role = role;
	}

	@Override
	public String getAvatar() {
		return avatar;
	}

	@Override
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	@Override
	public String toString() {
		return "UserAccount [firstname=" + firstname + ", lastname=" + lastname + ", password=" + password + ", email="
				+ email + ", phone=" + phone + ", role=" + role + ", avatar=" + avatar + "]";
	}

}
