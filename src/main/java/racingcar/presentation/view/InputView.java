package racingcar.presentation.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String readLine() {
        return Console.readLine();
    }

    public int readInt() {
        try {
            int input = Integer.parseInt(readLine());
            if (input < 1) {
                throw new IllegalArgumentException("시도할 횟수는 양수로 입력해주세요.");
            }
            return input;
        } catch (Exception e) {
            throw new IllegalArgumentException("숫자 값을 입력해주세요.");
        }
    }

}
