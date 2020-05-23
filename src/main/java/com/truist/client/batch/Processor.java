package com.truist.client.batch;

import java.util.Optional;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.truist.client.entity.Users;
import com.truist.client.entity.UsersVO;
import com.truist.client.repository.UsersRepository;

@Component
public class Processor implements ItemProcessor<UsersVO, UsersVO> {

	@Autowired
	private UsersRepository userRepo;

	@Override
	public UsersVO process(UsersVO usersVO) throws Exception {
		Optional<Users> userFromDb = userRepo.findById(usersVO.getUserId());
		if(userFromDb.isPresent()) {
			usersVO.setAccount(usersVO.getAccount().add(userFromDb.get().getAccount()));
		}
		return usersVO;
	}

}
