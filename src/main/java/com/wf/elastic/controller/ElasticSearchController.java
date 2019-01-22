package com.wf.elastic.controller;

import com.wf.elastic.model.User;
import com.wf.elastic.repository.UsersRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/search")
public class ElasticSearchController
{
	@Autowired
	UsersRepository repository;

	@GetMapping(value = "/name/{text}")
	public List<User> searchName(@PathVariable final String text)
	{
		return repository.findByName(text);
	}

	@GetMapping(value = "/all")
	public List<User> searchAll()
	{
		List<User> usersList = new ArrayList<>();
		Iterable<User> userses = repository.findAll();
		userses.forEach(usersList::add);
		return usersList;
	}

}
