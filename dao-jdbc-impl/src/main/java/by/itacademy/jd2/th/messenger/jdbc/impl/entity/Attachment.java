package by.itacademy.jd2.th.messenger.jdbc.impl.entity;

import by.itacademy.jd2.th.messenger.dao.api.entity.table.IAttachment;

public class Attachment extends BaseEntity implements IAttachment {

    String content;
    Integer contentType;

    @Override
    public String getContent() {
        return content;
    }

    @Override
    public void setContent(final String content) {
        this.content = content;
    }

    @Override
    public Integer getContentType() {
        return contentType;
    }

    @Override
    public void setContentType(final Integer contentType) {
        this.contentType = contentType;
    }

    @Override
    public String toString() {
        return "Attachment [content=" + content + ", contentType=" + contentType + "]";
    }

	@Override
	public void setId(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer getId() {
		// TODO Auto-generated method stub
		return null;
	}

}
