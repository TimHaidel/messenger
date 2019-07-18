package by.itacademy.jd2.th.messenger.jdbc.impl.entity;

import java.util.Date;

import by.itacademy.jd2.th.messenger.dao.api.entity.table.IContact;
import by.itacademy.jd2.th.messenger.dao.api.entity.table.IUserAccount;

public class Contact implements IContact{
    private Integer id;
    private IUserAccount initiator;
    private IUserAccount acceptor;
    private Integer status;
    private Date created;
    private Date udpated;
    
    

    @Override
	public Date getCreated() {
		return created;
	}

	@Override
	public void setCreated(Date created) {
		this.created = created;
	}

	@Override
	public Date getUdpated() {
		return udpated;
	}

	@Override
	public void setUdpated(Date udpated) {
		this.udpated = udpated;
	}

	@Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(final Integer id) {
        this.id = id;
    }

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
        return "Contact [id=" + id + ", initiator=" + initiator + ", acceptor=" + acceptor + ", status=" + status + "]";
    }

 
}
