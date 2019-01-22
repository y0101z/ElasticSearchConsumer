package com.wf.elastic.jparepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wf.elastic.model.User;

public interface UserJpaRepository extends JpaRepository<User, Long>
{
}
