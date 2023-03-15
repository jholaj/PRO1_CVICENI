package org.example.cv3.registrace;

public class UserValidator {
    public static ValidationResult validateUser(User user){
        ValidationResult result = new ValidationResult();

        if (user.getFirstName() == null){
            result.addError("Nezadal jsi krestni jméno!");
        }
        else if (user.getFirstName().length() > 50) {
            result.addError("Jmeno je moc dlouhe!");
        }

        if (user.getLastName() == null){
            result.addError("Nezadal jsi prijmeni!");
        }
        else if (user.getLastName().length() > 50) {
            result.addError("Prijmeni je moc dlouhe!");
        }

        if (user.getAge() == null){
            result.addError("Nezadals vek!");
        }
        else if (user.getAge() < 0){
            result.addError("Vek musi byt kladne cislo!");
        }

        return result;
    }
}
