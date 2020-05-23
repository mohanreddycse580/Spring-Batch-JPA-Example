package com.truist.client.batch;

import java.util.ArrayList;
import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.truist.client.entity.Users;
import com.truist.client.entity.UsersVO;
import com.truist.client.repository.UsersRepository;

@Component
public class Writer implements ItemWriter<UsersVO> {

	@Autowired
	private UsersRepository repo;

	@Override
	@Transactional
	public void write(List<? extends UsersVO> usersVO) throws Exception {
		List<Users> users = getUserList(usersVO);
		repo.saveAll(users);
	}

	private List<Users> getUserList(List<? extends UsersVO> usersVOList) {
		// TODO Auto-generated method stub
		List<Users> usersList = new ArrayList<>();
		for (UsersVO usersVO : usersVOList) {
			Users users = new Users();
			users.setUserId(usersVO.getUserId());
			users.setAccount(usersVO.getAccount());
			users.setName(usersVO.getName());
			users.setDept(usersVO.getDept());
			usersList.add(users);

		}
		System.out.println(" usersList : "+usersList.size());
		return usersList;
	}

}
