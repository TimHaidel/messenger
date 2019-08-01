package by.itacademy.jd2.th.messenger.dao.orm.impl.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import by.itacademy.jd2.th.messenger.dao.api.entity.table.IAttachment;

@Entity
public class Attachment extends BaseEntity implements IAttachment {
	@Column
	String content;
	@Column
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

}
