package by.itacademy.jd2.th.messenger.dao.orm.impl.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import by.itacademy.jd2.th.messenger.dao.api.entity.table.IAttachment;
import by.itacademy.jd2.th.messenger.dao.api.entity.table.IMessage;

@Entity
public class Attachment implements IAttachment {
	@Id
	private Integer id;
	@Column
	private String content;
	@Column
	private Integer contentType;

	@OneToOne(fetch = FetchType.LAZY, optional = false, targetEntity = Message.class)
	@PrimaryKeyJoinColumn
	private IMessage message;

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	public IMessage getMessage() {
		return message;
	}

	public void setMessage(IMessage message) {
		this.message = message;
	}

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
