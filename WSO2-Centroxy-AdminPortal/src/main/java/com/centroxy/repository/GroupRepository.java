package com.centroxy.repository;
import com.centroxy.entity.Group;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group,Long> {
}

