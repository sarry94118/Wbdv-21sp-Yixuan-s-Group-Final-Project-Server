package com.example.javaserver.repositories;

import com.example.javaserver.models.LoginRegister;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LoginRegisterRepository extends CrudRepository<LoginRegister, Long>{
    @Query(value="SELECT * FROM users WHERE username=:unm", nativeQuery = true)
    public LoginRegister findUserByUsername(@Param("unm") String username);

    @Query(value="SELECT * FROM users WHERE user_id=:ud", nativeQuery = true)
    public LoginRegister findUserByUid(@Param("ud") Long uid);

    //added by Meng Wang
    @Query(value = "SELECT * FROM users WHERE username=:uname AND password=:pass", nativeQuery = true)
    public LoginRegister findUserByCredentials(
            @Param("uname") String username,
            @Param("pass") String password);
}
