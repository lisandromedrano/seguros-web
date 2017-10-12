package com.lix.domain.master.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lix.domain.master.users.model.Users;

//@Repository("usersRepository")
public interface UsersRepository extends JpaRepository<Users, Integer> {
	public Users findByUsername(String username);
}
