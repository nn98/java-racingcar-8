package racingcar.domain.vo;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.entity.Car;

public class CarListTest {

    private final List<Car> cars = List.of(new Car("pobi", 0), new Car("woni", 1), new Car("jun", 2));
    private final CarList carListTest = new CarList(cars);

    @Test
    @DisplayName("상태_확인_성공")
    void check_status_success() {
        assertThat(carListTest.statusToString()).isEqualTo("pobi : \nwoni : -\njun : --");
    }

    @Test
    @DisplayName("승자_확인_성공")
    void check_winner_success() {
        assertThat(carListTest.statusToString()).isEqualTo("pobi : \nwoni : -\njun : --");
    }
}
