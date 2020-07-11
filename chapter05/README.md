# Chapter05_책임 할당하기

- 책임 할당 과정은 일종의 트레이드오프 활동.
- 어떤 방법이 최선인지는 상황과 문맥에 따라 달라진다.
- GRASP 패턴에 대해 알아봄

## 01. 책임 주도 설계를 향해

- 데이터 중심의 설계에서 객체 중심의 설계로 전환하기 위해 필요한 두 가지 원칙
    - 데이터보다 행동을 먼저 결정하라
    - 협력이라는 문맥 안에서 책임을 결정하라

### 데이터보다 행동을 먼저 결정하라

- 객체에게 중요한 것은 데이터가 아니라 외부에 제공하는 행동
- 객체는 협력에 참여하기 위해 존재하며 협력 안에서 수행하는 책임이 객체의 존재가치를 증명
- 책임 중심 설계에선

    "이 객체가 수행해야하는 책임은 무엇인가?" 이후 

    "이 책임을 수행하는데 필요한 데이터는 무엇인가?"를 결정

    객체의 행동, 즉 책임을 먼저 결정한 후에 객체의 상태를 결정

- 그렇다면 객체에게 어떤 책임을 할당해야 하는가?

### 협력이라는 문맥 안에서 책임을 결정하라

- 객체에게 할당된 책임이 협력에 어울리지 않는다면 그 책임은 나쁜 것
- 책임은 객체의 입장이 아니라 객체가 참여하는 협력에 적합해야 한다.
- 메세지를 전송하는 클라이언트의 의도에 적합한 책임을 할당해야 하는 것이다.
- 결국 객체가 메세지를 선택하는 것이 아닌 메세지가 객체를 선택하게 해야 한다. (메세지 기반 설계)
    - "이 클래스는 무엇을 해야하지?" 라고 질문하지 않고 "메세지를 전송해야 하는데 누구에게 전송해야 하지?" 라고 질문하는것
- 메세지는 클라이언트의 의도를 표현, 객체를 결정하기 전 객체가 수신할 메세지를 먼저 결정함
- 메세지를 수신하기로 결정된 객체는 메세지를 처리할 '책임'을 할당 받음

### 책임 주도 설계

- 3장에서 설명한 책임 주도 설계의 흐름
    - 시스템이 사용자에게 제공해야하는 기능인 시스템 책임을 파악한다.
    - 시스템 책임을 더 작은 책임으로 분할한다.
    - 분할된 책임을 수행할 수 있는 적절한 객체 또는 역할을 찾아 책임을 할당한다
    - 객체가 책임을 수행하는 도중 다른 객체의 도움이 필요한 경우 이를 책임질 적절할 객체 또는 역할을 찾는다
    - 해당 객체 또는 역할에게 책임을 할당함으로써 두 객체가 협력하게 한다.

## 02. 책임 할당을 위한 GRASP 패턴

- General Responsibility Assignment Software Pattern(일반적인 책임 할당을 위한 소프트웨어 패턴)
    - 객체에게 책임을 할당할 때 지침으로 삼을 수 있는 원칙들의 집합을 패턴 형식으로 정리

### 도메인 개념에서 출발하기

- 설계를 시작하기 앞서 도메인에 대한 개략적인 모습을 그려야 한다.
- 즉 책임을 할당할 때 가장 먼저 고민해야함

![https://s3-us-west-2.amazonaws.com/secure.notion-static.com/f0801cd8-6627-4aad-ba65-45dd240cd1d6/Untitled.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/f0801cd8-6627-4aad-ba65-45dd240cd1d6/Untitled.png)

- 도메인 개념과 개념사이의 관계를 대략적으로 표현함
- 설계를 시작하기 위해 참고할 수 있는 개념들의 모음 정도로 생각.
- 도메인 개념을 완벽히 할 필요가 없으므로 여기에 너무 많은 시간을 들이지말고 빠르게 설계와 구현을 진행

### 올바른 도메인 모델이란 존재하지 않는다.

- 필요한 것은 도메인을 그대로 투영한 모델이 아니라 구현에 도움이 되는 모델이다.
- 즉 실용적이면서도 유용한 모델이 답이다.

### 정보 전문가에게 책임을 할당하라

- 책임 주도 설계 방식의 첫 단계는 애플리케이션이 제공해야 하는 기능을 애플리케이션의 책임으로 생각하는 것
- 이 책임을 애플리케이션에 대해 전송된 메세지로 간주하고 이 메세지를 책임질 첫 번째 겍체를 선택하는 것으로 설계를 시작

- ex) 영화 예메 시스템에서
    - 사용자에게 제공해야 하는 기능은 영화를 예매 하는것
    - 책임으로 간주하면 애플리케이션은 영화를 예매할 책임이 있다.
    - 이 책임을 수행하는 데 필요한 메세지를 결정해야 한다.

- 첫 번째 질문

    > 메세지를 전송할 객체는 무엇을 원하는가?

    - 협력을 시작할 객체는 미정이지만 이 객체가 원하는 것은 분명해 보인다.

        ![https://s3-us-west-2.amazonaws.com/secure.notion-static.com/ac1b16e8-da17-4938-86b2-7a0a2fa5ecfa/Untitled.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/ac1b16e8-da17-4938-86b2-7a0a2fa5ecfa/Untitled.png)

- 두 번째 질문

    > 메시지를 수신할 적합한 객체는 누구인가?

    - 이질문에 답하기 위해서는 객체가 상태와 행동을  통합한 캡슐화의 단위라는 사실에 집중해야 한다.
    - 객체에게 책임을 할당하는 첫 번째 원칙은 책임을 수행할 정보를 알고 있는 객체에게 책임을 할당하는것 → 정보 전문가 패턴(INFORMATION EXPERT)

### INFORMATION EXPERT 패턴

- 객체가 자신이 소유하고 있는 정보와 관련된 작업을 수행한다는 것을 표현한것
- 정보와 데이터는 다르기에 책임을 수행하는 객체가 정보를 '알고'있다 해서 그 정보를 '저장'하고 있을 필요는 없다.

- 상영은 영화에 대한 정보와 상영 시간, 상영 순번처런 영화 예매에 필요한 다양한 정보를 알고있다.
    - 그렇기에 예매하라의 책임에서 정보 전문가인 상영에 책임을 할당

        ![https://s3-us-west-2.amazonaws.com/secure.notion-static.com/a0366b04-4976-4bf1-8ff0-50b66bcc8c10/Untitled.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/a0366b04-4976-4bf1-8ff0-50b66bcc8c10/Untitled.png)

        - 이때 상영이 책임을 수행하는 데 필요한 작업을 구상해보고 스스로 처리할 수 없는 작업이 무엇인지를 가릴 정도의 수준으로만 생각
        - 만약 스스로 처리할 수 없는 작업이 있다면 → 외부에 도움을 여청
            - 이것이 외부로 전송해야 하는 새로운 메세지가 되고 최종적으로 새로운 객체의 책임으로 할당된다.

    - 상영은 가격을 계산하는 데 필요한 정보를 모르기 때문에 외부 객체에게 도움을 요청

        ![https://s3-us-west-2.amazonaws.com/secure.notion-static.com/10fd424e-be0c-49ee-bde5-e0692e3aa353/Untitled.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/10fd424e-be0c-49ee-bde5-e0692e3aa353/Untitled.png)

        - Information expert패턴에 따라 메세지를 수신할 적당한 객체는 Movie
        - Moive는 영화 가격을 계산할 책임을 지게된다.

            ![https://s3-us-west-2.amazonaws.com/secure.notion-static.com/32f97d03-da47-4026-9b13-50b8e3f91656/Untitled.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/32f97d03-da47-4026-9b13-50b8e3f91656/Untitled.png)

        - Movie는 할인 가능 판단을 못함. "할인여부를 판단하라" 메세지를 전달해서 외부의 도움을 요청

            ![https://s3-us-west-2.amazonaws.com/secure.notion-static.com/cd83b8d1-1cea-4493-949a-b921c01595d8/Untitled.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/cd83b8d1-1cea-4493-949a-b921c01595d8/Untitled.png)

        - 이 정보에 대한 전문가는 할인 조건(DiscountCondition)이다.

            ![https://s3-us-west-2.amazonaws.com/secure.notion-static.com/0532d1bc-8fd0-47ea-9997-ccc7d9b5884a/Untitled.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/0532d1bc-8fd0-47ea-9997-ccc7d9b5884a/Untitled.png)

            - Movie는 DiscountCondition에 전송한 "할인 여부를 판단하라" 메세지의 결과로 할인 가능 여부를 반환 받는다.
- 이와 같이 정보전문가(INFORMATION EXPERT) 패턴은 객체에게 책임을 할당할 때 가장 기본이 되는 책임 할당 원칙이다.

### 높은 응집도와 낮은 결합도

- INFORMATION EXPERT 패턴 이외의 다른 책임 할당 패턴을 고려해야한다.

    ![https://s3-us-west-2.amazonaws.com/secure.notion-static.com/cd9d85a2-aef3-42bf-91e7-18750425f924/Untitled.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/cd9d85a2-aef3-42bf-91e7-18750425f924/Untitled.png)

    - 이는 결합도 측면에서 이전 책임 할당에서 보다 좋지 않다.

- 높은 결합도와 낮은 결합도는 객체에 책임을 할당할 때 항상 고려해야 하는 기본 원리
- 책임을 할당할 수 있는 다양한 대안들이 존재하면 이 두가지를 고려하여 더 나은 대안을 선택하는 것이 좋다.
    - 이를 **낮은 결합도(LOW COUPLING)** 패턴과 **높은 응집도(HIGH COHESION) 패턴**이라 부름

    - LOW COUPLING 패턴에서
        - DiscountCondition이 Movie와 협력 하는게 좋을지 Screening과 협력하는지 좋을지 결정하는것은 결합도에 있다.
        - 도메인 상에서 봤을때 Movie는 DiscountCondition의 목록을 속성으로 포함하고있다.
        - 그렇기 때문에 Movie와 DiscountCondition이 협력하게 되면 설계 전체적으로 결합도를 추가하지 않고도 협력을 완성할 수 있다.

    - HIGH COHESION 패턴에서
        - Screening과 DiscountCondition이 협력하게 되면 Screening은 서로 다른 이유로 변경되는 책임을 짊어지게 되므로 응집도가 낮아진다.
        - Moive의 주된 책임은 영화 요금을 계산하는것이기 때문에 영화 요금을 계산하는 데 필요한 할인 조건을 판단하기 위해 Movie가 DiscountCondition과 협력하는 것은 응짐도에 아무런 해를 끼치지 않는다.

    - 매 순간 LOW COUPLING과 HIGH COHESION 패턴을 관점에서 설계 품질을 검토 해야한다.

    ### 창조자에게 객체 생성 책임을 할당하라

    - 영화 애매 협력의 최종 결과물은 Reservation 인스턴스를 생성하는 것
        - 협력에 참여하는 어떤 객체는 Reservation 인스턴스를 생성할 책임을 할당해야 하는 것을 의미
    - **창조자(CREATOR) 패턴**은 이 같은 경우에 사용할 수 있는 책임 할당 패턴
        - 객체를 생성할 책임을 어떤 객체에게 할당할지에 대한 지침을 제공
        - 아래 조건에 최대한 만족하는 객체에게 객체 생성 책임을 할당
            - B가 A 객체를 포함하거나 참조한다
            - B가 A 객체를 기록한다
            - B가  A객체를 긴밀하게 사용한다
            - B가 A객체를 초기화하는 데 필요한 데이터를 가지고 있다(이 경우 B는 A에 대한 정보 전문가)

    - Reservation을 잘 알고있거나 초기화에 필요한 데이터를 가지고 있는 객체는 Screening
    - Screening은 예매 요금을 계산하는데 필수적인 Movie또한 알고있다.

        ![https://s3-us-west-2.amazonaws.com/secure.notion-static.com/28a30d08-e7b4-43cd-afec-6d78609e44b8/Untitled.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/28a30d08-e7b4-43cd-afec-6d78609e44b8/Untitled.png)

- 지금까지는 대략적인 스케치에 불과함, 협력과 책임이 제대로 동작하는지 확인할 수 있는 유일한 방법은 코드를 작성하고 실행하는 것 뿐

## 03. 구현을 통한 검증

- IMFORMATION EXPERT 패턴의 과정을 순차적으로 구현

- Screening은 "예매하라"메세지에 응답할 수 있어야 한다.

```
public class Screening {
    public Reservation reserve(Customer customer, int audienceCount){
    }
}
```

- 책임이 결정됐으므로 책임을 수행하는 데 필요한 인스턴스 변수를 결정

```
public class Screening {

    private Movie movie;    //"가격을 계산하라"라는 메세지를 보내기 위해 
    private int sequence;       //상영순번
    private LocalDateTime whenScreened;     //상영 시간

    public Reservation reserve(Customer customer, int audienceCount){
    }
}
```

- 영화를 예매하기 위해서는 moive에게 "가격을 계산하라"라는 메세지를 전송해서 계산된 영화요금을 반환해야 한다.

```
public class Screening {

    private Movie movie;    //"가격을 계산하라"라는 메세지를 보내기 위해
    private int sequence;       //상영순번
    private LocalDateTime whenScreened;     //상영 시간

    public Reservation reserve(Customer customer, int audienceCount){
        return new Reservation(customer, this, calculateFee(audienceCount), audienceCount);
    }

    private Money calculateFee(int audienceCount){
        return movie.calculateMovieFee(this).times(audienceCount);
    }
}
```

- 여기서 중요한 점은 Screening이 Movie의 내부 구현에 대한 어떤 지식도 없이 전송할 메세지를 결정했다는 것

- Screening은 Movie와 협력하기 위해 calculateMovieFee 메세지를 전송한다. Movie는 이 메세지에 응답하기 위해 calcualteMovieFee 메서드를 구현해야 한다.

```
public class Movie {

    public Money calculateMovieFee(Screening screening){

    }
}
```

- Movie가 알아야할 정보를 저장함

```
public class Movie {

    private String title;
    private Duration runningTime;
    private Money fee;
    private List<DiscountCondition> discountConditions;

    private MovieType movieType;
    private Money discountAmount;
    private double discountPercent;

    public Money calculateMovieFee(Screening screening){

    }
}
```

- 이후는 코드의  step 1에서 확인

### DiscountCondition 개선하기

- step1의 가장 큰 문제점은 변경에 취약한 클래스를 포함하고 있다는 것.
- 변경에 취약한 클래스란 코드를 수정해야 하는 이유를 하나 이상 가지는 클래스
- 이유
    - 새로운 할인 조건 추가
        - 새로운 할인조건이 새로운 데이터를 요구하면 DiscountCondition에 속성을 추가하는 작업이 필요함
    - 순번 조건을 판단하는 로직 변경
        - isSatisfiedBySequence 메서드의 내부 구현을 수정해야함. 순번 조건을 판단하는 데 필요한 데이터가 변경된다면 DiscountCondition의 sequence 속성 역시 변경되야한다.
    - 기간 조건을 판단하는 로직이 변경되는 경우
- 하나 이상의 변경 이유를 가지기 때문에 응집도가 낮다.
    - 이 문제를 해결하기 위해서는 **변경의 이유에 따라 클래스를 분리** 해야함.

- 코드를 통해 변경의 이유를 파악할 수 있는 방법
    - 인스턴스 변수과 초기화 되는 시점을 살펴봄
        - 응집도가 높은 클래스는 인스턴스를 생성할 때 모든 속성을 함께 초기화 하지만 응집도가 낮은 클래스는 객체의 속성 중 일부만 초기화하고 일부는 초기화되지 않은 상태로 남겨짐
        - 함께 초기화되는 속성을 기준으로 코드를 분리해야함

    - 메서드들이 인스턴스 변수를 사용하는 방식을 살펴봄
        - 모든 메서드가 객체의 모든 속성을 사용한다면 클래스의 응집도는 높다고 볼 수 있다
        - 메서드들이 사용하는 속성에 따라 그룹이 나뉜다면 클래스의 응집도가 낮다고 볼 수 있다.
        - 속성 그룹과 해당 그룹에 접근하는 메서드 그룹을 기준으로 코드를 분리해야 한다.

### 타임 분리하기

- DiscountCondition의 가장 큰 문제는 순번 조건과 기간 조건이라는 두 개의 독립적인 타입이 하나의 클래스 안에 공존한다는 것. 이를 분리한다.

- step2 코드 확인
    - Movie 클래스 안에서 SequenceCondition의 목록과 ReriodCondition의 목록을 따로 유지
        - 이는 설계의 관점에서 전체적인 결합도가 높아짐

        ![https://s3-us-west-2.amazonaws.com/secure.notion-static.com/e63e5879-9a30-47f2-b3f6-3c139ea10cf3/Untitled.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/e63e5879-9a30-47f2-b3f6-3c139ea10cf3/Untitled.png)

### 다형성을 통해 분리하기

- Movie의 입장에서 보면 WequenceCondition과 PeriodCondition은 아무 차이도 없다.
- 여기서 **역할** 이라는 개념이 나옴.

    ![https://s3-us-west-2.amazonaws.com/secure.notion-static.com/4cef6d8f-6ccb-4a96-83d3-9941017436ce/Untitled.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/4cef6d8f-6ccb-4a96-83d3-9941017436ce/Untitled.png)

    - Movie 입장에서 SequenceCondition과 PeriodCondition이 동일한 책임을 수행한다는 것은 동일한 역할을 수생한다는 것을 의미
    - Movie는 구체적인 클래스를 알지 못한 채 오직 역할에 대해서만 결합되도록 의존성을 제한 할 수 있다.
    - step 3의 코드 확인

- DiscountCondition의 경우에서 알 수 있듯이 객체의 암시적인 타입에 따라 행동을 분기해야 한다면 암시적인 타입을 명시적인 클래스로 정의하고 행동을 나눔으로써 응집도 문제를 해결

    ![https://s3-us-west-2.amazonaws.com/secure.notion-static.com/169be618-037a-441f-8ab5-4fcf29e9d5fe/Untitled.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/169be618-037a-441f-8ab5-4fcf29e9d5fe/Untitled.png)

    - 이를 **POLYMORPHISM(다형성)** 패턴이라고 한다

### 변경으로부터 보호하기

- 위의 그림을 보면 두 서브 클래스는 서로 다른 이유로 변경된다는 것을 알 수 있다.
    - 두개의 서로 다른 변경이 두 개의 서로 다른 클래스 안으로 캡슐화 된다.
    - DiscountCondition이라는 추상화가 구체적인 타입(PeriodCondition과 SequenceCondition의 존재)을 캡슐화 한다.
- 새로운 할인 조건을 추가 하더라도 Movie에 영향을 받지 않는다.
    - 이를 **PROTECTED VARIATON(변경 보호)**패턴이라 부른다.
        - 책임 할당 관점에서 캡슐화를 설명한 것
        - 변경이 될 가능성이 높으면 캡슐화 하는것

- 클래스를 변경에 따라 분리하고 인터페이스를 이용해 변경을 캡슐화하는 것은 설계의 결합도와 응집도를 향상시키는 매우 강력한 방법

### Movie 클래스 개선하기

- Movie역시 DiscountCondition과 동하게 금액 할인 정책 영화와 비율 할인 정책 영화라는 두 가지 타입을 하나의 클래스 안에 구현하고 있어 응집도가 낮다.
- DiscountCondition의 경우에는 역할을 수행할 클래스들 사이에 구현을 공유할 필요가 없었기 때문에 인터페이스로 구현했지만 Movie의 경우에 구현을 공유해야 하기 때문에 추상 클래스를 이용해 역할을 구현함
    - step4의 코드 확인
        - 할인 정책의 종류에 따라 할인 금액을 계산해야 하는 로직이 달라져야함.
            - 이를 통해 서브클래스들이 할인 금액을 계산하는 방식을 원하는대로 오버라이딩 할 수 있게 됨

- 개선 결과
    - 모든 클래스의 내부 구현은 캡슐화 되어있고 모든 클래스는 변경의 이유를 하나씩만 가지게 되었다.
    - 각 클래스는 응집도가 높고 다른 클래스와 결합도가 낮다.
    - 클래스는 오직 하나의 일만 수행

        ![https://s3-us-west-2.amazonaws.com/secure.notion-static.com/7a403600-26c0-4fea-a2e6-67fa5acff9cd/Untitled.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/7a403600-26c0-4fea-a2e6-67fa5acff9cd/Untitled.png)

        - 이는 앞서 얘기했던 도메인 모델 구조와 유사하다.

### 변경과 유연성

- 설계를 주도하는 것은 변경이다.
    - 개발자로서 변경에 대비할 수 있는 두가지 방법
        - 코드를 이해하고 수정하기 쉽도록 최대한 단순하게 설계
            - 대부분의 경우는 이방법이 더좋음
        - 코드를 수정하지 않고도 변경을 수용할 수 있게 코드를 더 유연하게 만듬
            - 유사한 변경이 반복적으로 발생한다면 이방법이 더 좋음

- 상속대신 **합성**을 이용하면 더욱 유연하게 설계할 수 있다.

    ![https://s3-us-west-2.amazonaws.com/secure.notion-static.com/90faecd6-08fa-4a20-b999-89053bbac4c8/Untitled.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/90faecd6-08fa-4a20-b999-89053bbac4c8/Untitled.png)

    - 책임을 할당하고 유연성을 기반으로 설계를 리펙터링해 나가면서  2장에서 살펴본 영화예메 시스템의 전체 구조와 같아짐

## 04. 책임 주도 설계의 대안

- 책임 주도 설계에 익숙해지기 위해 우선 최대한 빠르게 목적한 기능을 수행하는 코드를 작성하고, 책임을 이동시켜보자.
    - 주의할 점은 코드를 수정한 후에 겉으로 들어나는 동작이 바뀌어선 안됨
    - 이해하기 쉽고 수정하기 쉬운 소프트웨어로 개선하기 위해 겉으로 보이는 동작은 바꾸지 않은 채 내부 구조를 변경하는 것을 **리팩터링(Refactoring)**이라 부른다.