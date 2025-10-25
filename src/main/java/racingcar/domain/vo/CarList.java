package racingcar.domain.vo;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.entity.Car;

public class CarList {

    private final List<Car> carList;

    public CarList(String[] cars) {
        this.carList = getCarList(cars);
    }

    private List<Car> getCarList(String[] cars) {
        List<Car> carList = new ArrayList<>();
        for (String carName : cars) {
            Car car = new Car(carName, 0);
            carList.add(car);
        }
        return carList;
    }

    public String statusToString() {
        StringBuilder status = new StringBuilder();
        for (Car car : carList) {
            status.append(car.toString());
            status.append("\n");
        }
        return status.toString();
    }

}
