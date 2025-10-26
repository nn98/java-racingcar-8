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
        startRacing(racingService);
    }

    public void startRacing(RacingService racingService) {
        boolean countRemain = racingService.racing();
        this.outputView.noticeRaceResult(racingService.getCarStatus());
        if (countRemain) {
            startRacing(racingService);
        }
    }

    private RacingService initService() {
        this.outputView.noticeCarName();
        String carName = this.inputView.readLine();
        this.outputView.noticeTryCount();
        int tryCount = this.inputView.readInt();
        return new RacingService(carName, tryCount);
    }

}
