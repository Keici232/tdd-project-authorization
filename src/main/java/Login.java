import java.util.HashMap;

public class Login {

    HashMap<String, Member> members = new HashMap<String, Member>();
    Member anna = new Member("anna",encryptPassword("losen"));
    Member berit = new Member("berit",encryptPassword("123456"));
    Member kalle = new Member("kalle",encryptPassword("password"));

    public void setMembers() {

        members.put("anna",anna);
        members.put("berit",berit);
        members.put("kalle",kalle);


    }



   public String encryptPassword(String password){
        int key = 6;
        String encryptedPassword = "";

       char[] charPassword = password.toCharArray();

       for (char c:charPassword) {
           c += key;
           encryptedPassword +=c;

       }

    return encryptedPassword;
   }



    public String decryptPassword(String password){
        int key = 6;
        String decryptedPassword= "";
        char[] charPassword = password.toCharArray();
        for (char c:charPassword) {
            c -= key;
            decryptedPassword +=c;
        }

        return decryptedPassword;

    }



    public String verify(String name, String password) throws WrongLoginException {

        String encryptedPassword = encryptPassword(password);

      if (members.containsKey(name)){

          if (members.get(name).passwrod.equals(encryptedPassword)){
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


