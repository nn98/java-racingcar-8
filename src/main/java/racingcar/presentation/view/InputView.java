package racingcar.presentation.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String readLine() {
        return Console.readLine();
    }

    public int readInt() {
        try {
            return Integer.parseInt(readLine());
        } catch (Exception e) {
            throw new IllegalArgumentException("숫자 값을 입력해주세요.");
        }
    }

}
