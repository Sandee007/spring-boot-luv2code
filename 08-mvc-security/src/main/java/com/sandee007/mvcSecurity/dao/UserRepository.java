package com.sandee007.mvcSecurity.dao;

import com.sandee007.mvcSecurity.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
