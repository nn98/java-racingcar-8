package racingcar.domain.entity;

public class Car {

    private final String carName;
    private final int position;

    public Car(String carName, int position) {
        this.carName = carName;
        this.position = position;
    }

    public void move(int randomValue) {
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

}
