# Chapter11_합성과 유연한 설계

- 상속관계: is-a 관계
    - 클래스 사이의 정적인 관계
    - 코드 작성 시점에 결정한 상속 관계는 변경이 불가능
    - 부모 클래스 안에 구현된 코드 자체를 재사용
- 합성 관계: has-a 관계
    - 객체 사이의 동적인 관계
    - 실행시점에 동적으로 변경가능
    - 포함되는 객체의 퍼블릭 인터페이스를 재사용

## 01 상속을 합성으로 변경하기

- 10장에서 확인한 상속의 문제
    1. 불필요한 인터페이스 상속 문제
    2. 메서드 오버라이딩의 오작용 문제
    3. 부모 클래스와 자식 클래스의 동시 수정 문제
- 합성을 사용하면 상속이 초래하는 세 가지 문제점을 해결 할 수 있음

### 불필요한 인터페이스 상속 문제(java.util.Properties와 java.util.Stack)

- Properties 클래스에서 상속 관계를 제거,
- Hashtable을 Properties의 인스턴스 변수로 포함 하면 합성관계로 변경 가능
- Stack에서 상속관계 제거

### 메서드 오버라이딩의 오작용 문제(InstrumentedHashSet)

- InstrumentedHashSet의 경우 HashSet이 제공하는 퍼블릭 인터페이스를 그대로 제공해야함 .
- 그래서 인터페이스를 사용
- **포워딩**: 기존 클래스의 인터페이스를 그대로 외부에 제공하면서 구현에 대한 결합 없이 일부 작동 방식을 변경하고 싶은 경우 사용
- **포워딩 메서드**: 동일한 메서드를 호출하기 위해 추가된 메서드

### 부모 클래스와 자식 클래스의 동시 수정 문제(PersonalPlaylist)

- 합성으로 변경하더라도 Playlist와 PersonalPlaylist를 함께 수정해야한다.
- 그렇지만 상속보다도 합성을 사용하는게 더 좋다.
- 향후에 Playlist의 내부 구현을 변경하더라도 파급효과를 최대한 PeronalPlaylist 내부로 캡슐화 할 수 있기 때문

### 몽키패치(Monkey Patch)

- 현재 실행 중인 환경에만 영향을 미치도록 지역적으로 코드를 수정하거나 확장하는 것

## 02 상속으로 인한 조합의 폭발적인 증가

- 문제점
    - 하나의 기능을 추가하거나 수정하기 위해 불필요하게 많은 수의 클래스를 추가하거나 수정해야함
    - 단일 상속만 지우너하는 언어에서는 상속으로 인해 오히려 중복 코드의 양이 늘어날 수 있다.

### 기본 정책과 부가 정책 조합하기

![https://user-images.githubusercontent.com/48986787/90313344-bb38fb80-df46-11ea-8816-f1c826198251.png](https://user-images.githubusercontent.com/48986787/90313344-bb38fb80-df46-11ea-8816-f1c826198251.png)

- 기본정책은 가입자와 통화 정보를 기반
- 부가 정책은 통화량과 문관하게 기본 정책에 선택적으로 추가할 수 있는 요금 방식을 의미
    - 기본 정책의 계산 결과에 적용된다
    - 선택적으로 적용할 수 있다
    - 조합 가능하다
    - 부가 정책은 임의의 순서로 적용 가능하다

![https://user-images.githubusercontent.com/48986787/90313347-be33ec00-df46-11ea-9c5d-c38204519f33.png](https://user-images.githubusercontent.com/48986787/90313347-be33ec00-df46-11ea-9c5d-c38204519f33.png)

- 조합 가능한 모든 요금 계산 순서

### 상속을 이용해서 기본정책 구현하기

- 이하 코드를 보며 확인

### 기본 정책에 세금 정책 조합하기

- 자식 클래스와 부모 클래스 사이의 결합도가 높아짐

### 기본 정책에 기본 요금 할인 정책 조합하기

- 클래스가 엄청나게 많아짐

### 중복코드의 덫에 걸리다

- 클래스 폭발 문제, 조합의 폭발 문제에 걸림
- 이를 해결할 수 있는 문제는 상속을 포기하는 것

## 03 합성 관계로 변경하기

- 상속으로 여러 기능을 조합하게 하면 모든 조합 가능한 경우별로 클래스를 추가해야함 → 클래스 폭발 문제
- 상속은 조합의 결과를 개별 클래스 안으로 밀어넣는 방법
- 합성은 조합을 구성하는 요소들을 개별 클래스로 구현한 후 실행 시점에 인스턴스를 조립하는 방법을 사용하는 것

### 기본 정책 합성하기

- 각 정책을 별도의 클래스로 구현해야함.
- 분리된 정책들을 연결할 수 있도록 합성관계를 이용해서 구조를 개선
- 이후 코드 확인.

### 부가 정책 적용하기

- 일반 요금제를 적용한 경우 생선된 인스턴스의 관계

    ![https://user-images.githubusercontent.com/48986787/90313882-e7567b80-df4a-11ea-9887-a7a6575a4b7c.png](https://user-images.githubusercontent.com/48986787/90313882-e7567b80-df4a-11ea-9887-a7a6575a4b7c.png)

    - 컴파일 시점의 Phone클래스와 RatePolicy 인터페이스 사이의 관계가 런타임에 Phone 인스턴스와 RegularPolicy 인스턴스 사이의 관계로 대체됨

    ![https://user-images.githubusercontent.com/48986787/90313887-eb829900-df4a-11ea-8fa9-8e83f4b7e145.png](https://user-images.githubusercontent.com/48986787/90313887-eb829900-df4a-11ea-8fa9-8e83f4b7e145.png)

    - 부가정책이 추가됨

    ![https://user-images.githubusercontent.com/48986787/90313940-2e447100-df4b-11ea-9a66-e280b6eeda72.png](https://user-images.githubusercontent.com/48986787/90313940-2e447100-df4b-11ea-9a66-e280b6eeda72.png)

    - 기본 요금제에 기본 요금 할인 정책을 적용한 후 세금 정책을 부과한 인스턴스 관계

- 일반 요금제에 세금 정책을 조합할 경우 Phone 인스턴스를 생성하는 방법

```java
Phone phone = new Phone(
									new TaxablePolicy(0.05, 
											new RegularPolicy(...));
```

- 일반 요금제에 기본 요금 할인 정책을 조합한 결과에 세금 정책을 조합하고 싶을때

```java
Phone phone = new Phone(
									new TaxablePolicy(0.05, 
										new RateDiscountablePolicy(Money.wons(1000),
									new RegularPolicy(...));
```

### 새로운 정책 추가하기

![https://user-images.githubusercontent.com/48986787/90313941-313f6180-df4b-11ea-9bc3-c84149d3f71a.png](https://user-images.githubusercontent.com/48986787/90313941-313f6180-df4b-11ea-9bc3-c84149d3f71a.png)

- 이와 같이 '하나'만 추가해도 원하는 방식으로 조합 가능

### 객체 합성이 클래스 상속보다 더 좋은 방법이다

- 구현 상속보다 인터페이스 상속을 무조건 적으로 사용해야함.