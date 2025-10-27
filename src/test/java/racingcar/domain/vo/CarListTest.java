package racingcar.domain.vo;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarListTest {

    private final String[] cars = {"pobi", "woni", "jun"};
    private final CarList carListTest = new CarList(cars);

    @Test
    @DisplayName("상태_확인_성공")
    void check_status_success() {
        assertThat(carListTest.statusToString()).isEqualTo("pobi : \nwoni : \njun : ");
    }

    @Test
    @DisplayName("승자_확인_성공")
    void check_winner_success() {
        assertThat(carListTest.getWinners()).isEqualTo("pobi, woni, jun");
    }

    @Test
    @DisplayName("최대거리_확인_성공")
    void check_max_position_success() {
        assertThat(carListTest.getMaxPosition()).isZero();
    }

}
