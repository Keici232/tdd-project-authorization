import java.util.HashMap;
import java.util.UUID;

public class Login {

    HashMap<String, Member> members = new HashMap<String, Member>();
    Member anna = new Member("anna", encryptPassword("losen"), "ACCOUNT", "read");
    Member berit = new Member("berit", encryptPassword("123456"), "ACCOUNT", "read and write");
    Member kalle = new Member("kalle", encryptPassword("password"), "PROVISION_CALC", "execute");

    String token_for_read = "123AbA#";
    String token_for_read_and_write = "1234AbZ¤";
    String token_for_execute = "2345Bne&";

    public void setMembers() {
        members.put("anna", anna);
        members.put("berit", berit);
        members.put("kalle", kalle);
    }


    public String encryptPassword(String password) {
        int key = 6;
        String encryptedPassword = "";

        char[] charPassword = password.toCharArray();

        for (char c : charPassword) {
            c += key;
            encryptedPassword += c;
        }
        return encryptedPassword;
    }


    public String decryptPassword(String password) {
        int key = 6;
        String decryptedPassword = "";
        char[] charPassword = password.toCharArray();
        for (char c : charPassword) {
            c -= key;
            decryptedPassword += c;
        }
        return decryptedPassword;
    }


    public String verify(String name, String password) throws WrongLoginException {

        String encryptedPassword = encryptPassword(password);

        if (members.containsKey(name)) {
            if (members.get(name).password.equals(encryptedPassword)) {
                return tokenAuthorization(name);
            } else {
                throw new WrongLoginException("Wrong password!");
            }
        } else {
            throw new WrongLoginException("Wrong name!");
        }
    }

    public String tokenAuthorization(String name) throws WrongLoginException {
        switch (members.get(name).getGroup()) {
            case "read":
                return token_for_read;
            case "read and write":
                return token_for_read_and_write;
            case "execute":
                return token_for_execute;
            default:
                throw new WrongLoginException("Username or password didn´t match!");
        }
    }

    public String verifyTjanst(String token, String resurs) {

        if (token.equals(token_for_read) && resurs.equals("ACCOUNT")) {
            return "READ";
        } else if (token.equals(token_for_read_and_write) && resurs.equals("ACCOUNT")) {
            return "READ AND WRITE";
        } else if (token.equals(token_for_execute) && resurs.equals("PROVISION_CALC")) {
            return "EXECUTE";
        } else {
            return "does not exist";
        }
    }
}


