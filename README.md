# ✅ 체크리스트

---

# 🏆 도전

- ### TDD
    - DDD와 더불어 정리한 기능 목록으로 테스트 먼저 구현하기
- ### DDD
    - [이전 프로젝트](https://github.com/nn98/Mind_bridge/tree/layered_DDD)에서 MVC ➡️ DDD 시도 중 구조만 변경하고 보류했던걸 재활용해보기

---

# 🫤 고민

### 💡 컨트롤러의 필요성

- [레이어드 아키텍처와 MVC 패턴](https://github.com/nn98/java-racingcar-8/wiki/Layered_Architecture-&-MVC_Pattern)
- ⬆️ 에서의 고뇌와 학습을 끝내고, 돌고 돌고 돌아서 이 고민의 근본 원인으로 돌아와보자
- [1주차](https://velog.io/@nn98/%EC%9A%B0%EC%95%84%ED%95%9C%ED%85%8C%ED%81%AC%EC%BD%94%EC%8A%A4-%ED%94%84%EB%A6%AC%EC%BD%94%EC%8A%A4-1%EC%A3%BC%EC%B0%A8-%ED%9A%8C%EA%B3%A0)
  에서 회고했듯이 클린 아키텍처에 과도하게 집중하지 않기로 한 내 기준에 따르면  
  지금의 프로젝트 구조는 과도한 분리가 부분부분 보인다
- 컨트롤러가 presentation 계층에 속한다 판단한 이유가 `엔드포인트는 사용자에게 노출되니까` 였는데,  
  이번 미션에서 과연 사용자에게 노출될 엔드포인트나 컨트롤러의 영역이 있을까?
- 사용자에게 노출될 것은 그저 입/출력 InputView/OutputView 뿐인데?
- 컨트롤러를 제거한다면 문제는?
    - 애플리케이션이 직접 뷰와 도메인을 연결하고 조율한다
    - == 그게 컨트롤러가 하는 역할이네
    - 복합 서비스도 아니고, 단일 책임 파괴도 아니면 안할 이유가?
- 컨트롤러 삭 제

---

## 📋 요구사항

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

- ~~잘못된 값 입력 시 `IllegalArgumentException` 발생, 애플리케이션 종료~~ 검증 단계로 이관

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

- 경주할 자동차 이름에 쉼표`,`는 포함되지 않는다 가정
- `❓공백도 자동차 이름으로 판단?`
- `❓중복된 자동차 이름 처리?`
- 예외 처리 시점
    - 문제 설명 `사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.` 및
    - 기본 테스트 `예외_테스트` 를 참고할 때,
    - 모든 사용자 입력이 완료된 이후 예외 처리를 진행함을 확인

### ❗ 비즈니스 로직

- [ ] 사용자 입력값 파싱
    - [ ] 쉼표`,`를 기준으로 분할
    - [ ] 입력값 검증. 조건에 부합하지 않을 경우 예외 발생, 애플리케이션 종료
        - `조건`
        - [ ] 공백이 아님
        - [ ] 중복이 아님
        - [ ] 길이가 5 이하임
        - [ ] 이스케이프 문자가 포함되지 않음
    - [ ] 각 자동차의 이름과 위지를 저장할 객체 생성 - `private List<Car> createCarList`
        - [ ] `class Car`
        - [ ] String name
        - [ ] int position
    - [ ] 생성한 객체들을 모아 일급 컬렉션으로 저장 - `private CarList saveCarList`
        - [ ] `class CarList` - `❓일급 컬렉션은 불변성을 보장해야?`
        - [ ] private List<Car> carList
        - [ ] public String statusToString() - 자동차의 전진 상태, 자동차 이름 리턴
        - [ ] private void moveCars() - 주어진 횟수 동안 자동차들을 전진 혹은 정지
        - [ ] private boolean isMove() - 0에서 9 사이의 무작위 값`pickNumberInRange()`이 4 이상일 경우 move 리턴
        - `❓랜덤값으로 움직임이 결정되는데 테스트를 구현할 방법이?`
            - [ ] `moveCars()`가 int를 매개변수로 받아 동작하게 구현하면 가능.
            - [ ] private를 풀고 동작 여부를 확인 가능하도록?
            - [ ] Car 도 엔티티니 Car 내부 동작으로 구현?
        - [ ] public String getWinners() - 주어진 횟수 소진 후 최종 전진 거리를 비교해 승자 목록 리턴
    - [ ] 

### 💡 생각할 부분

- `❓일급 컬렉션은 불변성을 보장해야?`
    - [일급 컬렉션에 대해 소개한 아티클](https://jojoldu.tistory.com/412)에 의하면, 일급 컬렉션의 이점으로  
      `Collection의 불변성을 보장`을 들고 있다. 그렇다면 일급 컬렉션은 Collection의 불변성을 `반드시` 보장해야 하는가?
- `❓랜덤값으로 움직임이 결정되는데 테스트를 구현할 방법이?`
    - 메서드의 로직 그대로 테스트를 진행할 경우, 일정한 결과값을 확인할 수 없다.
    - 주어진 ApplicationTest의 `기능_테스트()`는? 같이 주어지는 `MOVING_FORWARD, STOP`이 키인가?
    - `❗동일 기능을 랜덤이 아닌 매개변수값으로 테스트하는 메서드 오버로딩?`
        - 오로지 테스트만을 위한 기능을 만드는 것은 테스트의 근본 목적을 망각한 주객전도의 상황.
        - **불가.**

---

## 📜 설계

> /
> > domain
> > > entity
> > > > `Car`
> > >
> > > vo
> > > > `CarList`
> > >
> > > service
> > > > `RacingService`  
> > > > `CarParser`
> > >
> > > impl
> > > > `RacingServiceImpl`  
> > > > `CarParserImpl`
> >
> > presentation
> > > view
> > > > `InputView`  
> > > > `OutputView`
> > >
> > > controller
> > > > `RacingController`
> >
> > common
> > > constant
> > > > `Message`  
> > > > `Value`
> > >
> > > exception
> > > > `IllegalArgumentException`

- ### cmd에서 `tree /f`를 실행하면 보기 좋고 편하게 구조를 도식화 가능

```json
└─racingcar
│  Application.java
│
├─common
│  ├─constant
│  │      Message.java
│  │      Value.java
│  │
│  └─exception
│          IllegalArgumentException.java
│
├─domain
│  ├─vo
│  │      CarList.java
│  │
│  ├─entity
│  │      Car.java
│  │
│  ├─service
│  │      RacingService.java
│  │      CarParser.java
│  │
│  └─impl
│          RacingServiceImpl.java
│          CarParserImpl.java
│
└─presentation
├─view
│      InputView.java
│      OutputView.java
│
└─controller
RacingController.java
```