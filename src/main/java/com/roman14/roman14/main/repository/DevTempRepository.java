package com.roman14.roman14.main.repository;

import com.roman14.roman14.main.entity.DevTemp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DevTempRepository extends JpaRepository<DevTemp, String>
{
}
