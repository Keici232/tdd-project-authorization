import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class proTest {
    private Login login;

    @BeforeEach
    void setUp() {
        login = new Login();
        login.setMembers();
    }

    @Test
    void verifyLoginTrue() throws WrongLoginException {


        assertEquals("anna", login.verify("anna","losen"));
        assertEquals(true,  login.verifyTjanst(login.verify("anna","losen")));

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
