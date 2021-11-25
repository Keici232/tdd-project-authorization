import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {
    private Login login;

    @BeforeEach
    void setUp() {
        login = new Login();
        login.setMembers();
    }

    @Test
    void verifyLoginCorrectToken() throws WrongLoginException {

        assertEquals("123AbA#", login.verify("anna", "losen"));
    }

    @Test
    void verifyLoginCorrectAuthorization() throws WrongLoginException {

        assertEquals("READ", login.verifyTjanst(login.verify("anna", "losen"), "ACCOUNT"));
    }

    @Test
    void verifyLoginWrongToken() throws WrongLoginException {

        assertEquals("does not exist", login.verifyTjanst("readd", "ACCOUNT"));
    }

    @Test
    void verifyLoginFalsePassword() throws WrongLoginException {

        WrongLoginException wrongLoginException = assertThrows(WrongLoginException.class, () ->
                login.verify("anna", "los"));
        assertEquals("Wrong password!", wrongLoginException.getMessage());
    }


    @Test
    void verifyLoginFalseName() throws WrongLoginException {

        WrongLoginException wrongLoginException = assertThrows(WrongLoginException.class, () ->
                login.verify("annaa", "losen"));
        assertEquals("Wrong name!", wrongLoginException.getMessage());
    }
}
