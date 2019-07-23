package by.itacademy.jd2.th.messenger.web.converter;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import by.itacademy.jd2.th.messenger.dao.api.entity.table.ISmile;
import by.itacademy.jd2.th.messenger.dao.api.entity.table.ISmileGroup;
import by.itacademy.jd2.th.messenger.web.dto.SmileDTO;

@Component
public class SmileToDTOConverter implements Function<ISmile, SmileDTO> {

	@Override
	public SmileDTO apply(ISmile entity) {
		SmileDTO dto = new SmileDTO();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setMarker(entity.getMarker());

		ISmileGroup smileGroup = entity.getSmileGroup();
		if (smileGroup != null) {
			dto.setSmileGroupId(smileGroup.getId());
		}
		return dto;
	}
}
