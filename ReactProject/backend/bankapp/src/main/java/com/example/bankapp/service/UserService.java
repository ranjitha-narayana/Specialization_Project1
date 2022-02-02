package com.example.bankapp.service;

import com.example.bankapp.model.User;
import com.example.bankapp.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepo repo;

    public void store(User usr) {
        repo.save(usr);
    }

    public List<User> getUsers() {

        List<User> list = repo.findAll();

        return list;
    }

    public User getUser(int id) {

        User usr = repo.findById(id).orElse(new User());

        return usr;
    }
    public User updateUsr(int id, User usr){

        Optional<User> userOp=repo.findById(id);
        if(!userOp.isPresent()){
            System.out.println("user not found");
        }
        else{
            repo.findById(id);
            return repo.save(usr);
        }
        return usr;
    }



    public void deleteUsr(int id) {
        repo.deleteById(id);
    }



    public User fetchuserbyemail(String email) {
        return repo.findByEmail(email);
    }

    public User fetchusrbyemailandpass(String email, String password) {

        return repo.findByEmailAndPassword(email, password);
    }
}



