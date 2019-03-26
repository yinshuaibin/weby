package com.y;


import com.github.pagehelper.Page;
import com.y.bean.User;
import com.y.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class RedisTest {

    /**
     * redisTemplate和stringRedisTemplate数据不通
     */
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    
    @Autowired
    private UserService userService;


    @Test
    public void testSet(){
        stringRedisTemplate.opsForValue().set("key", "value1");
        Page<User> allUser = userService.getAllUser(1, 10);
        redisTemplate.opsForValue().set("user",allUser.get(0));
    }

    @Test
    public void testGet(){
        User user = (User)redisTemplate.opsForValue().get("user");
        log.info("user数据为:{}",user);

        String key = stringRedisTemplate.opsForValue().get("key");
        log.info("拿出来字符串数据为:{}",key);
    }

    /**
     * set void set(K key, V value, long timeout, TimeUnit unit);
     */
    @Test
    public void test1(){
        // 设置10秒过期时间
       stringRedisTemplate.opsForValue().set("key1", "value1", 10, TimeUnit.SECONDS);
       log.info("redis中键key1的值为: {}",stringRedisTemplate.opsForValue().get("key1"));
        try {
            Thread.sleep(11000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("11秒后redis中键key1的值为: {}",stringRedisTemplate.opsForValue().get("key1"));
    }

    /**
     * Boolean setIfAbsent(K key, V value);
     * 如果有此键值, 则不替换, 如果没有, 则添加
     */
    @Test
    public void test2(){
        stringRedisTemplate.opsForValue().setIfAbsent("key2","value1");
        System.out.println(stringRedisTemplate.opsForValue().setIfAbsent("key2","value2"));
        System.out.println(stringRedisTemplate.opsForValue().setIfAbsent("key3","value3"));
        System.out.println(stringRedisTemplate.opsForValue().get("key2"));
    }

    /**
     * void multiSet(Map<? extends K, ? extends V> m);
     * 批量添加, 查询
     */
    @Test
    public void test3(){
        Map<String, Object> redisMap = new HashMap<>();
        User u1 = new User();
        u1.setUsername("u1");
        User u2 = new User();
        u2.setUsername("u2");
        redisMap.put("key3", u1);
        redisMap.put("key4", u2);
        redisTemplate.opsForValue().multiSet(redisMap);
        List<String> redisString = new ArrayList<>();
        redisString.add("key3");
        redisString.add("key4");
        List<Object> objects = redisTemplate.opsForValue().multiGet(redisString);
        for (Object u : objects){
            System.out.println((User)u);
        }
    }

    /**
     * Boolean multiSetIfAbsent(Map<? extends K, ? extends V> m);
     * 存入的多个键值对, 如果有一个存在, 则全部不添加, 否则添加
     */
    @Test
    public void test4(){
        Map<String, Object> redisMap = new HashMap<>();
        User u1 = new User();
        u1.setUsername("u1");
        User u2 = new User();
        u2.setUsername("u2");
        redisMap.put("key3", u1);
        redisMap.put("key4", u2);
        System.out.println(redisTemplate.opsForValue().multiSetIfAbsent(redisMap));
        redisMap.put("key5","123");
        System.out.println(redisTemplate.opsForValue().multiSetIfAbsent(redisMap));
        System.out.println(redisTemplate.opsForValue().get("key5"));
    }

    /**
     * getAndSet V getAndSet(K key, V value);
     * 设置新值, 并返回旧值
     *
     * get String get(K key, long start, long end);
     * 截取key所对应的value字符串
     * object类型的话, 截取实际字符串
     *
     * size Long size(K key);
     * 返回key所对应的value值得长度
     *
     * .getOperations().delete(key)
     * 删除某个key
     */
    @Test
    public void test5(){
        Object andSet = redisTemplate.opsForValue().getAndSet("key5", "value5");
        System.out.println(andSet);
        redisTemplate.opsForValue().getOperations().delete("key5");
        System.out.println(redisTemplate.opsForValue().get("key5"));
        System.out.println(redisTemplate.opsForValue().get("key3", 0, 100));
        System.out.println(redisTemplate.opsForValue().size("key3"));
    }

    /**
     * Double increment(K key, double delta)
     * Long increment(K key, long delta);
     * 支持long类型和double类型 (比较麻烦 我建议转为String)
     */
//    @Test
//    public void test6(){
//        redisTemplate.opsForValue().increment("key6",1L);
//        Double value = 1.2;
//        redisTemplate.opsForValue().increment("key7", value);
//        Object value6 = redisTemplate.opsForValue().get("key6");
//        Object value7 = redisTemplate.opsForValue().get("key7");
//        System.out.println((Integer) value6);
//        System.out.println((Double) value7);
//    }

    /**
     * long opsForList().leftPush(key, value);//从左向右存压栈(没有就创建) 返回队列长度
     * long opsForList().leftPushIfPresent(key, value);//从左向右存压栈(没有就不添加, 返回队列长度)
     * Object opsForList().leftPop(key);//从左出栈
     * long opsForList().size(key);//队/栈长  (当key存储的值不是列表时返回错误)
     * List opsForList().range(key, start, end);//范围检索,返回List
     * long opsForList().remove(key, i, value);//移除key中值为value的i个,返回删除的个数；如果没有这个元素则返回0; 对象的话, 值相等也可删除 i> 0：删除等于从头到尾移动的值的元素。i <0：删除等于从尾到头移动的值的元素 i = 0：删除等于value的所有元素。
     * Object opsForList().index(key, index);//检索 索引不存在返回null
     * void opsForList().set(key, index, value);//赋值 如果不存在该索引值,却赋值,出现ERR index out of range错误
     * void opsForList().trim(key, start, end);//裁剪,void,删除除了[start,end]以外的所有元素
     * Object opsForList().rightPopAndLeftPush(String sourceKey, String destinationKey);//将源key的队列的右边的一个值删除，然后塞入目标key的队列的左边，返回这个值
     */
    @Test
    public void test7(){
        User u1= new User();
        u1.setUsername("u1");
        System.out.println(redisTemplate.opsForList().leftPush("listkey2", u1));
//        System.out.println(redisTemplate.opsForList().size("likstKey"));
//        System.out.println(redisTemplate.opsForList().range("likstKey", 0, -1));
//        Long likstKey = redisTemplate.opsForList().leftPushIfPresent("likstKey", u1);
//        System.out.println(likstKey);
//        System.out.println( redisTemplate.opsForList().leftPushIfPresent("listkey2", u1));
////        System.out.println(redisTemplate.opsForList().size("likstKey"));
////        System.out.println(redisTemplate.opsForList().size("listkey2"));
//        System.out.println(redisTemplate.opsForList().size("likstKey"));
//        System.out.println(redisTemplate.opsForList().leftPop("likstKey"));
//        System.out.println(redisTemplate.opsForList().size("likstKey"));
 //       System.out.println(redisTemplate.opsForList().remove("likstKey", 5, u1));

        System.out.println(redisTemplate.opsForList().size("listkey2"));

        System.out.println(redisTemplate.opsForList().size("listkey2"));

        System.out.println(redisTemplate.opsForList().index("listkey2", 50));

        System.out.println(redisTemplate.opsForList().range("listkey2",0 , 1));
    }

}
