package racingcar.presentation.view;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OutputViewTest extends NsTest {

    private final OutputView outputView = new OutputView();

    @Test
    @DisplayName("입력_안내문_출력")
    void print_input_notice() {
        run();
        assertThat(output()).contains(
                "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)",
                "시도할 횟수는 몇 회인가요?"
        );
    }

    @Override
    public void runMain() {
        outputView.noticeCarName();
        outputView.noticeTryCount();
    }
}
