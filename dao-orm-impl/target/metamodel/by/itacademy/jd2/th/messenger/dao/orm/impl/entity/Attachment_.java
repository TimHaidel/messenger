package by.itacademy.jd2.th.messenger.dao.orm.impl.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Attachment.class)
public abstract class Attachment_ {

	public static volatile SingularAttribute<Attachment, Integer> id;
	public static volatile SingularAttribute<Attachment, Message> message;
	public static volatile SingularAttribute<Attachment, Integer> contentType;
	public static volatile SingularAttribute<Attachment, String> content;

}

