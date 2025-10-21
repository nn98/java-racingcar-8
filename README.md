# ✅ 체크리스트

---

## 💡 요구사항
### ❗ 코딩
- [ ] 자바 코드 컨벤션 준수
- [ ] 인덴트 상한 2 준수
- [ ] 3항 연산자 불용
- [ ] SRP 준수
### ❗ 테스트
- [ ] JUnit 5와 AssertJ를 이용하여 정리한 기능 목록이 정상적으로 작동하는지 테스트 코드로 확인한다.
### ❗ 의존성
- [ ] `camp.nextstep.edu.missionutils`에서 제공하는 `Randoms` 및 `Console` API를 사용하여 구현해야 한다.
- [ ] Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용한다.
- [ ] 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.

---

## 🛠️ 기능
### ❗ 입ㆍ출력

`입력`
- [ ] 경주할 자동차 이름 입력 
  - [ ] 쉼표`,`로 구분
  - [ ] 5자 이하만 가능  
> `pobi,woni,jun`
- [ ] 시도할 횟수 입력
> `5`
- [ ] 잘못된 값 입력 시 `IllegalArgumentException` 발생, 애플리케이션 종료

`출력`
- [ ] 차수별 실행 결과 
> pobi : --  
> woni : ----  
> jun : ---
- [ ] 단독 우승자 안내 문구
> 최종 우승자 : `pobi`
- [ ] 공동 우승자 안내 문구
> 최종 우승자 : `pobi`, jun

### 💡 생각할 부분
- 예외 처리 시점
  - 문제 설명 `사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.` 및 
  - 기본 테스트 `예외_테스트` 를 참고할 때, 
  - 모든 사용자 입력이 완료된 이후 예외 처리를 진행함을 확인

---

