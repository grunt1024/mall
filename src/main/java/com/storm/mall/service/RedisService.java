package com.storm.mall.service;

/**
 * @Description  对象和数组都用 json 形式存储
 * @Author ZhangHua
 * @CreateTime 2020-03-29 08:56
 */
public interface RedisService {

    void set(String key,String value);


    String get(String key);

    boolean expire(String key,long expire);


    void remove(String key);

    Long increment(String key,long delta);
}
