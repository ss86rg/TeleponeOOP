package Model;

import Model.Writable;

import java.io.Serializable;
import java.util.*;

public class Service  implements Serializable {
    private int Id;

    private Writable writable;
    private List<User> userList;

    public Service(Writable writable){
        userList = new ArrayList<>();
        this.writable =  writable;


    }




    public String getPhoneInfo(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список контактов:\n");
        return userList.toString();
    }







    public void save(String filePath) {
        filePath = "src/FT.txt";

        writable.save((Serializable) userList, filePath);
    }


    public void read(String filePath) {
        filePath = "src/FT.txt";
        userList = (List<User>) writable.read(filePath);


    }

    public void addUser(User user) {
        userList.add(user);
    }
}
