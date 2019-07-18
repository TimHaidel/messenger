package by.itacademy.jd2.th.messenger.web.converter;

import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import by.itacademy.jd2.th.messenger.dao.api.entity.table.IAttachment;
import by.itacademy.jd2.th.messenger.service.IAttachmentService;
import by.itacademy.jd2.th.messenger.web.dto.AttachmentDTO;

@Component
public class AttachmentFromDTOConverter implements Function<AttachmentDTO, IAttachment> {

	@Autowired
	private IAttachmentService attachmentService;

	@Override
	public IAttachment apply(AttachmentDTO dto) {
		IAttachment entity = attachmentService.createEntity();
		entity.setId(dto.getId());
		entity.setContent(dto.getContent());
		entity.setContentType(dto.getContentType());
		entity.setCreated(dto.getCreated());
		return entity;
	}

}
