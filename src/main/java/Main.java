import java.util.Objects;
import java.util.Scanner;

public class Main {

    static Race race = new Race();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = "start";

        while(true)
        {
            if(Objects.equals(command, "start"))
            {
                if(race.commandStart())
                {
                    command = scanner.nextLine();
                }
            } else if(Objects.equals(command, "exit"))
            {
                System.out.println("Завершаем работу.");
                break;
            } else {
                System.out.println("Комманда не распознана.");
                command = scanner.nextLine();
            }
        }
    }
}
