import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


@Getter
@Setter
public class Fio <T extends Model> implements Action {

    private final List<T> allUsers;
    Scanner a = new Scanner(System.in);

    public Fio() {
        this.allUsers = new ArrayList<>();
    }


    public void printAllUsers(){
        for (int i = 0; i<allUsers.size(); i++)
        {

            String a = String.format("\u001B[0m"+ "%d %s %s %s",i,allUsers.get(i).firstName,allUsers.get(i).middleName,allUsers.get(i).lastName);
            System.out.println(a);
            System.out.println("\u001B[31m"+"---------------------------------------------");
        }
    }
    public void menu(){
        System.out.println("\u001B[0m"+"---------------------МЕНЮ--------------------");
        System.out.println("1 - Добавить Пользователя" + "\n" + "2 - Изменить пользователя" + "\n" + "3 - Удалить пользователя" + "\n" +
                "4 - Выход");

    }
    public int menuChoice(int numberMenu){
        Scanner a = new Scanner(System.in);
        switch (numberMenu){
            case 1:
                post(new Model());
                menu();
                break;
            case 2:
                System.out.println("\u001B[31m"+"------ВВЕДИТЕ ID КОГО ХОТЕЛИ БЫ ИЗМЕНИТЬ-----");
                printAllUsers();
                int idUser = a.nextInt();
                System.out.println("\u001B[0m"+"Вы выбрали для изменения " + "\n" + String.format("\u001B[32m"+"%s %s %s",allUsers.get(idUser).firstName,allUsers.get(idUser).middleName,allUsers.get(idUser).lastName));
                System.out.println("\u001B[0m"+"1 - Изменить Имя" + "\n" + "2 - Изменить Отчество" + "\n" + "3 - Изменить Фамилию");
                int choiceUpdate = a.nextInt();
                update(idUser,choiceUpdate);
                menu();
                break;
            case 3:
                System.out.println("\u001B[31m"+"------ВВЕДИТЕ ID КОГО ХОТЕЛИ БЫ УДАЛИТЬ------");
                printAllUsers();
                int idUserDelete = a.nextInt();
                delete(idUserDelete);
                menu();
                break;
            case 4:
                System.out.println("Спасибо за внимание");
                break;

        }
        return numberMenu;
    }
    @Override
    public void update(int a, int b) {
        Scanner scan = new Scanner(System.in);
        switch (b) {
            case 1:
                System.out.print("Введите новое имя ");
                allUsers.get(a).setFirstName(scan.next());
                System.out.println("\u001B[31m"+"---------ПОЛЬЗОВАТЕЛЬ ПОСЛЕ ИЗМЕНЕНИЯ--------");
                String result = String.format("\u001B[0m"+ "%d "+"\u001B[32m"+"%s "+"\u001B[0m"+"%s %s",a,allUsers.get(a).firstName,allUsers.get(a).middleName,allUsers.get(a).lastName);
                System.out.println(result);
                System.out.println("\u001B[31m"+"---------------------------------------------");
                break;
            case 2:
                System.out.print("Введите новую фамилию ");
                allUsers.get(a).setMiddleName(scan.next());
                printAllUsers();
                break;
            case 3:
                System.out.print("Введите новое отчество ");
                allUsers.get(a).setLastName(scan.next());
                printAllUsers();
                break;
            default:
                System.out.println("Вы выбрали несуществующее действие");
                break;
        }
    }

    @Override
    public void delete(int a) {
        allUsers.remove(a);
        if(allUsers.isEmpty()){
            System.out.println("\u001B[31m"+"------------СПИСОК ПОЛЬЗОВАТЕЛЕЙ-------------");
            System.out.println("\u001B[0m"+"-----------------СПИСОК ПУСТ-----------------");
            System.out.println("\u001B[31m"+"---------------------------------------------");
        }else{
            System.out.println("\u001B[31m"+"-----СПИСОК ПОЛЬЗОВАТЕЛЕЙ ПОСЛЕ УДАЛЕНИЯ-----");
            printAllUsers();
        }

    }

    @Override
    public void post(Model user) {
        System.out.print("Введите имя ");
        user.firstName = a.nextLine();
        while(user.firstName.isEmpty()){
            System.out.println("Поля Имя обязательно к заполнениею," + "\n" +"Введите имя: ");
            user.firstName = a.nextLine();
        }
        System.out.print("Введите Отчество ");
        user.middleName = a.nextLine();
        System.out.print("Введите Фамилию ");
        user.lastName = a.nextLine();
        allUsers.add((T) user);
        System.out.println("\u001B[32m"+"---------НОВЫЙ ПОЛЬЗОВАТЕЛЬ ДОБАВЛЕН---------");
        System.out.println("\u001B[31m"+"------------СПИСОК ПОЛЬЗОВАТЕЛЕЙ-------------");
        printAllUsers();
    }
}
