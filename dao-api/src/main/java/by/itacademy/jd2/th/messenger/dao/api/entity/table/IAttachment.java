package by.itacademy.jd2.th.messenger.dao.api.entity.table;

public interface IAttachment extends IBaseEntity {

    void setContentType(final Integer contentType);

    Integer getContentType();

    void setContent(final String content);

    String getContent();

}
