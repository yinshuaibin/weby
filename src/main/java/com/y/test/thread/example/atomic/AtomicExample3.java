package com.y.test.thread.example.atomic;


import com.y.test.thread.annontions.ThreadSafe;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

@Slf4j
@ThreadSafe
public class AtomicExample3 {

    private static AtomicIntegerFieldUpdater<AtomicExample3> updater =
            AtomicIntegerFieldUpdater.newUpdater(AtomicExample3.class, "count");

    @Getter
    private volatile int count = 100;

    private static AtomicExample3 atomicExample3 = new AtomicExample3();

    public static void main(String[] args) {
        if(updater.compareAndSet(atomicExample3, 100, 120)){
            log.info("update success {}", atomicExample3.getCount());
        }
    }
}
