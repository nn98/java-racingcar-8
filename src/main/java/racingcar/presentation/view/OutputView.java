package racingcar.presentation.view;

import racingcar.common.constant.Message;

public class OutputView {

    public void noticeCarName() {
        System.out.println(Message.NOTICE_INPUT_CAR_NAME);
    }

    public void noticeTryCount() {
        System.out.println(Message.NOTICE_INPUT_TRY_COUNT);
    }

    public void noticeRaceResult() {
        System.out.println(Message.NOTICE_RACE_RESULT);
    }
}
