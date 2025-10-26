package racingcar.presentation.view;

import racingcar.common.constant.Message;

public class OutputView {

    private boolean firstResultNotice;

    public OutputView() {
        this.firstResultNotice = true;
    }

    public void noticeCarName() {
        System.out.println(Message.NOTICE_INPUT_CAR_NAME);
    }

    public void noticeTryCount() {
        System.out.println(Message.NOTICE_INPUT_TRY_COUNT);
    }

    public void noticeRaceResult(String raceResult) {
        if (firstResultNotice) {
            System.out.println(Message.NOTICE_RACE_RESULT);
            firstResultNotice = false;
        }
        System.out.println(raceResult + "\n");
    }

    public void noticeRaceWinner(String raceWinner) {
        System.out.println(Message.NOTICE_RACE_WINNER + raceWinner);
    }

}
