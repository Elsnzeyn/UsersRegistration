package org.example.simpleuserap.service;
import org.example.simpleuserap.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.DelegatingServerHttpResponse;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import org.example.simpleuserap.exceptionHandler.*;
import org.springframework.web.client.HttpClientErrorException;


@Service
public class UserService{
    List<User> users = new ArrayList<>();
    public void addUser(User user) throws DublicateEmailException {
        for (User user1 : users) {
            if (user1.getEmail().equals(user.getEmail()))
                throw new DublicateEmailException("User with email " + user.getEmail() + " already exists");
        }
                users.add(user);
        }

    public List<User> getUsers(){
        return users;
    }

    public void updateUser(User user) {
        for(User user1 : users){
            if(user.getEmail().equals(user1.getEmail())){
                users.remove(user1);
                users.add(user);

            }
        }
    }
    public void deleteUser(String email) {
        for(User user : users){
            if(user.getEmail().equals(email)){
                users.remove(user);
            }
        }
    }
    public User getUserByEmail(String email) throws EmailNotFound {
        for(User user : users){
            if(user.getEmail().equals(email)){
                return user;
            }
        }
        throw new EmailNotFound("User with email " + email + " not found");
    }
    }


