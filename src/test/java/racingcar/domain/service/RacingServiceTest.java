package racingcar.domain.service;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.vo.CarList;

public class RacingServiceTest {

    private final RacingService racingService = new RacingService("pobi, woni, jun", 0);

    @Test
    @DisplayName("차량목록생성_성공")
    void saveCarList_success() {
        String[] cars = {"pobi", "woni", "jun"};
        CarList carListTest = new CarList(cars);
        assertThat(racingService.saveCarList()).isEqualTo(carListTest);
    }
}
