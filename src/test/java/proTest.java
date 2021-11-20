import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class proTest {
    private Login login;

    @BeforeEach
    void setUp() {
        login = new Login();
        login.setMembers();
    }

    @Test
    void verifyLoginCorrectToken() throws WrongLoginException {


        assertEquals("123AbA#", login.verify("anna","losen"));
        assertTrue(  login.verifyTjanst("123AbA#"));

    }


    @Test
    void verifyLoginWrongToken() throws WrongLoginException {


        assertEquals("123AbA#", login.verify("anna","losen"));
        assertFalse(  login.verifyTjanst("1234AbA#"));

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
