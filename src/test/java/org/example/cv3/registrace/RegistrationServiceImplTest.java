package org.example.cv3.registrace;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.security.Provider;
import java.util.regex.Matcher;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.notNull;

class RegistrationServiceImplTest {

    private RegistrationService registrationService;
    private UserStorage userStorage;
    @BeforeEach
    void setUp() {
        registrationService = new RegistrationServiceImpl(userStorage);
        userStorage = new UserStorage();
    }

    @AfterEach
    void tearDown() {
        //userStorage.getUsers().clear();
    }

    @Test
    void registerUser_HDS() {
        // Data preparation
        User user = new User();
        user.setFirstName("Homer");
        user.setLastName("Simpson");
        user.setAge(14);

        assertThat(userStorage.getUsers(), empty());

        // Execution
        ServiceResult serviceResult = registrationService.registerUser(user);

        // Result Validation


        assertThat(serviceResult, notNullValue());
        assertThat(serviceResult.getErrors(), nullValue());
        assertThat(serviceResult.getUser(), notNull());
        assertThat(serviceResult.getUser().getFirstName(), is("Homer"));
        assertThat(serviceResult.getUser().getLastName(), is("Simpson"));
        assertThat(serviceResult.getUser().getAge(), is(14));

        assertThat(userStorage.getUsers(), hasSize(1));
    }

    @Test
    void resgisterUser_NullValue(){
        //Data preparation
        User user = new User();

        // Execution
        ServiceResult serviceResult = registrationService.registerUser(user);

        //Verification
        assertThat(serviceResult, notNullValue());
        assertThat(serviceResult.getUser(), nullValue());
        assertThat(serviceResult.getErrors(), notNullValue());
        assertThat(serviceResult.getErrors(), hasSize(3));

        assertThat(serviceResult.getErrors(), hasItems("Nezadal jsi krestni jméno!", "Nezadal jsi prijmeni!", "Nezadals vek!"));

        assertThat(serviceResult.getErrors().get(0), is("Nezadal jsi krestni jméno!"));
        assertThat(serviceResult.getErrors().get(1), is("Nezadal jsi prijmeni!"));

    }

    @Test
    void resgisterUser_WrongValues(){
        // Data preparation
        User user = new User();
        user.setFirstName("Homerrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr");
        user.setLastName("Simpsooooooooooooooooooooooooooooooooooooooooooooooon");
        user.setAge(-5);

        assertThat(userStorage.getUsers(), empty());

        // Execution
        ServiceResult serviceResult = registrationService.registerUser(user);

        assertThat(serviceResult, nullValue());
        assertThat(serviceResult.getErrors(), notNullValue());
        assertThat(serviceResult.getUser(), nullValue());
        assertThat(serviceResult.getErrors(), hasItems("Jmeno je moc dlouhe!", "Prijmeni je moc dlouhe!", "Vek musi byt kladne cislo!"));

        assertThat(serviceResult.getErrors().get(0), is("Jmeno je moc dlouhe!"));
        assertThat(serviceResult.getErrors().get(1), is("Prijmeni je moc dlouhe!"));
        assertThat(serviceResult.getErrors().get(2), is("Vek musi byt kladne cislo!"));

        assertThat(userStorage.getUsers(), empty());

    }


    @Test
    void registerUser_saveException(){

        // Data preparation
        User user = new User();
        user.setFirstName("Homer");
        user.setLastName("Simpson");
        user.setAge(14);

        // Mock preparation
        UserStorage userStorageMock = Mockito.mock(UserStorage.class);
        Mockito.when(userStorageMock.addUser(Mockito.any()))
                .thenThrow(new RuntimeException("Smůla"));

        // Execution
        RegistrationService registrationServiceMock = new RegistrationServiceImpl(userStorageMock);
        //ServiceResult serviceResult = registrationServiceMock.registerUser(user);

        // Verification
        RuntimeException exception = assertThrows(RuntimeException.class, () -> registrationServiceMock.registerUser(user));
        assertThat(exception.getMessage(), is("Smůla"));
    }

    @Test
    void registerUser_saveException_Handled(){

        // Data preparation
        User user = new User();
        user.setFirstName("Homer");
        user.setLastName("Simpson");
        user.setAge(14);

        // Mock preparation
        UserStorage userStorageMock = Mockito.mock(UserStorage.class);
        Mockito.when(userStorageMock.addUser(Mockito.any()))
                .thenThrow(new RuntimeException("Smůla"));

        // Execution
        RegistrationService registrationServiceMock = new RegistrationServiceImpl(userStorageMock);
        ServiceResult serviceResult = registrationServiceMock.registerUser(user);

        // Verification
        assertThat(serviceResult, notNullValue());
        assertThat(serviceResult.getErrors(), hasSize(1));


    }
}