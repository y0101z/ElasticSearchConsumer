package com.wf.elastic.load;

import com.wf.elastic.jparepository.UserJpaRepository;
import com.wf.elastic.model.User;
import com.wf.elastic.repository.UsersRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class Loaders
{

	@Autowired
	ElasticsearchOperations operations;

	@Autowired
	UsersRepository usersRepository;

	@Autowired
	UserJpaRepository userJpaRepository;

	@PostConstruct
	@Transactional
	public void loadAll()
	{

		operations.putMapping(User.class);
		System.out.println("Loading Data");
		List<User> data = getData();
		userJpaRepository.save(data);

		List<User> users = userJpaRepository.findAll();
		System.out.printf("Loading Completed");
	}

	private List<User> getData()
	{
		List<User> userses = new ArrayList<>();
		// todo: get data from DB
		return userses;
	}
}
