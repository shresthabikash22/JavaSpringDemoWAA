package edu.miu.springdemo.repo;

import edu.miu.springdemo.entity.ExceptionLogger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExceptionLoggerRepo extends JpaRepository<ExceptionLogger,Integer> {
}
