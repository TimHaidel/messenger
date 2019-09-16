package by.itacademy.jd2.th.messenger.web.converter;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import by.itacademy.jd2.th.messenger.dao.api.entity.table.IUserAccount;
import by.itacademy.jd2.th.messenger.web.dto.UserAccountDTO;

@Component
public class UserAccountToDTOConverter implements Function<IUserAccount, UserAccountDTO> {

	@Override
	public UserAccountDTO apply(IUserAccount entity) {
		UserAccountDTO dto = new UserAccountDTO();
		dto.setId(entity.getId());
		dto.setAvatar(entity.getAvatar());
		dto.setEmail(entity.getEmail());
		dto.setFirstname(entity.getFirstname());
		dto.setLastname(entity.getLastname());
		dto.setPhone(entity.getPhone());
		if (entity.getPhone() != null) {
			dto.setRole(entity.getRole());
		}
		dto.setPassword(entity.getPassword());

		return dto;
	}

}
