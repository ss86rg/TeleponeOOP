package Presentr;

import Model.FileHandler;
import Model.Gender;
import Model.Service;
import Model.User;
import View.View;

import java.time.LocalDate;

public class Presenter {
    private View view;
    private Service service;


    public Presenter(View view){
        this.view = view;

        service = new Service(new FileHandler());

    }

    public void addUser(int Id, String name, String patronymic, String lastname, Gender gender, LocalDate birthdate, String phoneNumber){
        service.addUser(new User(Id++, name,  patronymic,  lastname,  gender,  birthdate,  phoneNumber));

    }

    public void getPoneInfo(){
        String info = service.getPhoneInfo();
        view.printAnswer(info);
    }


    public void saveData() {
        service.save();
    }

    public void read() {
        service.read();
    }




}
