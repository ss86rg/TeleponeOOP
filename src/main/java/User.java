import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class User   implements  Serializable {
    private int Id;
    private String name;
    private String patronymic;
    private String lastname;
    private Gender gender;
    private LocalDate birthdate;
    private String phoneNumber;
    private List<User> userlist;



    public User(int Id, String name, String patronymic, String lastname, Gender gender, LocalDate birthdate, String phoneNumber) {
        Id = 0;
        this.name = name;
        this.patronymic = patronymic;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        userlist = new ArrayList<>();



    }


//    public void add(User user){
//        userlist.add(user);
//        user.setId(Id++);
//    }



    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }
    public void addUser(User user){
        userlist.add(user);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof User)) {
            return false;
        }
        User User = (User) obj;
        return User.getId() == getId();

    }

    @Override
    public String toString() {

        return "\nАбонент:" +
                "Id:" + Id +
                ", Имя: " + name  +
                ", Отчество:" + patronymic  +
                ", Фамилия:" + lastname  +
                ", пол:" + gender +
                ", Дата рождения:" + birthdate +
                ", Номер телефона: " + phoneNumber;
    }



}
