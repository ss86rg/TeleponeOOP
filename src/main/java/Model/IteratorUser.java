package Model;

import java.util.Iterator;
import java.util.List;

public class IteratorUser <User> implements Iterator<User>{
    private int index;
    private List<User> userList;
    public IteratorUser( List<User>userList){this.userList = userList;

    }
    @Override
    public boolean hasNext() {
        return index < userList.size();
    }

    @Override
    public User next() {
        return userList.get(index++);
    }
}
