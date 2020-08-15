package eternity.instrumented;

import java.util.Collection;
import java.util.HashSet;

/**
 * 메서드 오버라이딩의 오작용 문제
 */
public class InstrumentedHashSet<E> extends HashSet<E> {
    private int addCount = 0;

    public InstrumentedHashSet() {
    }

    public InstrumentedHashSet(int initCap, float loadFactor) {
        super(initCap, loadFactor);
    }

    @Override
    public boolean add(E e) {
        addCount++;
        return super.add(e);
    }

//    @Override
//    public boolean addAll(Collection<? extends E> c) {
//        addCount += c.size();
//        return super.addAll(c);
//    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        boolean modified = false;
        for (E e : c)
            if (add(e))
                modified = true;
        return modified;
    }

    public int getAddCount() {
        return addCount;
    }
}
