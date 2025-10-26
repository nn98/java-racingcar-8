package racingcar.domain.service;

import racingcar.domain.vo.CarList;

public class RacingService {

    private final CarList carList;
    private int tryCount;

    public RacingService(String input, int tryCount) {
        this.carList = new CarList(parseCars(input));
        this.tryCount = tryCount;
    }

    private String[] parseCars(String input) {
        CarParser carParser = new CarParser();
        return carParser.parseCar(input);
    }

    public boolean racing() {
        if (this.tryCount > 0) {
            this.carList.raceCars();
            this.tryCount -= 1;
        }
        return this.tryCount > 0;
    }

    public String getCarStatus() {
        return this.carList.statusToString();
    }

    public CarList saveCarList() {
        return this.carList;
    }

}
