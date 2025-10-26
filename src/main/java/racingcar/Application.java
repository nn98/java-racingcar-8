package racingcar;

import racingcar.presentation.view.InputView;
import racingcar.presentation.view.OutputView;

public class Application {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        init();
    }

    public static void init() {
    }

}
