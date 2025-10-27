package racingcar.presentation.view;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
 
class InputViewTest extends NsTest {

    private final InputView inputView = new InputView();
    private String resultString;
    private int resultInt;

    @Test
    @DisplayName("사용자_입력_성공")
    void user_input_success() {
        assertSimpleTest(
                () -> {
                    run("pobi,jun", "1");
                    assertThat(resultString).isEqualTo("pobi,jun");
                    assertThat(resultInt).isEqualTo(1);
                }
        );
    }

    @Override
    public void runMain() {
        resultString = inputView.readLine();
        resultInt = inputView.readInt();
    }

}
