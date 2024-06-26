import java.util.ArrayList;

public class Race {
    String leader;
    int distance = 0;

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
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(i + "й круг пройден!");
        }
    }
    public void start(ArrayList<Car> carList)
    {
        for(int i = 3; i > 0; i--) {
            System.out.println(i);
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
