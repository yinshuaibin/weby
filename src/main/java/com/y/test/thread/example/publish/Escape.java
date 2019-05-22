package com.y.test.thread.example.publish;

import com.y.test.thread.annontions.NotRecommend;
import com.y.test.thread.annontions.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

/**
 * 禁止在对象未完全构造完成前被发布
 */
@NotThreadSafe
@Slf4j
@NotRecommend
public class Escape {

    private int thisCanBeEscape = 0;

    public Escape(){
        new innerClass();
    }

    private class innerClass{

        public innerClass(){
            log.info("{}", Escape.this.thisCanBeEscape);
        }
    }

    public static void main(String[] args) {
        new Escape();
    }
}
