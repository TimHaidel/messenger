package by.itacademy.jd2.th.messenger.dao.api.entity.table;

public interface IUserAccount extends IBaseEntity {

	void setAvatar(String avatar);

	String getAvatar();

	void setRole(Integer role);

	Integer getRole();

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

}
