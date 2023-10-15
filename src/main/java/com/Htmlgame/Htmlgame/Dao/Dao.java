package com.Htmlgame.Htmlgame.Dao;

import com.Htmlgame.Htmlgame.Entity.Web;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface Dao extends JpaRepository<Web,Integer> {

    @Transactional
    @Query(value = "SELECT email FROM Web u WHERE u.email=:email",nativeQuery = true)
    String findByEmail(String email);

    @Query(value = "SELECT email,pass_word FROM Web u WHERE u.email=:email AND u.pass_word=:password",
            nativeQuery = true)
    String findByLogin(String email,String password);

}
