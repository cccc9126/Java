package bt2;

public class Main {
    public static void main(String[] args) {
        Vehicle car = new Car("Toyota");
        Vehicle bicycle = new Bicycle("Giant");

        car.move();
        bicycle.move();
    }
}

