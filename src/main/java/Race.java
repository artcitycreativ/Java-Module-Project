import java.util.ArrayList;
import java.util.Scanner;
//
public class Race {
    ArrayList<Car> carList = new ArrayList<>();

    Scanner scanner = new Scanner(System.in);
    String leader;
    int distance = 0;
    String command = "start";

    private void newLeader(String carName,int speed) {
        int distance = 24 * speed;
        if(distance > this.distance)
        {
            this.leader = carName;
        }
    }
    private void rounds()
    {
        for(int i = 1; i <= 3; i++) {
            try {
                Thread.sleep(1000);
                System.out.println(i + "й круг пройден!");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public boolean commandStart()
    {
        if(carList.isEmpty())
        {
            System.out.println("Введите данные 3-х автомобилей для начала гонки.\nВ этой гонке только одно правило: Допускаются автомобили со скоростью не выше 250 км/ч");
        }
        if(carList.size() < 3) {
            addCars();
        } else {
            this.start(carList);
            carList.clear();
            return true;
        }
        return false;
    }
    public void addCars()
    {
        System.out.println("Введите название " + (carList.size() + 1) + "-го автомобиля");
        String name = scanner.next();

        System.out.println("Введите скорость автомобиля '"+ name +"' (0-250)");
        int speed = scanner.nextInt();
        if (speed >= 0 && speed <= 250) {
            carList.add(new Car(name, speed));

        } else if(speed < 0) {
            System.out.println("С этим автомобилем что-то не так. Данный автомобиль дисквалифицирован.");
        } else {
            System.out.println("Превышена максимальная скорость автомобиля. Данный автомобиль дисквалифицирован.");
        }
    }
    public void start(ArrayList<Car> carList)
    {
        for(int i = 3; i > 0; i--) {
            try {
                System.out.println(i);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("СТАРТ!");
        this.rounds();
        this.finish(carList);
    }
    private void finish(ArrayList<Car> carList)
    {
        for(Car item: carList) {
            this.newLeader(item.name,item.speed);
        }
        System.out.println("ФИНИШ!");
        System.out.println("Подедитель гонки - "+this.leader+"!");
        System.out.println("Для выхода напишите команду 'exit'\nДля продолжения гонок введите 'start'");

    }

}
