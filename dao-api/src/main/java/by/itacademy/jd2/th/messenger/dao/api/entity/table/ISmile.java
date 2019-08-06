package by.itacademy.jd2.th.messenger.dao.api.entity.table;

public interface ISmile extends IBaseEntity {

	void setSmileGroup(ISmileGroup smileGroup);

	ISmileGroup getSmileGroup();

	void setMarker(String marker);

	String getMarker();

	void setName(String name);

	String getName();

}
