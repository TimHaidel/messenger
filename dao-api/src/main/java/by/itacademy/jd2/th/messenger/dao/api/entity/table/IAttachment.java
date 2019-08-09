package by.itacademy.jd2.th.messenger.dao.api.entity.table;

import java.util.Date;

public interface IAttachment extends IBaseEntity {

	void setContentType(final Integer contentType);

	Integer getContentType();

	void setContent(final String content);

	String getContent();

	void setUpdated(Date updated);

	Date getUpdated();

	void setCreated(Date created);

	Date getCreated();

	void setId(Integer id);

	Integer getId();

	void setMessage(IMessage message);

	IMessage getMessage();

}
