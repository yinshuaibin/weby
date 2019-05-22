package com.y.test.thread.example.immutable;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.y.test.thread.annontions.ThreadSafe;

@ThreadSafe
/**
 * 可以取值, 但不可修改
 */
public class ImmuTableExample3 {

    private static final ImmutableList list = ImmutableList.of(1,2,3);

    private static final ImmutableSet set = ImmutableSet.copyOf(list);

    private static final ImmutableMap map = ImmutableMap.of(1,2,3,4);

    private static final ImmutableMap map2 = ImmutableMap.<Integer, Integer>builder().put(1,2).build();

    public static void main(String[] args) {
        list.add(1); // 抛出异常UnsupportedOperationException
    }
}