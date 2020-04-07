package com.kshrd.oauth2spring.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,String> {

    @Query(value="select * from userss where id=?",nativeQuery = true)
    public UserEntity getTestById(String id);
    public UserEntity findByUsernameAndStatus(String username,Boolean status);
    public UserEntity findByIdAndStatus(String id,Boolean status);
    


}