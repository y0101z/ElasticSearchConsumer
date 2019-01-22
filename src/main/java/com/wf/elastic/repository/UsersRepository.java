package com.wf.elastic.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.wf.elastic.model.User;

import java.util.List;

public interface UsersRepository extends ElasticsearchRepository<User, Long>
{
	List<User> findByName(String text);
}
