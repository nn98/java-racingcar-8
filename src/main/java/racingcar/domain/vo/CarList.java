package racingcar.domain.vo;

import static racingcar.common.constant.Value.MAX_RANGE;
import static racingcar.common.constant.Value.NIN_RANGE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import racingcar.domain.entity.Car;

public class CarList {

    private final List<Car> cars;

    public CarList(String[] cars) {
        this.cars = getCarList(cars);
    }

    private List<Car> getCarList(String[] cars) {
        List<Car> list = new ArrayList<>();
        for (String carName : cars) {
            Car car = new Car(carName, 0);
            list.add(car);
        }
        return list;
    }

    public String statusToString() {
        return cars.stream()
                .map(Car::toString)
                .collect(Collectors.joining("\n"));
    }

    public String getWinners() {
        int maxPosition = getMaxPosition();
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getCarName)
                .collect(Collectors.joining(", "));
    }

    public int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }

    public void raceCars() {
        for (Car car : cars) {
            car.move(generateRandomValue());
        }
    }

    private int generateRandomValue() {
        return Randoms.pickNumberInRange(NIN_RANGE, MAX_RANGE);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CarList carList = (CarList) o;
        return Objects.equals(cars, carList.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(cars);
    }

}
