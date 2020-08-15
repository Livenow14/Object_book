package org.eternity.properties;

import java.util.Hashtable;

/**
 * 불필요한 인터페이스 상속 문제
 *
 * Properties 클래스에서 상속 관계를 제거,
 * Hashtable을 Properties의 인스턴스 변수로 포함 하면 합성관계로 변경 가능
 */
public class Properties {
    private Hashtable<String, String> properties = new Hashtable <>();

    public String setProperty(String key, String value) {
        return properties.put(key, value);
    }

    public String getProperty(String key) {
        return properties.get(key);
    }
}
