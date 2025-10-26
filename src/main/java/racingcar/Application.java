package racingcar;

import racingcar.presentation.controller.RacingController;
import racingcar.presentation.view.InputView;
import racingcar.presentation.view.OutputView;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        RacingController controller = new RacingController(inputView, outputView);
        controller.run();
    }

}
