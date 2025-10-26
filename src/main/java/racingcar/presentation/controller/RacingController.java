package racingcar.presentation.controller;

import racingcar.domain.service.RacingService;
import racingcar.presentation.view.InputView;
import racingcar.presentation.view.OutputView;

public class RacingController {

    private final InputView inputView;
    private final OutputView outputView;

    public RacingController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        RacingService racingService = initService();
    }

    private RacingService initService() {
        return new RacingService(inputView.readLine(), inputView.readInt());
    }

}
