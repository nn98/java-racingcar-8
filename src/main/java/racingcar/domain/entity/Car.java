package racingcar.domain.entity;

public class Car {

    private final String carName;
    private final int position;

    public Car(String name, int position) {
        this.carName = name;
        this.position = position;
    }

    public void move(int randomValue) {
    }

}
