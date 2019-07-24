package by.itacademy.jd2.th.messenger.dao.api.entity.table;

import by.itacademy.jd2.th.messenger.dao.api.entity.enums.Roles;

public interface IUserAccount extends IBaseEntity {

	void setAvatar(String avatar);

	String getAvatar();

	void setPhone(String phone);

	String getPhone();

	void setEmail(String email);

	String getEmail();

	void setPassword(String password);

	String getPassword();

	void setLastname(String lastname);

	String getLastname();

	void setFirstname(String firstname);

	String getFirstname();

	void setRole(Roles role);

	Roles getRole();

}
