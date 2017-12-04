package classes;

import java.util.ArrayList;

public class User {

    private String userName;
    private String eMail;
    private String password;

    public User(String userName, String eMail, String password) {
        this.userName = userName;
        this.eMail = eMail;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static class Users{
        private static ArrayList<User> users = new ArrayList<>();

        public static ArrayList<User> getUsers() {
            return users;
        }

        public static void setUsers(ArrayList<User> users) {
            Users.users = users;
        }

        public static User userByEMail(String eMail){
            User temp = null;
            for (User user:users) {
                if(user.geteMail().equalsIgnoreCase(eMail)){
                    temp = user;
                }
            }
            return temp;
        }


        public static User userByName (String usName){
            User temp = null;
            for (User user: users){
                if(user.getUserName().equalsIgnoreCase(usName)){
                    temp = user;
                }
            }
            return temp;
        }

        public static void addUser(User user){
            users.add(user);
        }

    }

}
