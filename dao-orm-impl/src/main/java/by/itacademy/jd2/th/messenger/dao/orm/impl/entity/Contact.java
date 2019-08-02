package by.itacademy.jd2.th.messenger.dao.orm.impl.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import by.itacademy.jd2.th.messenger.dao.api.entity.table.IContact;
import by.itacademy.jd2.th.messenger.dao.api.entity.table.IUserAccount;

@Entity
public class Contact extends BaseEntity implements IContact {
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = UserAccount.class)
	private IUserAccount initiator;
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = UserAccount.class)
	private IUserAccount acceptor;
	@Column
	private Integer status;

	@Override
	public IUserAccount getInitiator() {
		return initiator;
	}

	@Override
	public void setInitiator(final IUserAccount initiator) {
		this.initiator = initiator;
	}

	@Override
	public IUserAccount getAcceptor() {
		return acceptor;
	}

	@Override
	public void setAcceptor(final IUserAccount acceptor) {
		this.acceptor = acceptor;
	}

	@Override
	public Integer getStatus() {
		return status;
	}

	@Override
	public void setStatus(final Integer status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Contact [initiator=" + initiator + ", acceptor=" + acceptor + ", status=" + status + "]";
	}

}
