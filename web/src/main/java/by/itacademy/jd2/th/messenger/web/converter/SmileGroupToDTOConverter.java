package by.itacademy.jd2.th.messenger.web.converter;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import by.itacademy.jd2.th.messenger.dao.api.entity.table.ISmileGroup;
import by.itacademy.jd2.th.messenger.web.dto.SmileGroupDTO;

@Component
public class SmileGroupToDTOConverter implements Function<ISmileGroup, SmileGroupDTO> {

	@Override
	public SmileGroupDTO apply(ISmileGroup entity) {
		SmileGroupDTO dto = new SmileGroupDTO();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		return dto;
	}

}
