package edu.miu.springdemo.repo;

import edu.miu.springdemo.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesRepo extends JpaRepository<Role,Integer> {
}
