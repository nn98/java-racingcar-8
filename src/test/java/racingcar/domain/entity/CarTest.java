package racingcar.domain.entity;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    @DisplayName("이동_성공")
    void move_success() {
        Car car = new Car("pobi", 0);
        car.move(4);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("부동_성공")
    void hold_success() {
        Car car = new Car("pobi", 0);
        car.move(0);
        assertThat(car.getPosition()).isZero();
    }
}
