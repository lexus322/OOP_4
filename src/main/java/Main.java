
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Fio<Model> fio = new Fio<>();

//        fio.post(new Model("Алексей","Тюрин","Олегович"));
//        fio.post(new Model("Иван","Иванов","Иванович"));
//        fio.update(0,2,"Санечка");

        Scanner a = new Scanner(System.in);
        fio.menu();
        boolean exit = true;
        while (exit) {
            int b = fio.menuChoice(a.nextInt());
            if (b == 4){
                exit = false;
            }
        }


    }
}
