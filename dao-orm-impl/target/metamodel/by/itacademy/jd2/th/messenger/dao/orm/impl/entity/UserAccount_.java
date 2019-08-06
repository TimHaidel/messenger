package by.itacademy.jd2.th.messenger.dao.orm.impl.entity;

import by.itacademy.jd2.th.messenger.dao.api.entity.enums.Roles;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(UserAccount.class)
public abstract class UserAccount_ extends by.itacademy.jd2.th.messenger.dao.orm.impl.entity.BaseEntity_ {

	public static volatile SingularAttribute<UserAccount, String> firstname;
	public static volatile SingularAttribute<UserAccount, String> password;
	public static volatile SingularAttribute<UserAccount, Roles> role;
	public static volatile SingularAttribute<UserAccount, String> phone;
	public static volatile SingularAttribute<UserAccount, String> avatar;
	public static volatile SingularAttribute<UserAccount, String> email;
	public static volatile SingularAttribute<UserAccount, String> lastname;

}

