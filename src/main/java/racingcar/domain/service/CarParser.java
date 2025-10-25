package racingcar.domain.service;

import java.util.Arrays;

public class CarParser {

    public String[] parseCar(String input) {
        checkValidInput(input);
        String[] cars;
        cars = Arrays.stream(input.split(","))
                .map(String::trim)
                .toArray(String[]::new);
        checkValidCars(cars);
        return cars;
    }

    private void checkValidInput(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("입력값이 공백입니다.");
        }
    }

    private void checkValidCars(String[] cars) {
        for (String car : cars) {
            isValidLength(car);
            isValidString(car);
        }
    }

    private void isValidLength(String car) {
        if (car.isBlank()) {
            throw new IllegalArgumentException("자동차 이름이 공백입니다.");
        }
        if (car.length() > 5) {
            throw new IllegalArgumentException("자동차 이름의 길이가 5를 초과합니다.");
        }
    }

    private void isValidString(String car) {
        if (car.contains("\\")) {
            throw new IllegalArgumentException("자동차 이름에 escape sequence가 포함되어 있습니다.");
        }
    }

}
