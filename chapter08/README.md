# Chapter08_의존성 관리하기

- 협력을 위해 의존성이 필요하지만 과도한 의존성은 애플리케이션을 수정하기 어렵게 만듬

## 01 의존성 이해하기

### 변경과 의존성

- 어떤 객체가 협력하기 위해 다른 객체를 필요로 할 때 두 객체 사이에 의존성이 존재하게 됨
- 실행 시점과 구현 시점에 서로 다른 의미를 가짐
    - **실행 시점**: 의존하는 객체가 정상적으로 동작하기 위해서는 실행 시에 의존 대상 객체가 반드시 존재해야함
    - **구현 시점**: 의존 대상 객체가 변경될 경우 의존하는 객체도 함께 변경됨.

- 예제를 살펴본다

```java
public class PeriodCondition implements DiscountCondition {
    private DayOfWeek dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;

    public PeriodCondition(DayOfWeek dayOfWeek, LocalTime startTime, LocalTime endTime) {
        this.dayOfWeek = dayOfWeek;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public boolean isSatisfiedBy(Screening screening) {
        return screening.getStartTime().getDayOfWeek().equals(dayOfWeek) &&
                startTime.compareTo(screening.getStartTime().toLocalTime()) <= 0&&
                endTime.compareTo(screening.getStartTime().toLocalTime()) >= 0;
    }
}
```

- 실행 시점에 PeriodCondition의 인스턴스가 정상적으로 동작하기 위해서 Screening인스턴스가 존재해야함

- 의존성은 방향성을 가지며 항상 단방향

    ![https://user-images.githubusercontent.com/48986787/89108974-20d1b600-d478-11ea-9181-d93ea0cda6c1.png](https://user-images.githubusercontent.com/48986787/89108974-20d1b600-d478-11ea-9181-d93ea0cda6c1.png)

- 두 요소 사이의 의존성은 의존되는 요소가 변경 될 때 의존하는 요소도 함께 변경될 수 있다는 것을 의미

- PeriodCondition이 의존하고 있는 모든 대상

    ![https://user-images.githubusercontent.com/48986787/89109005-5e364380-d478-11ea-9e0f-be1d20ceb1ee.png](https://user-images.githubusercontent.com/48986787/89109005-5e364380-d478-11ea-9e0f-be1d20ceb1ee.png)

    - 의존성의 종류를 강조

        ![https://user-images.githubusercontent.com/48986787/89109027-84f47a00-d478-11ea-8c2b-b6f116e0a31c.png](https://user-images.githubusercontent.com/48986787/89109027-84f47a00-d478-11ea-8c2b-b6f116e0a31c.png)

### UML과 의존성

- 이번장에서 다루는 의존성은 UML에서 이야기하는 의존성과는 별개다.

### 의존성 전이

![https://user-images.githubusercontent.com/48986787/89109056-bf5e1700-d478-11ea-8b9a-cb6926725c4c.png](https://user-images.githubusercontent.com/48986787/89109056-bf5e1700-d478-11ea-8b9a-cb6926725c4c.png)

- 의존하는 대상이 다른 대상을 의존할 경우 자동적으로 의존하게 됨
- 의존성의 종류
    - **직접 의존성(direct dependency)**: 한 요소가 다른 요소에 직접 의존하는 경우
    - **간접 의존성(indirect depnedency)**: 직접 적인 관계는 존재하지 않지만 의존성 전이에 의해 영향이 전파되는 경우
- 의존성의 대상은 객체, 모듈, 시스템등일 수 있다.

### 런타임 의존성과 컴파일타임 의존성

- **런타임**: 애플리케이션이 실행되는 시점
    - 객체가 주인공, 객체 사이의 의존성을 다룸
- **컴파일타임**: 작성된 코드를 컴파일 하는 시점, 혹은 코드 그 자체
    - 클래스가 주인공, 클래스 사이의 의존성을 다룸

- 유연하고 재사용 가능한 코드를 설계하기 위해선 두 종류의 의존성을 서로 다르게 만들어야 함

- 영화 예매 시스템의 예
    - 코드 작성 시점

    ![https://user-images.githubusercontent.com/48986787/89109169-c174a580-d479-11ea-8183-0b5baa4a1ae8.png](https://user-images.githubusercontent.com/48986787/89109169-c174a580-d479-11ea-8183-0b5baa4a1ae8.png)

    - Movie 클래스는 추상클래스인 DiscountPolicy 클래스에만 의존
        - 코드 확인

- 런타임 시점

    ![https://user-images.githubusercontent.com/48986787/89109210-2e883b00-d47a-11ea-82df-20456d2a9be3.png](https://user-images.githubusercontent.com/48986787/89109210-2e883b00-d47a-11ea-82df-20456d2a9be3.png)

- 코드 작성 시점에선 두 클래스의 존재를 모르지만 실행 시점에는 두 클래스의 인스턴스와 협력할 수 있게 된다.
    - 협력할 인스턴스의 구체적인 클래스를 알아서는 안됨
    - 실제로 협력할 객체가 어떤 것인지는 런타임에서 해결해야함

### 컨텍스트 독립성

- 클래스가 사용될 특정한 문맥에 대해 최소한의 가정만으로 이뤄져 있다면 다른 문맥에서 재사용하기가 더 수월해지는 것을 의미

### 의존성 해결하기

- 컴파일 타임 의존성은 구체적인 런타임 의존성으로 대체돼야 함
- **의존성 해결**: 컴파일타임 의존성을 실행 컨텍스트에 맞는 적절한 런타임 의존성으로 교체
    - 방법
        - 객체를 생성하는 시점에 생성자를 통해 의존성 해결
        - 객체 생성 후 setter 메서드를 통해 의존성 해결
        - 메서드 실행 시 인자를 이용해 의존성 해결

- 생성하는 시점에 의존성 해결

    ```java
    Movie avatar = new Movie("아바타", 
    		Duration.ofMinutes(100),
    		Money.wons(11000),
    		new PercentDiscountPolicy(...);
    ```

- 인스턴스를 생성한 후 메서드를 이용해 의존성 해결

    ```java
    Movie avatar = new Movie(...);
    avatar.setDiscountPolicy(new AmountDiscountPolicy(...));
    ```

    - 이 과정에선 setter메서드를 제공해야함
    - 의존 대상을 설정하기 전까지 불완전함
    - 생성자 방식과 setter방식을 혼합을 많이 사용함

- 메서드 인자를 이용해 의존성을 해결

    ```java
    public class Movie {
    '''
    public Money calculateMovieFee(Screening screening,  DiscountPolicy discountPolicy) {
            return fee.minus(discountPolicy.calculateDiscountAmount(screening));
        }
    }
    ```

    - 메서드가 실행되는 동안만 의존 관계가 존재해도 무방하거나 의존 대상이 매번 달라져야 할때 유용

## 02 유연한 설계

### 의존성과 결합도

- 바람직한 의존성: 어떤 의존성이 다양한 환경에서 재사용 될 수 있고, 컨텍스트에 독립적일때

- **의존성**: 두 요소 사이의 관계 유무를 설명
- **결합도**: 두 요소 사이에 존재하는 의존성의 정도를 상대적으로 표현

### 지식이 결합을 낳는다.

- 자신이 의존하고 있는 다른 요소에 대해 알고있는 정보의 양으로 결합도의 정도를 결정
- 결합도를 느슨하게 만들기 위해서는 필요한 정보외에 최대한 감추는 것이 중요

### 추상화에 의존하라

- 문제를 해결해는데 불필요한 정보를 감추는 것
- 추상화와 결합도의 관점에서 밑과 같이 의존 대상을 구분해야함(밑으로 갈수록 결합도가 느슨해짐)
    - 구체 클래스 의존성(concreate class dependency)
    - 추상 클래스 의존성 (abstract class dependency)
    - 인터페이스  의존성(interface dependency)
        - 상속 계층을 모르더라도 협력이 가능해짐

### 명시적인 의존성

- 앞의 **의존성 해결**의 방법을 이용
    - 인스턴스 변수의 타입은 추상 클래스나 인터페이스로 정의
    - 생성자, setter 메서드, 메서드 인자로 의존성을 해결할때는 추상 클래스를 상속받거나 인터페이스를 실체화한 구체 클래스를 전달

    ```java
    public class Movie {
        private String title;
        private Duration runningTime;
        private Money fee;
        private DiscountPolicy discountPolicy;

    		public Movie(String title, Duration runningTime, Money fee, DiscountPolicy discountPolicy) {
    		        this.title = title;
    		        this.runningTime = runningTime;
    		        this.fee = fee;
    		        this.discountPolicy = discountPolicy;
    		    }
    ```

    - 생성자의 인자로 선언
        - Movie가 DiscountPolicy 에 의존한다는 사실을 Moive의 퍼블릭 인터페이스에 드러냄
            - 이를 **명시적인 의존성**이라 부름

- 의존성을 구현 내부에 숨겨두면 안되고, 명시적으로 표현해야 한다.

### new는 해롭다

- new는 클래스 사이의 결합도를 높이게 할 수있다.
    - new를 사용하기 위해선 구체 클래스의 이름을 직접 기술해야 하기 때문
    - 어떤 인자를 이용해야 하는지 알아야하기에 지식이 늘어남
- 해결방법
    - 인스턴스를 생성하는 로직과 생성된 인스턴스를 사용하는 로직을 분리하는 것
        - 사용과 생성의 책임을 분리하는 것
        - 이는 위의 코드와 동일
    - 생성의 책임을 클라이언트로 두었다.

### 가끔은 생성해도 무방하다

- 주로 협력하는 기본 객체를 설정하고 싶은 경우에 생성해도 무방.
    - 이는 오버로딩을 통해 해결할 수 있다.

    ```java
    public class Movie {
        private String title;
        private Duration runningTime;
        private Money fee;
        private DiscountPolicy discountPolicy;

    		public Movie(String title, Duration runningTime){
    						this(title, runningTime, fee, new AmountDiscountPolicy(...));
    		}

    		public Movie(String title, Duration runningTime, Money fee, DiscountPolicy discountPolicy) {
    		        this.title = title;
    		        this.runningTime = runningTime;
    		        this.fee = fee;
    		        this.discountPolicy = discountPolicy;
    		 }
    ```

    - 대부분의 경우에 AmountDiscountPolicy로 협력하고 다른 의존성이 필요할때는 다른 생성자를 사용할 수 있다.
        - 이처럼 인스턴스를 인자로 받는 메서드와 기본값을 생성하는 메서드를 함께 사용하면 클래스의 사용성을 향상시키면서 컨텍스트에 유연하게 대체 가능하다.

### 표준 클래스에 대한 의존은 해롭지 않다

- 변경될 확률이 거의 없는 클래스라면 의존성이 문제가 되지 않는다.
    - ex) jdk에 포함된 표준 클래스
    - 구체 클래스에 의존하거나 직접 인스턴스를 생성하더라도 문제가 없다

### 컨텍스트 확장하기

- 중복할인 정책 구현

    ```java
    public class OverlappedDiscountPolicy extends DiscountPolicy {
        private List<DiscountPolicy> discountPolicies = new ArrayList<>();

        public OverlappedDiscountPolicy(DiscountPolicy ... discountPolicies) {
            this. discountPolicies = Arrays.asList(discountPolicies);
        }

        @Override
        protected Money getDiscountAmount(Screening screening) {
            Money result = Money.ZERO;
            for(DiscountPolicy each : discountPolicies) {
                result = result.plus(each.calculateDiscountAmount(screening));
            }
            return result;
        }
    }
    ```

    - OverlappedDiscountPolicy의 인스턴스를 생성해서 Movie에 전달하는 것만으로 중복 할인 적용

    ```java
    Movie avatar = new Movie("아바타", 
    		Duration.ofMinutes(100),
    		Money.wons(11000),
    		new OverlappedDiscountPolicy(
    				new AmountDiscountPolicy(...),
    				new PercentDiscountPolicy(...)));
    ```

### 조합 가능한 행동

- 객체가 어떻게 하는지를 장황하게 나열하지 않고도 객체들의 조합을 통해 무엇을 하는지를 표현하는 클래스 들로 구성
    - 인스턴스를 생성하는 코드를 보는 것만으로 객체가 어떤 일을 하는지 쉽게 파악 가능
- 유연하고 재사용 가능한 설계는 작은 객체들의 행동을 조합하며 새로운 행동을 이끌어 내는 것이다.