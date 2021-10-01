package com.vti.ki4m.repository;

import com.vti.ki4m.entity.Target;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITargetRepository extends JpaRepository<Target, Integer> {

    Target findTargetById(Integer id);
}
