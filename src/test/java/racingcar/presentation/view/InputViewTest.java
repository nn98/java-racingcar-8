package racingcar.presentation.view;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputViewTest extends NsTest {

    private final InputView inputView = new InputView();
    private String result;

    @Test
    @DisplayName("사용자_입력_성공")
    void user_input_success() {
        run("pobi,jun", "1");
        assertThat(result).isEqualTo("pobi,jun");
    }

    @Override
    public void runMain() {
        result = inputView.readLine();
    }
}
