package racingcar.domain.service;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.vo.CarList;

class RacingServiceTest {

    private final RacingService racingService = new RacingService("pobi, woni, jun", 0);

    @Test
    @DisplayName("차량목록생성_성공")
    void saveCarList_success() {
        String[] cars = {"pobi", "woni", "jun"};
        CarList carListTest = new CarList(cars);
        assertThat(racingService.savedCarList()).isEqualTo(carListTest);
    }

    @Test
    @DisplayName("초기목록_공동우승_성공")
    void defaultCarList_winner_success() {
        assertThat(racingService.getRaceWinner()).isEqualTo("pobi, woni, jun");
    }

}
