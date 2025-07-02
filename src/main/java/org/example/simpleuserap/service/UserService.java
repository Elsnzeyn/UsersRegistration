package org.example.simpleuserap.service;
import org.example.simpleuserap.model.User;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;


@Service
public class UserService{
    List<User> users = new ArrayList<>();

    public void addUser(User user){
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
    public User getUserByEmail(String email) {
        for(User user : users){
            if(user.getEmail().equals(email)){
                return user;
            }
        }
        return null;
    }

}
