package racingcar.domain.service;

import racingcar.domain.vo.CarList;

public class RacingService {

    private final CarList carList;
    private final int tryCount;

    public RacingService(String input, int tryCount) {
        this.carList = new CarList(parseCars(input));
        this.tryCount = tryCount;
    }

    private String[] parseCars(String input) {
        CarParser carParser = new CarParser();
        return carParser.parseCar(input);
    }

    public CarList saveCarList() {
        return this.carList;
    }

}
