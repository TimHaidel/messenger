package by.itacademy.jd2.th.messenger.dao.api.entity.table;

public interface IContact {

    void setStatus(final Integer status);

    Integer getStatus();

    void setAcceptor(final IUserAccount acceptor);

    IUserAccount getAcceptor();

    void setInitiator(final IUserAccount initiator);

    IUserAccount getInitiator();

    void setId(final Integer id);

    Integer getId();

}
