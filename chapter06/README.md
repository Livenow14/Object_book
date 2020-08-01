# Chapter06_메세지와 인터페이스

- 훌륭한 객체지향 코드를 얻기 위해서는 클래스가 아니라 객체를 지향해야함.
- 객체지향 애플리케이션의 가장 중요한 재료는 클래스가 아닌 객체들이 주고 받는 메세지.
- 객체가 수신하는 메세지들이 객체의 퍼블릭 인터페이스를 구성함 .

## 01 협력과 메세지

### 클라이언트-서버 모델

- 두 협력 관계를 설명하기 위해 사용하는 전통적인 메타포
- 협력 안에서 메세지를 전송하는 객체를 **클라이언트,** 메세지를 수신하는 객체를 **서버**라고 부른다.

- 여기서는 Screening이 클라이언트 역할을 , moive는 서버의 역할을 수행한다

    ![https://user-images.githubusercontent.com/48986787/89104228-a5a9d900-d452-11ea-8695-d74d2f699fed.png](https://user-images.githubusercontent.com/48986787/89104228-a5a9d900-d452-11ea-8695-d74d2f699fed.png)

- 여기서는 Moive는 클라이언트, DiscountPolicy는 서버의 역할을 수행

    ![https://user-images.githubusercontent.com/48986787/89104230-ab072380-d452-11ea-94e4-8a401cb97c27.png](https://user-images.githubusercontent.com/48986787/89104230-ab072380-d452-11ea-94e4-8a401cb97c27.png)

- Movie 예에서 알 수 있는 것처럼 객체는 협력에 참여하는 동안 클라이언트와 서버의 역할을 동시에 수행하는 것이 일반적

    ![https://user-images.githubusercontent.com/48986787/89104356-d2122500-d453-11ea-8546-97dafdbbe0d4.png](https://user-images.githubusercontent.com/48986787/89104356-d2122500-d453-11ea-8546-97dafdbbe0d4.png)

- 객체가 독립적으로 수행할 수 있는 것보다 더 큰 책임을 수행하기 위해서는 다른 객체와 협렵해야 한다는 것이 중요.
    - 두 객체 사이의 협력을 가능하게 해주는 매개체는 메세지

### 매세지와 메세지 전송

- 객체들이 협력하기 위해 사용할 수 있는 유일한 의사소통 수단.
- 한 객체가 다른 객체에게 도움을 요청: **메세지 전송(message sending)** or **메세지 패싱(message passing)**
    - 메세지 전송: 메세지 수진자. 오퍼레이션명, 인자의 조함
- 메세지를 전송하는 객체: **메세지 전송자(message sender)**
- 메세지를 수신하는 객체: **메세지 수신자(message receiver)**

### 메세지와 메서드

- **메서드**: 메세지를 수신했을 때 실제로 실행되는 함수 또는 프로시저
- **메세지와 메서드의 구분**은 메세지 전송자와 메세지 수신자가 느슨하게 결합될 수 있게함
    - 전송자는 어떤 메세지를 전송해야하는지만 알면 됨
    - 수신자는 누가 메세지를 전송하는지 알 필요가 없음

### 퍼블릭 인터페이스와 오퍼레이션

- 객체는 안과 밖을 구분하는 뚜렷한 경계를 가짐
- **퍼블릭 인터페이스**: 객체가 의사소통을위해 외부에 공개하는 메세지의 집합
- **오퍼레이션(operation):** 프로그래밍 언어의 관점에서 퍼블릭 인터페이스에 포함된 메세지
    - 내부의 구현 코드는 제외하고 단순히 메세지와 관련된 시그니처를 가르킴
    - 구현이 아닌 수행 가능한 어떤 행동에 대한 추상화

![https://user-images.githubusercontent.com/48986787/89104750-962c8f00-d456-11ea-9436-0bb6ed791789.png](https://user-images.githubusercontent.com/48986787/89104750-962c8f00-d456-11ea-9436-0bb6ed791789.png)

### 시그니처

- **시그니처** : 오퍼레이션(또는 메서드)의 이름과 파라미터 목록을 합친 것
    - 오퍼레이션은 실행 코드 없이 시그니처만을 정의한 것
    - 메서드는 이 시그니처에 구현을 더한 것
- 다형성의 축복을 받기 위하서는 하나의 오퍼레이션에 대해 다양한 메서드를 구현해야 함.

- 객체의 퍼블릭 인터페이스가 객체의 품질을 결정하기에 메세지가 객체의 품질을 결정한다고 볼 수 있음.

## 02 인터페이스와 설계품질

- 좋은 인터페이스는 **최소한의 인터페이스**와 **추상적인 인터페이스**라는 조건을 만족해야한다.
    - **최소한의 인터페이스** : 꼭 필요한 오퍼레이션만을 인터페이스에 포함
    - **추상적인 인퍼테이스** : 어떻게 수행하는지가 아니라 무엇을 하는지를 표현
- 위의 두가지를 따르면서 잘 설계할 수 있는 가장 좋은 방법은 책임 주도 설계 방법을 따르는 것
- 퍼블릭 인터페이스의 품질에 영향을 미치는 원칙과 기법들
    - 디미터 법칙
    - 묻지 말고 시켜라
    - 의도를 드러내는 인터페이스
    - 명령-쿼리 분리

### 디미터 법칙

- 협력하는 객체 내부 구조에 대한 결합으로 인해 발생하는 설계 문제를 해결하기 위해 제안됨
- 객체 내부 구조에 강하게 결합되지 않도록 협력 경로를 제한
    - "낯선 자에게 말하지 말라 " or  "오직 인접한 이웃하고만 말하라 " or " 오직 하나의 도트만 사용하라 "
- 클래스가 특정한 조건을 만족하는 대상에게만 메세지를 전송하도록 프로그래밍 하는 것
    - 모든 클래스 C, C에 구현된 모든 메서드 M
        - 이때 M이 메세지를 전송할 수 있는 모든 객체는 M에 의해 생성된 객체나 M이 호출하는 메서드에 의해 생성된 객체, 전역 번수로 선언된 객체는 모두 M의 인자로 간주
            - M의 인자로 전달 된 클래스( C 자체를 포함)
            - C의 인스턴스 변수의 클래스
        - 이는 아래 조건을 만족하는 인스턴스에게만 메세지를 전송하는 것으로 봐도 무방
            - this 객체
            - 메서드의 매개변수
            - this의 속성
            - this의 속성인 컬렉션의 요소
            - 메서드 내에서 생성된 지역 객체

- 디미터 법칙을 따르면  shy code를 작성할 수 있음.
    - **shy code**: 불필요한 어떤것도 다른 객체에게 보여주지 않으며, 다른 객체의 구현에 의존하지 않는 코드
- 디미터 법칙을 따르는 코드는 메세지 수진자의 내부 구조가 전송자에게 노출되지 않음
- 메세지 전송자는 수신자의 내부 구현에 결합되지 않음

### 디미터 법칙과 캡슐화

- 디미터 법칙은 캡슐화를 다른 관점에서 표현한 것
- 클래스를 캡슐화하기 위해 따라야하는 구체적인 지침 제공
- 캡슐화 원칙은 클래스 내부 구현을 감춰야 한다는 사실을 강조
- 디미터 법칙은 협력하는 클래스의 캡슐화를 지키기 위해 접근해야 하는 요소를 제한

- 디미터 법칙을 위반하는 코드

```java
screening.getMovie().getDiscountConditions();
```

- **기차충돌** : 메세지 전송자가 수신자의 내부 구조에 대해 물어보고 반환받은 요소에 대해 연쇄적으로 메세지를 전송하는 경우
    - 클래스의 내부 구현이 외부로 노출됐을 때 나타남
    - 메세지 전송자는 메세지 수진자의 내부 정보를 자세히 알게 됨

- 디미터 법칙을 따르도록 개선된 코드

```java
screening.calculateFee(audienceCount);
```

- 무비판적으로 디미터 법칙을 수용하면 퍼블릭 인터페이스 관점에서 객체의 응집돠 낮아질 수 있다.

### 묻지 말고 시켜라

- 객체에 상태에 관해 묻지 말고 원하는 것을 시키는 것
- 구현되는 로직은 메세지 수신자가 담당해야할 책임
- 객체의 외부에서 해당 객체의 상태를 기반으로 결정을 내리는 것은 객체의 캡슐화를 위반
- 인터페이스는 객체가 어떻게 하는지가 아니라 무엇을 하는지를 서술해야 함

### 의도를 드러내는 인터페이스

- 메서드를 명명하는 두가지 방법
    - 메서드가 작업을 어떻게 수행하는지를 나타내도록 이름 짓는 것

        ```java
        public class PeriodCondition(){
        	public boolean isSatisfiedByPeriod(Screening screening){...}
        }

        public class SequenceCondition(){
        	public boolean isSatisfiedBySequence(Screening screening){...}
        }
        ```

        - 이런 스타일은 메서드에 대해 제대로 커뮤니케이션하지 못한다.
        - 메서드 수준에서 캡슐화를 위반한다.

    - '어떻게'가 아닌 '무엇을' 하는지를 드러내는 것

        ```java
        public class PeriodCondition(){
        	public boolean isSatisfiedBy(Screening screening){...}
        }

        public class SequenceCondition(){
        	public boolean isSatisfiedBy(Screening screening){...}
        }
        ```

        - 이를 사용하려면 동일한 타입 계층으로 묶어야 한다.

            ```java
            public interface DiscountCondition{
            	boolean isSatisfiedBy(Screening screening);
            }
            ```

            ```java
            public class PeriodCondition implements DiscountCondition(){
            	public boolean isSatisfiedBy(Screening screening){...}
            }

            public class SequenceCondition implements DiscountCondition(){
            	public boolean isSatisfiedBy(Screening screening){...}
            }

            ```

            - 이렇게 이름을 짓는 패턴을 **의도를 드러내는 선택자** 라고 부름

## 03 원칙의 함정

- 설계는 트레이드오프의 산물이기에 절대적인 원칙은 없다.
- 이번 장에서 설명한 원칙들을 적용할 때 고려해볼 만한 이슈를 살펴본다.

### 디미터 법칙은 하나의 도트(.)를 강제하는 규칙이 아니다

- 기차 충돌처럼 보이는 코드라도 객체의 내부 구현에 대한 어떤 정보도 노출하지 않는다면 그것은 디미터 법칙을 준수한 것
    - ex) Stream

### 결합도와 응집도의 충돌

![https://user-images.githubusercontent.com/48986787/89107400-dd714a80-d46b-11ea-993c-f5aa29021dc6.png](https://user-images.githubusercontent.com/48986787/89107400-dd714a80-d46b-11ea-993c-f5aa29021dc6.png)

- Theater는 Audience 내부에 포함된 Bag에 대해 질문한 후 반환된 결과를 이용해 bag의 상태를 변경 하기에 캡슐화를 위반

![https://user-images.githubusercontent.com/48986787/89107440-15788d80-d46c-11ea-96dc-84c8471bc38e.png](https://user-images.githubusercontent.com/48986787/89107440-15788d80-d46c-11ea-96dc-84c8471bc38e.png)

- 위임 메서드를 통해 객체의 내부 구조를 감추는 것은 협력에 참여하는 객체들의 결합도를 낮출 수 있는 동시에 객체의 응집도를 높일 수 있다.

![https://user-images.githubusercontent.com/48986787/89107507-7738f780-d46c-11ea-85e2-366d7df8fc09.png](https://user-images.githubusercontent.com/48986787/89107507-7738f780-d46c-11ea-85e2-366d7df8fc09.png)

- Movie에게 묻지 않고 movies 컬렉션에 포함된 전체 영화의 가격을 계산할 순 없다.
- 디미터 법칙 위반 여부는 묻는 대상이 객체인지, 자료 구조인지에 달려있다.
    - 객체는 내부 구조를 숨겨야 하므로 디미터 법칙을 따르는 것이 좋지만 자료 구조라면 당연히 내부를 노출해야 하므로 디미터 법칙을 제한할 필요가 없다.
- 소프트웨어 설계에서 법칙이란 없다. "경우에 따라 다르다"

## 04 명령-쿼리 분리 원칙

- 퍼블릭 인터페이스에 오퍼레이션을 정의할 때 참고할 수 있는 지침을 제공
- 용어 정리
    - **루틴(routine)** :  어떤 철차를 묶어 호출 가능하도록 이름을 부여한 기능
        - **프로시져(procedure)**: 정해진 절차에 따라 내부의 상태를 변경하는 루틴의 한 종류
        - **함수(function)**: 어떤 절차에 따라 필요한 값을 계산해서 반환하는 루틴의 한 종류
        - 프로시저와 함수를 구분하기 위한 제약
            - 프로시저는 부수효과를 발생시킬 수 잇지만 값을 반환할 수 없다.
            - 함수는 값을 반환할 수 있지만 부수효과를 발생시킬 수 없다.
    - **명령(Command)**: 객체의 상태를 수정하는 오퍼레이션. 개념적으로 프로시저
    - **쿼리(Query)**: 객체와 관련된 정보를 반환하는 오퍼레이션, 개념적으로 함수

- 명령과 쿼리를 분리하기 위한 두가지 규칙
    - 객체의 상태를 변경하는 명령은 반환값을 가질 수 없다.
    - 객체의 정보를 반환하는 쿼리는 상태를 변경할 수 없다.

        ex) 명령 버튼은 상태를 확인할 수 없다. 쿼리버튼은 상태를 변경시킬 수 없다.

- "질문이 답변을 수정해서는 안된다"로 표현할 수 있음

### 반복 일정의 명령과 쿼리 분리하기

- 일정 관리 소프트웨어 개발의 예

    ```java
    	public class Event {
        private String subject;
        private LocalDateTime from;
        private Duration duration;

        public Event(String subject, LocalDateTime from, Duration duration) {
            this.subject = subject;
            this.from = from;
            this.duration = duration;
        }
    		public boolean isSatisfied(RecurringSchedule schedule) {
            if (from.getDayOfWeek() != schedule.getDayOfWeek() ||
                    !from.toLocalTime().equals(schedule.getFrom()) ||
                    !duration.equals(schedule.getDuration())) {
                reschedule(schedule);
                return false;
            }

            return true;
        }

        private void reschedule(RecurringSchedule schedule) {
            from = LocalDateTime.of(from.toLocalDate().plusDays(daysDistance(schedule)),
                    schedule.getFrom());
            duration = schedule.getDuration();
        }

        private long daysDistance(RecurringSchedule schedule) {
            return schedule.getDayOfWeek().getValue() - from.getDayOfWeek().getValue();
        }
    }
    ```

- 인스턴스는 다음과 같이 생성

    ![https://user-images.githubusercontent.com/48986787/89107895-2f679f80-d46f-11ea-9d1c-969de4574a94.png](https://user-images.githubusercontent.com/48986787/89107895-2f679f80-d46f-11ea-9d1c-969de4574a94.png)

- 반복일정을 구현

    ```java
    public class RecurringSchedule {
        private String subject;
        private DayOfWeek dayOfWeek;
        private LocalTime from;
        private Duration duration;

        public RecurringSchedule(String subject, DayOfWeek dayOfWeek,
                                 LocalTime from, Duration duration) {
            this.subject = subject;
            this.dayOfWeek = dayOfWeek;
            this.from = from;
            this.duration = duration;
        }

        public DayOfWeek getDayOfWeek() {
            return dayOfWeek;
        }

        public LocalTime getFrom() {
            return from;
        }

        public Duration getDuration() {
            return duration;
        }
    }
    ```

- "매주 수요일 10시 30분 부터 30분 동안 열리는 회의"에 대한 인스턴스를 생성

    ![https://user-images.githubusercontent.com/48986787/89107932-6e95f080-d46f-11ea-8008-6f5e76e5c078.png](https://user-images.githubusercontent.com/48986787/89107932-6e95f080-d46f-11ea-8008-6f5e76e5c078.png)

- 테스트 코드 작성

    ![https://user-images.githubusercontent.com/48986787/89107974-e237fd80-d46f-11ea-893b-d97d13f80fd8.png](https://user-images.githubusercontent.com/48986787/89107974-e237fd80-d46f-11ea-893b-d97d13f80fd8.png)

    ![https://user-images.githubusercontent.com/48986787/89107997-13b0c900-d470-11ea-95ae-a4f0773ae28c.png](https://user-images.githubusercontent.com/48986787/89107997-13b0c900-d470-11ea-95ae-a4f0773ae28c.png)

- isSatisfied 메서드를 한번 더 호출하면 true가 됨
    - isSatisfied 메서드가 Event 객체의 상태를 수정하기 때문
    - 버그를 찾기 힘들었던 이유는 명령과 쿼리의 두 가지 역할을 동시에 수행하고 있었기 때문
    - isSatisfied 메서드는 Event가 RecuringSchedule의 조건에 부합하는지를 판단 후 부합할 경우 true, 부합하지 않을 경우 false를 반환. 개념적으로는 쿼리
    - isSatisfied 메서드는 Event가 RecuringSchedule의 조건에 부합하지 않을 경우 Event의 상태를 조건에 부합하도록 변경, 따라서 실제적으로는 부수효과를 가지는 명령

- 해결책은 명령과 쿼리를 명확하게 분리한다.

```java
public boolean isSatisfied(RecurringSchedule schedule) {
        if (from.getDayOfWeek() != schedule.getDayOfWeek() ||
                !from.toLocalTime().equals(schedule.getFrom()) ||
                !duration.equals(schedule.getDuration())) {
            return false;
        }

        return true;
    }
public void reschedule(RecurringSchedule schedule) {
        from = LocalDateTime.of(from.toLocalDate().plusDays(daysDistance(schedule)),
                schedule.getFrom());
        duration = schedule.getDuration();
    }

    private long daysDistance(RecurringSchedule schedule) {
        return schedule.getDayOfWeek().getValue() - from.getDayOfWeek().getValue();
    }
}
```

- isSatisfied 메서드가 쿼리이고 reschedule 메서드가 명령이라는 것을 한눈에 알 수 있게 변경됨

### 명령-쿼리 분리와 참조 투명성

- **참조 투명성**: 어떤 표현식 e가 있을 때 e의 값으로 e가 나타나는 모든 위치를 교체하더라도 결과가 달라지지 않는 특성
- **불변성**: 어떤 값이 변하지 않는 성질, 부수효과가 발생하지 않는다는 것과 동일
- 수학
    - 어떤 값도 변경하지 않기 때문에 부수효과가 존재하지 않음
    - 부수효과가 없는 불변의 세상에선 모든 로직이 참조 투명성을 만족
- 명령-쿼리 분리를 사용하면 제한적으로 참조 투명성 혜택을 누릴 수 있다.
    - 부수효과를 가지는 명령으로부터 부수효과를 가지지 않는 쿼리를 명백하게 분리하기 때문

## 책임에 초점을 맞춰라

- 메세지를 먼저 선택하고 그 후에 메세지를 처리할 객체를 선택하자
    - 이는 디미터 법칙을 준수하고 묻지 말고 시켜라 스타일을 따르면서도 의도를 드러내는 인터페이스를 설계하게 해줌
    - 긍정적인 영향
        - **디미터 법칙**: 협력이라는 컨텍스트 안에서 객체보다 메세지를 먼저 결정하면 두 객체 사이의 구조적인 결합도를 낮출 수 있다. 수신할 객체를 알지 못한 상태에서 메세지를 먼저 선택하기 때문에 객체 내부 구조에 대해 고민할 필요가 없어진다. 따라서 메세지가 객체를선택하게 함으로써 의도적으로 디미터 법칙을 위반할 위험을 최소화 할 수 있다.
        - **묻지 말고 시켜라**: 메세지를 먼저 선택하면 묻지 말고 시켜라 스타일에 따라 협력을 구조하하게 된다. 클라이언트의 관점에서 메세지를 선택하기 때문에 필요한 정보를 물을 필요 없이 원하는 것을 표현한 메세지를 전송하면 된다.
        - **의도를 드러내는 인터페이스**: 메세지를 먼저 선택한다는 것은 메세지를 전송하는 클라이언트의 관점에서 메세지의 이름을 결정한다는 것이다. 당연히 그 이름에는 클라이언트가 무엇을 원하는지, 그 의도가 분명하게 드러날 수 밖에 없다.
        - **명령-쿼리 분리 원칙**: 메세지를 먼저 선택한다는 것은 협력이라는 문맥 안에서 객체의 인터페이스에 관해 고민한다는 것을 의미한다. 객체가 단순히 어떤 일을 해야 하는지뿐만 아니라 협력 속에서 객체의 상태를 예측하고 이해하기 쉽게 만들기 위한 방법에 관해 고민하게된다. 따라서 예측 가능한 협력을 만들기 위해 명령과 쿼리를 분리하게 될것이다.

## 결론

- 훌륭한 메세지를 얻기 위한 출발점은 책임 주도 설계 원칙을 따르것
- 메세지가 객체를 결정하게 하자