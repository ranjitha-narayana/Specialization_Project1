package com.example.bankapp.controller;

import com.example.bankapp.model.User;
import com.example.bankapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(origins = "http://localhost:4200/")
@CrossOrigin("http://localhost:3000/")
public class UserController {
    @Autowired
    UserService service;

    @PostMapping(value = "/saveUsr", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> print(@RequestBody User usr) {
        service.store(usr);
        return new ResponseEntity<User>(usr, HttpStatus.CREATED);
    }

    @GetMapping(value = "/Users", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<User>> getUsrs() {
        List<User> list = service.getUsers();
        return new ResponseEntity<List<User>>(list, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public User Loginuser(@RequestBody User usr) throws Exception {
        String mailid = usr.getEmail();
        String pass = usr.getPassword();
        User obj = null;

        if (mailid != null && pass != null) {
            obj = service.fetchusrbyemailandpass(mailid, pass);

        }
        if (obj == null) {
            throw new Exception("USER DOESNOT EXIST");
        }
        return obj;
    }

    @GetMapping(value = "/User/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getUsr(@PathVariable("id") int id) {
        User usr = service.getUser(id);
        return new ResponseEntity<User>(usr, HttpStatus.CREATED);
    }

//    @PutMapping(value = "/User", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<User> updateUsr(@RequestBody User usr) {
//        service.store(usr);
//        return new ResponseEntity<User>(usr, HttpStatus.CREATED);
//    }

//   @RequestMapping(value = "/edit", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ModelAndView updateUsr(@RequestParam("id") int id, ModelAndView mv) {
//       mv=new ModelAndView("update");
//       mv.addObject("id",id);
//       return  mv;
//    }
@PutMapping("/update/{id}")
public ResponseEntity<User> updateUsr( @RequestBody User usr ,@PathVariable("id") int id)
{
return  new ResponseEntity<User>(service.updateUsr(id,usr), HttpStatus.CREATED);

}

    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> deleteUser(@PathVariable("id") int id) {
        service.deleteUsr(id);
        return new ResponseEntity<String>("recored deleted", HttpStatus.CREATED);
    }

}


