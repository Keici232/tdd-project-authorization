import java.util.HashMap;

public class Login {

    HashMap<String, String> members = new HashMap<String, String>();

    public void setMembers() {
        members.put("anna","losen");
        members.put("berit","123456");
        members.put("kalle","password");


    }



    public String verify(String name, String password) throws WrongLoginException {

      if (members.containsKey(name)){

          if (members.get(name).equals(password)){
              return name;
          }else{
              throw new WrongLoginException("Wrong password!");
          }
      }else{
          throw new WrongLoginException("Wrong name!");
      }
    }





    public Boolean verifyTjanst(String name)  {

            if (members.containsKey(name)){
                return true;
            }else{
                return false;
            }

    }
}


