package by.itacademy.jd2.th.messenger.dao.api.entity.table;

import java.util.Date;

public interface IBaseEntity {

	void setUpdated(Date updated);

	Date getUpdated();

	void setCreated(Date created);

	Date getCreated();

	void setId(Integer id);

	Integer getId();

}
