package racingcar.domain.impl;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.common.exception.IllegalArgumentException;
import racingcar.domain.service.CarParser;

public class CarParserImplTest {

    @Test
    @DisplayName("파싱_성공")
    void parsing_success() {
        CarParser carParser = new CarParserImpl();
        assertThat(carParser.parseCar("pobi,woni,jun")).isEqualTo(new String[]{"pobi", "woni", "jun"});
    }

    @Test
    @DisplayName("파싱_성공_공백포함")
    void parsing_success_with_blank() {
        CarParser carParser = new CarParserImpl();
        assertThat(carParser.parseCar("pobi , woni , jun ")).isEqualTo(new String[]{"pobi", "woni", "jun"});
    }

    @Test
    @DisplayName("파싱_실패_공백")
    void parsing_fail_on_blank() {
        CarParser carParser = new CarParserImpl();
        assertThatThrownBy(() -> carParser.parseCar("")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("파싱_실패_중복")
    void parsing_fail_on_duplicate() {
        CarParser carParser = new CarParserImpl();
        assertThatThrownBy(() -> carParser.parseCar("pobi,woni,pobi")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("파싱_실패_길이")
    void parsing_fail_on_length() {
        CarParser carParser = new CarParserImpl();
        assertThatThrownBy(() -> carParser.parseCar("pobi,woni,nonamed")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("파싱_실패_이스케이프")
    void parsing_fail_on_escape() {
        CarParser carParser = new CarParserImpl();
        assertThatThrownBy(() -> carParser.parseCar("\\pobi,\nwoni")).isInstanceOf(IllegalArgumentException.class);
    }
}
