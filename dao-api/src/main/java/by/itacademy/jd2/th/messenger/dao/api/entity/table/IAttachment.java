package by.itacademy.jd2.th.messenger.dao.api.entity.table;

public interface IAttachment {

	void setContentType(final Integer contentType);

	Integer getContentType();

	void setContent(final String content);

	String getContent();

	void setId(Integer id);

	Integer getId();

}
