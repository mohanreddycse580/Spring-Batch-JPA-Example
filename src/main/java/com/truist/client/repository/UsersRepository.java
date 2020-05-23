package com.truist.client.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.truist.client.entity.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {
}
