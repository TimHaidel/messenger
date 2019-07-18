package by.itacademy.jd2.th.messenger.web.converter;

import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import by.itacademy.jd2.th.messenger.dao.api.entity.table.ISmileGroup;
import by.itacademy.jd2.th.messenger.service.ISmileGroupService;
import by.itacademy.jd2.th.messenger.web.dto.SmileGroupDTO;

@Component
public class SmileGroupFromDTOConverter implements Function<SmileGroupDTO, ISmileGroup> {

	@Autowired
	private ISmileGroupService smileGroupService;

	@Override
	public ISmileGroup apply(SmileGroupDTO dto) {
		ISmileGroup entity = smileGroupService.createEntity();
		entity.setId(dto.getId());
		entity.setName(dto.getName());
		return entity;
	}

}
