package com.kshrd.oauth2spring.users;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import com.kshrd.oauth2spring.GlobalFunction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;
    @GetMapping
    public ResponseEntity<Map<String,Object>> findAll(){
        
        List<UserEntity> user=userService.findAll();
        return new ResponseEntity<>(GlobalFunction.getResponseBody("Successful to fetch the user data", user,true),HttpStatus.OK);
    }

    // public Object findAll(){
    //     List<UserEntity> user=userService.findAll();
    //     return user;
    // }
    @GetMapping("/{id}")
    public ResponseEntity<Map<String,Object>> findById(@PathVariable("id") String id) {
        Optional<UserEntity> userOptional=userService.findById(id);
        UserEntity user=userOptional.get();
      return new ResponseEntity<>(GlobalFunction.getResponseBody("Successful for find",user,true),HttpStatus.OK);
    }
    
    @PostMapping("/register")
    public ResponseEntity <UserEntity> register(@Valid @RequestBody   final UserEntity user ){
        //TODO: process POST request
        UserEntity create=userService.save(user);
        return new ResponseEntity<>(create,new HttpHeaders(),HttpStatus.OK);
    }
    

    


         

}