package racingcar.domain.service;

import java.util.Arrays;

public class CarParser {

    public String[] parseCar(String input) {
        checkValidInput(input);
        String[] cars;
        cars = Arrays.stream(input.split(","))
                .map(String::trim)
                .toArray(String[]::new);
        return cars;
    }

    private void checkValidInput(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("입력값이 공백입니다.");
        }
    }

}
