package com.ray.userCenter.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * Redis操作 工具类
 * @author ray
 * @date
 */
@Component
public class RedisUtil {

    @Autowired
    private RedisTemplate redisTemplate;


    /**
     * 根据key 删除对应的 vale
     * @param key
     */
    public void removeBykey(final String key){
        if (exists(key)){
            redisTemplate.delete(key);
        }
    }

    /**
     * 根据传入的key 删除对应的value
     * @param keys
     */
    public void removeBykeys(final String ... keys){
        for (String key:keys){
            removeBykey(key);
        }
    }

    /**
     * 判断该key 是否存在
     * @param key
     * @return
     */
    public boolean exists(final String key){
        return redisTemplate.hasKey(key);
    }

    /**
     * 根据key 获取对象
     * @param key
     * @return
     */
    public Object getObject(final String key){
        Object result=null;
        ValueOperations<Serializable,Object> value=redisTemplate.opsForValue();
        result=value.get(key);
        return result;
    }

    /**
     * 新增对象
     * @param key
     * @param value
     * @return
     */
    public boolean setKeyValue(final String key,Object value){
        boolean result=false;
        try{
            ValueOperations<String,Object> valueOperations=redisTemplate.opsForValue();
            valueOperations.set(key,value);
            result=true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
}
