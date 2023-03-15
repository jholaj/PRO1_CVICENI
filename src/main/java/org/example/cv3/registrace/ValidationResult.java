package org.example.cv3.registrace;

import java.util.ArrayList;
import java.util.List;

public class ValidationResult {
    private List<String> errors;

    public ValidationResult() {
        errors = new ArrayList<>();
    }

    public void addError(String error){
        errors.add(error);
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    public List<String> getErrors() {
        return errors;
    }

    public boolean isValid(){
        return errors.isEmpty();
    }

}
