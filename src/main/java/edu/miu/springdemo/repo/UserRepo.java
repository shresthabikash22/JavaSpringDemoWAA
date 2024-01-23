package edu.miu.springdemo.repo;

import edu.miu.springdemo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {
//    List<User> findUserWithMoreThanOnePost();
    @Query("select u from User u where size(u.posts) > :n")
    List<User> findUsersWithMMoreThanNPosts(int n);

    @Query("select distinct u from User  u JOIN u.posts p where p.title = :title")
    List<User> findUsersByPostTitle(String title);

    User findByEmail(String email);
}
