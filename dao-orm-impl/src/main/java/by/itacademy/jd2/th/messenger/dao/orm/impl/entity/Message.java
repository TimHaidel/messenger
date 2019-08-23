package by.itacademy.jd2.th.messenger.dao.orm.impl.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import by.itacademy.jd2.th.messenger.dao.api.entity.table.IAttachment;
import by.itacademy.jd2.th.messenger.dao.api.entity.table.IMessage;
import by.itacademy.jd2.th.messenger.dao.api.entity.table.IUserAccount;
import by.itacademy.jd2.th.messenger.dao.api.entity.table.IUserGroup;

@Entity
public class Message extends BaseEntity implements IMessage {
	@Column
	private String message;
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Message.class, cascade = { CascadeType.ALL })
	private IMessage parentMessage;
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = UserAccount.class)
	private IUserAccount user;
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = UserGroup.class)
	private IUserGroup userGroup;

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "message", targetEntity = Attachment.class)
	private IAttachment attachment;

	@JoinTable(name = "pinned_message", joinColumns = { @JoinColumn(name = "message_id") }, inverseJoinColumns = {
			@JoinColumn(name = "user_id") })
	@ManyToMany(targetEntity = UserAccount.class, fetch = FetchType.LAZY)
	private Set<IUserAccount> userAccounts = new HashSet<>();

	@Override
	public IAttachment getAttachment() {
		return attachment;
	}

	@Override
	public void setAttachment(IAttachment attachment) {
		this.attachment = attachment;
	}

	@Override
	public String getMessage() {
		return message;
	}

	@Override
	public void setMessage(final String message) {
		this.message = message;
	}

	@Override
	public IMessage getParentMessage() {
		return parentMessage;
	}

	@Override
	public void setParentMessage(IMessage parentMessage) {
		this.parentMessage = parentMessage;
	}

	@Override
	public Set<IUserAccount> getUserAccounts() {
		return userAccounts;
	}

	@Override
	public void setUserAccounts(Set<IUserAccount> userAccounts) {
		this.userAccounts = userAccounts;
	}

	@Override
	public IUserAccount getUser() {
		return user;
	}

	@Override
	public void setUser(final IUserAccount user) {
		this.user = user;
	}

	@Override
	public IUserGroup getUserGroup() {
		return userGroup;
	}

	@Override
	public void setUserGroup(final IUserGroup group) {
		this.userGroup = group;
	}

	@Override
	public String toString() {
		return "Message [message=" + message + ", parentMessage=" + parentMessage + ", user=" + user + ", userGroup="
				+ userGroup + ", attachment=" + attachment + ", userAccounts=" + userAccounts + "]";
	}

}
