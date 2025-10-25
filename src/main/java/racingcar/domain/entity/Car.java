package racingcar.domain.entity;

import java.util.Objects;

public class Car {

    private final String carName;
    private int position;

    public Car(String carName, int position) {
        this.carName = carName;
        this.position = position;
    }

    public void move(int randomValue) {
        if (randomValue >= 4) {
            this.position += 1;
        }
    }

    @Override
    public String toString() {
        StringBuilder positionVisualization = new StringBuilder();
        for (int i = 0; i < position; i++) {
            positionVisualization.append("-");
        }
        return String.format("%s : %s", carName, positionVisualization);
    }

    public int getPosition() {
        return position;
    }

    public String getCarName() {
        return carName;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return position == car.position && Objects.equals(carName, car.carName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName, position);
    }
    
}
