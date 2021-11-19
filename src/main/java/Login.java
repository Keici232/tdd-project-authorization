import java.util.ArrayList;
import java.util.HashMap;

public class Login {

    HashMap<String, String> members = new HashMap<String, String>();

    public void setMembers() {
        members.put("anna","losen");
        members.put("berit","123456");
        members.put("kalle","password");


    }



    public boolean verify(String name, String password) {
        setMembers();

        if (members.get(name).equals(password)){
            return true;
        }else{
            return false;
        }
    }
}
