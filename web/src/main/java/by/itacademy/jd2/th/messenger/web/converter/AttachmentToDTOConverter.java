package by.itacademy.jd2.th.messenger.web.converter;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import by.itacademy.jd2.th.messenger.dao.api.entity.table.IAttachment;
import by.itacademy.jd2.th.messenger.web.dto.AttachmentDTO;

@Component
public class AttachmentToDTOConverter implements Function<IAttachment, AttachmentDTO> {

	@Override
	public AttachmentDTO apply(IAttachment entity) {
		AttachmentDTO dto = new AttachmentDTO();
		dto.setId(entity.getId());
		dto.setContent(entity.getContent());
		dto.setContentType(entity.getContentType());
		dto.setCreated(entity.getCreated());
		return dto;
	}

}
