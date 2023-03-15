package org.example.cv3.registrace;

import java.util.ArrayList;
import java.util.List;

public class RegistrationServiceImpl implements RegistrationService {

    private UserStorage userStorage;

    public RegistrationServiceImpl(UserStorage userStorage) {
        this.userStorage = userStorage;
    }

    @Override
    public ServiceResult registerUser(User user) {
        ValidationResult validationResult = UserValidator.validateUser(user);
        if (validationResult.isValid()){
            try {
                userStorage.addUser(user);
            } catch (RuntimeException e) {
                List<String> errors = new ArrayList<>();
                errors.add("Při pokusu o uložení uživatele nastalo k chybě");
                return new ServiceResult(errors);
            }
            return new ServiceResult(user);

        }

        return new ServiceResult(validationResult.getErrors());

    }
}
