package edu.miu.springdemo.repo;

import edu.miu.springdemo.entity.Logger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoggerRepo extends JpaRepository<Logger,Integer> {
}
