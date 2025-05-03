package io.reflectoring.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import io.reflectoring.demo.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("select u from User u where u.firstName LIKE %:query% OR u.lastName LIKE %:query%")
    public List<User> searchUser(@Param("query") String query);

}
