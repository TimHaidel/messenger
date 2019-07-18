package by.itacademy.jd2.th.messenger.web.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.base.Function;

import by.itacademy.jd2.th.messenger.dao.api.entity.table.IUserAccount;
import by.itacademy.jd2.th.messenger.service.IUserAccountService;
import by.itacademy.jd2.th.messenger.web.dto.UserAccountDTO;

@Component
public class UserAccountFromDTOConverter implements Function<UserAccountDTO, IUserAccount> {

	@Autowired
	private IUserAccountService userAccountService;

	@Override
	public IUserAccount apply(UserAccountDTO dto) {
		IUserAccount entity = userAccountService.createEntity();
		entity.setId(dto.getId());
		entity.setAvatar(dto.getAvatar());
		entity.setEmail(dto.getEmail());
		entity.setFirstname(dto.getFirstname());
		entity.setLastname(dto.getLastname());
		entity.setPhone(dto.getPhone());
		entity.setRole(dto.getRole());
		entity.setPassword(dto.getPassword());
		return entity;
	}

}
