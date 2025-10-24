package racingcar.domain.service;

public class CarParser {

    public String[] parseCar(String s) {
        return s.split(",");
    }

}
