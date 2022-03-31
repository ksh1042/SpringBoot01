package com.roman14.roman14.login.repository;

import com.roman14.roman14.login.entity.UserHistoryVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginHistoryRepository extends JpaRepository<UserHistoryVO, Long>
{
}
