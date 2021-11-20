import java.util.HashMap;

public class Login {

    HashMap<String, Member> members = new HashMap<String, Member>();
    Member anna = new Member("anna","losen");
    Member berit = new Member("berit","123456");
    Member kalle = new Member("kalle","password");

    public void setMembers() {

        members.put("anna",anna);
        members.put("berit",berit);
        members.put("kalle",kalle);


    }



    public String verify(String name, String password) throws WrongLoginException {

      if (members.containsKey(name)){

          if (members.get(name).passwrod.equals(password)){
              return "123AbA#";
          }else{
              throw new WrongLoginException("Wrong password!");
          }
      }else{
          throw new WrongLoginException("Wrong name!");
      }
    }





    public Boolean verifyTjanst(String token)  {

            if (token.equals("123AbA#")){
                return true;
            }else{
                return false;
            }

    }
}


