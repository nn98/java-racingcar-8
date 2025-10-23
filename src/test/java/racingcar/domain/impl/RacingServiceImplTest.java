package racingcar.domain.impl;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.entity.Car;
import racingcar.domain.service.RacingService;
import racingcar.domain.vo.CarList;

public class RacingServiceImplTest {

    private final RacingService racingService = new RacingServiceImpl(new String[]{"pobi", "woni", "jun"});

    @Test
    @DisplayName("차량목록생성_성공")
    void saveCarList_success() {
        Car car = new Car("pobi", 0);
        List<Car> cars = new ArrayList<>();
        cars.add(car);
        CarList carListTest = new CarList(cars);
        assertThat(racingService.saveCarList()).isEqualTo(carListTest);
    }
}
