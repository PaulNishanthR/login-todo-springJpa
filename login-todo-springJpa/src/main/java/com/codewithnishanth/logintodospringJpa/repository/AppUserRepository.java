package com.codewithnishanth.logintodospringJpa.repository;

import com.codewithnishanth.logintodospringJpa.model.AppUser;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Integer> {

    @Query("from AppUser u WHERE u.username=:username AND u.password=:password")
    AppUser findAppUserByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
}
