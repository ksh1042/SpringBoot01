package com.roman14.roman14.login.repository;

import com.roman14.roman14.login.entity.UserVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<UserVO, String>
{
}
