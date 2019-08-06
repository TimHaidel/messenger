package by.itacademy.jd2.th.messenger.jdbc.impl.entity;

import java.util.Date;

import by.itacademy.jd2.th.messenger.dao.api.entity.table.IContact;
import by.itacademy.jd2.th.messenger.dao.api.entity.table.IUserAccount;

public class Contact extends BaseEntity implements IContact {
	private IUserAccount initiator;
	private IUserAccount acceptor;
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

}
