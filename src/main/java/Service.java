import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Service implements Iterable<User> {
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


    public void save() {
        String filePath = "src/FT.txt";

        writable.save((Serializable) userList, filePath);

    }




    public void read () {
        String filePath = "src/FT.txt";
        userList = (List<User>) writable.read(filePath);

    }


    public void addUser(User user){
        userList.add(user);
        user.setId(Id++);
    }

    @Override
    public Iterator<User> iterator() {
        return new IteratorUser<>(userList);
    }
}
