package by.itacademy.jd2.th.messenger.dao.orm.impl.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Contact.class)
public abstract class Contact_ extends by.itacademy.jd2.th.messenger.dao.orm.impl.entity.BaseEntity_ {

	public static volatile SingularAttribute<Contact, UserAccount> acceptor;
	public static volatile SingularAttribute<Contact, UserAccount> initiator;
	public static volatile SingularAttribute<Contact, Integer> status;

}

