package by.itacademy.jd2.th.messenger.dao.orm;

import org.hibernate.cfg.ImprovedNamingStrategy;

public class CustomImprovedNamingStrategy extends ImprovedNamingStrategy {

	@Override
	public String foreignKeyColumnName(final String propertyName, final String propertyEntityName,
			final String propertyTableName, final String referencedColumnName) {
		final String base = super.foreignKeyColumnName(propertyName, propertyEntityName, propertyTableName,
				referencedColumnName);
		return ((base != null) && (base.length() > 0)) ? base + "_id" : base;
	}

}