import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class proTest {

    @Test
    void verifyLoginTrue() {

        Login login = new Login();
        assertEquals(true, login.verify("anna","losen"));

    }


    @Test
    void verifyLoginFalse() {

        Login login = new Login();
        assertEquals(false, login.verify("anna","losenn"));
    }









}
