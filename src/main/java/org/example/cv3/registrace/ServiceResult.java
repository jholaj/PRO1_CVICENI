package org.example.cv3.registrace;

import java.security.Provider;
import java.util.List;

public class ServiceResult {

    private List<String> errors;
    private User user;

    public List<String> getErrors() {
        return errors;
    }

    public User getUser() {
        return user;
    }

    public ServiceResult(User user) {
        this.user = user;
    }

    public ServiceResult(List<String> errors){
        this.errors = errors;
    }


}
