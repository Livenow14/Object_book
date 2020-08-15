package eternity.billing.step06;

import eternity.money.Money;

import java.util.ArrayList;
import java.util.List;

/**
 * 추상화에 의존하자.
 *
 * 중복 코드를 부모 클래스로 올려라라
*/
public abstract class AbstractPhone {
    private List<Call> calls = new ArrayList<>();

    public Money calculateFee() {
        Money result = Money.ZERO;

        for(Call call : calls) {
            result = result.plus(calculateCallFee(call));
        }

        return result;
    }

    abstract protected Money calculateCallFee(Call call);
}
