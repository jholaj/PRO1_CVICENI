package org.example.cv3.registrace;

import java.util.List;

public class UserStorage {
    private List<User> users;

    public UserStorage(){

    }
    public UserStorage(List<User> users) {
        this.users = users;
    }

    public User addUser(User user){
        users.add(user);
        return user;
    }

    public List<User> getUsers() {
        return users;
    }
}
