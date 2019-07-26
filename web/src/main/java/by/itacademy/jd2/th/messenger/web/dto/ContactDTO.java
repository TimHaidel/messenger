package by.itacademy.jd2.th.messenger.web.dto;

import java.util.Date;

public class ContactDTO {

	private Integer id;
	private Integer initiatorId;
	private Integer acceptorId;
	private String acceptorFirstname;
	private String acceptorLastname;
	private Integer status;
	private String avatar;
	private Date created;

	public String getAcceptorFirstname() {
		return acceptorFirstname;
	}

	public void setAcceptorFirstname(String acceptorFirstname) {
		this.acceptorFirstname = acceptorFirstname;
	}

	public String getAcceptorLastname() {
		return acceptorLastname;
	}

	public void setAcceptorLastname(String acceptorLastname) {
		this.acceptorLastname = acceptorLastname;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getInitiatorId() {
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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

}
