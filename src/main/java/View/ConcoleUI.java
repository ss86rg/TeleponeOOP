package View;

import Model.Gender;
import Presentr.Presenter;

import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class ConcoleUI implements View {
    private static final String INPUT_ERROR = "Вы ввели неверное значение";
    private Scanner scanner;
    private Presenter presenter;
    private boolean work;
    private MainMenu menu;
    private  int Id;

    public ConcoleUI(SystemColor menu) {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        work = true;
        this.menu = new MainMenu(this);
    }


    @Override
    public void printAnswer(String text) {
        System.out.println(text);

    }

    @Override
    public void start() {
        while (work) {
            printMenu();
            execute();
        }
    }

    private void execute(){
        String line = scanner.nextLine();
        if (checkTextForInt(line)){
            int numCommand = Integer.parseInt(line);

            if (checkCommand(numCommand)){
                menu.execute(numCommand);

            }
        }
    }



    private boolean checkTextForInt(String text){
        if (text.matches("[0-9]+")){
            return true;
        } else {
            inputError();
            return false;
        }
    }

    private boolean checkCommand(int numCommand){
        if (numCommand <= menu.getSize()){
            return true;
        } else {
            inputError();
            return false;
        }
    }

    private void printMenu(){
        System.out.println(menu.menu());
    }

    private void inputError(){
        System.out.println(INPUT_ERROR);
    }

    public void getPhoneInfo() {presenter.getPoneInfo();
    }



    void saveAndExit() {
        presenter.saveData();
        work = false;
        System.exit(0);

    }
    void Read () {
        presenter.read();
        presenter.getPoneInfo();
    }

    public void AddUser(){

        try {
            System.out.println("Введите Имя абонента: ");
            String name = scanner.nextLine();
            checkStringForLettersOnly(name);

            System.out.println("Отчество:");
            String patronymic = scanner.nextLine();
            checkStringForLettersOnly(patronymic);

            System.out.println("Фамилию:");
            String lastname = scanner.nextLine();
            checkStringForLettersOnly(lastname);

            System.out.println("Введите пол (мужской/m, женсий/f):");
            Gender gender = parseGender(scanner.nextLine());

            System.out.println("Дата Рождения (dd.mm.yyyy):");
            String birthDateStr = scanner.nextLine();
            LocalDate birthDate = parseDate(birthDateStr);

            System.out.println("номер телефона:");
            String phoneNumber = scanner.nextLine();
            checkPhoneNumber(phoneNumber);

            presenter.addUser(Id++, name, patronymic, lastname, gender, birthDate, phoneNumber);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка ввода: " + e.getMessage());
        } catch (DateTimeParseException e) {
            System.out.println("Неверный формат даты. Ожидается формат dd.mm.yyyy.");
        } catch (Exception e) {
            System.out.println("Произошла ошибка: " + e.getMessage());
            e.printStackTrace();
        }
    }
    private void checkPhoneNumber(String phoneNumber) {
        if (!phoneNumber.matches("\\d+")) {
            throw new IllegalArgumentException("Номер телефона должен содержать только цифры.");
        }
    }

    private void checkStringForLettersOnly(String str) {
        if (!str.matches("[a-zA-Zа-яА-Я]+")) {
            throw new IllegalArgumentException("Строка должна содержать только буквы.");
        }
    }

    private Gender parseGender(String genderStr) {
        if (genderStr.equalsIgnoreCase("m")) {
            return Gender.m;
        } else if (genderStr.equalsIgnoreCase("f")) {
            return Gender.f;
        } else {
            throw new IllegalArgumentException("Неверный формат пола. Ожидается 'm' или 'f'.");
        }
    }

    private LocalDate parseDate(String dateStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return LocalDate.parse(dateStr, formatter);
    }




}
