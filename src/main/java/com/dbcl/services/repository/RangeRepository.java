package com.dbcl.services.repository;

import com.dbcl.services.entity.ShootingRange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RangeRepository extends JpaRepository<ShootingRange, Long> {
}