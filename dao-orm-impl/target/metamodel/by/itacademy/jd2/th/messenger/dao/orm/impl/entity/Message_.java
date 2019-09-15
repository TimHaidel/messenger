package by.itacademy.jd2.th.messenger.dao.orm.impl.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Message.class)
public abstract class Message_ extends by.itacademy.jd2.th.messenger.dao.orm.impl.entity.BaseEntity_ {

	public static volatile SingularAttribute<Message, Attachment> attachment;
	public static volatile SetAttribute<Message, UserAccount> userAccounts;
	public static volatile SingularAttribute<Message, String> message;
	public static volatile SingularAttribute<Message, UserAccount> user;
	public static volatile SingularAttribute<Message, UserGroup> userGroup;

}

