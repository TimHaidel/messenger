package by.itacademy.jd2.th.messenger.web.converter;

import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import by.itacademy.jd2.th.messenger.dao.api.entity.table.ISmile;
import by.itacademy.jd2.th.messenger.dao.api.entity.table.ISmileGroup;
import by.itacademy.jd2.th.messenger.service.ISmileGroupService;
import by.itacademy.jd2.th.messenger.service.ISmileService;
import by.itacademy.jd2.th.messenger.web.dto.SmileDTO;

@Component
public class SmileFromDTOConverter implements Function<SmileDTO, ISmile> {

	@Autowired
	private ISmileService smileService;
	@Autowired
	private ISmileGroupService smileGroupService;

	@Override
	public ISmile apply(SmileDTO dto) {
		ISmile entity = smileService.createEntity();
		entity.setId(dto.getId());
		entity.setName(dto.getName());
		entity.setMarker(dto.getMarker());

		ISmileGroup smileGroup = smileGroupService.createEntity();
		smileGroup.setId(dto.getSmileGroup());
		entity.setSmileGroup(smileGroup);
		return entity;
	}

}
