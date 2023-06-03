package com.connection.database.db.repository;

import com.connection.database.db.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {

    @Modifying
    @Query("delete from UserEntity usEn where usEn.email = ?1")
    void deleteUserByEmail(String email);

}
