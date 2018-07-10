package com.strazhevich.task.rest;

import com.strazhevich.task.entity.User;
import com.strazhevich.task.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * REST controller for {@link User}
 *
 * @author Denis Strazhevich
 */


@RestController
@RequestMapping("/api/users/")
public class UserRestController {

    private UserService userService;
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = userService.getAllUsers();
        if (users.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(users,HttpStatus.OK);
    }

    @RequestMapping(value = "{id}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<User> getUserById(@PathVariable("id") Integer id){
        if (id == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        User user = userService.getUserById(id);

        if (user == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(user,HttpStatus.FOUND);
    }

    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Integer> addUser(@RequestBody @Valid User user){
        if (user == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        userService.saveUser(user);

        return new ResponseEntity<>(user.getId(), HttpStatus.CREATED);
    }

    @RequestMapping(value = "{id}/{status}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<User> changeStatus(@PathVariable("id") Integer id, @PathVariable("status") String status){
        String response = "The unique id is equals " + id + " ";
        HttpHeaders headers = new HttpHeaders();
        if ((id == null) || (status == null)){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        User user = userService.getUserById(id);
        response = response + "The previous status is equals " + user.getStatus() + " ";
        user.setStatus(status);
        userService.saveUser(user);
        response = response + "New status is equals " + status;
        headers.add("Response", response);

        return new ResponseEntity<>(user,headers,HttpStatus.OK);

    }



}
