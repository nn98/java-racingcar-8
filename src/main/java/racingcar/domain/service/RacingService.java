package racingcar.domain.service;

import racingcar.domain.vo.CarList;

public class RacingService {

    private final CarList carList;

    public RacingService(String[] cars) {
        this.carList = new CarList(cars);
    }

    public CarList saveCarList() {
        return this.carList;
    }
}
