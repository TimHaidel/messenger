package by.itacademy.jd2.th.messenger.dao.api.entity.table;

public interface ISmile {

    void setSmileGroup(ISmileGroup smileGroup);

    ISmileGroup getSmileGroup();

    void setMarker(String marker);

    String getMarker();

    void setName(String name);

    String getName();

	void setId(Integer id);

	Integer getId();

  
}
