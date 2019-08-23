package by.itacademy.jd2.th.messenger.dao.api.filter;

public class UserGroupFilter extends AbstractFilter {
/*	private Integer initiatorId;
	private Integer acceptorId;
*/	private String name;



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	

/*	public Integer getInitiatorId() {
		return initiatorId;
	}

	public void setInitiatorId(Integer initiatorId) {
		this.initiatorId = initiatorId;
	}

	public Integer getAcceptorId() {
		return acceptorId;
	}

	public void setAcceptorId(Integer acceptorId) {
		this.acceptorId = acceptorId;
	}
*/
}
