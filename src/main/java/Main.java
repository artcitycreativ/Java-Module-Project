import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Car> carList = new ArrayList<>();
    Race race = new Race();
    String commad = "start";

    public void main(String[] args) {
        while(true)
        {
            if(Objects.equals(commad, "start"))
            {
                this.commandStart();
            } else if(Objects.equals(commad, "exit"))
            {
                break;
            }
        }
    }
    public void commandStart()
    {
        if(carList.isEmpty())
        {
            System.out.println("Введите данные 3-х автомобилей для начала гонки.\nВ этой гонке только одно правило: Допускаются автомобили со скоростью не выше 250 км/ч");
        }
        if(carList.size() < 3) {
            addCars();
        } else {
            race.start(carList);
            carList.clear();
            commad = scanner.nextLine();
        }
    }
    public void addCars()
    {
        System.out.println("Введите название " + (carList.size() + 1) + "-го автомобиля");
        String name = scanner.nextLine();

        System.out.println("Введите скорость автомобиля '"+ name +"'");
        int speed = scanner.nextInt();
        if (speed >= 0 && speed <= 250) {
            carList.add(new Car(name, speed));
            System.out.println("Введите скорость автомобиля (0-250)");
        } else if(speed < 0) {
            System.out.println("С этим автомобилем что-то не так. Данный автомобиль дисквалифицирован.");
        } else {
            System.out.println("Превышена максимальная скорость автомобиля. Данный автомобиль дисквалифицирован.");
        }
    }
}
