package by.itacademy.jd2.th.messenger.dao.api.filter;

public class UserGroupFilter extends AbstractFilter {
	private String name;
	private Integer userId;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
