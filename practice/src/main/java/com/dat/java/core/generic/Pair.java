package com.dat.java.core.generic;

public interface Pair<K, V> {
    K getKey();
    V getValue();
    V getValueFromKey(K key);
}
