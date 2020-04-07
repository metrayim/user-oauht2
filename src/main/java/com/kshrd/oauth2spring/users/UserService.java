package com.kshrd.oauth2spring.users;

import java.util.List;
import java.util.Optional;

import com.kshrd.oauth2spring.utils.RecordNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import antlr.RecognitionException;
import ch.qos.logback.core.util.OptionHelper;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserEntity> findAll(){
        return userRepository.findAll();
    }

    public Optional<UserEntity> findById(String id){
        Optional<UserEntity> user=userRepository.findById(id);
        return user;
    }
    public UserEntity save(UserEntity user){
        return userRepository.save(user);
    }
    public UserEntity update(UserEntity user) throws Exception{
        Optional<UserEntity> update=userRepository.findById(user.getId());
        if(update.isPresent()){
            UserEntity newUpdate=update.get();
            newUpdate.setUsername(user.getUsername());;
            return userRepository.save(newUpdate);
        }
        else
        {
            throw new RecordNotFoundException("No user record exist for given id");
        }
       
    }
    public void deleteById(String id) throws Exception{

        Optional<UserEntity> update=userRepository.findById(id);
        if(update.isPresent()){
            userRepository.deleteById(id);
        }
        else{
            throw new RecordNotFoundException("No user record exits for given id");
        }
      
    }

}