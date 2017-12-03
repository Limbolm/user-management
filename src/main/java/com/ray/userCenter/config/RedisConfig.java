package com.ray.userCenter.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import java.lang.reflect.Method;

/**
 * Redis 配置类
 */

@Configuration
@EnableCaching
public class RedisConfig  extends CachingConfigurerSupport {

    /**
     * 生成策略  定义缓存数据 key 生成策略的bean
     * 包名+类名+方法名+所有参数
     * @return
     */
    @Bean
    public KeyGenerator getKeyGenerator(){
        return new KeyGenerator() {
            @Override
            public Object generate(Object object, Method method, Object... objects) {
                StringBuilder objectBuilder=new StringBuilder();
                objectBuilder.append(object.getClass().getName());
                objectBuilder.append(method.getName());
                for (Object o:objects){
                    objectBuilder.append(o.getClass().getName());
                }
                return objectBuilder.toString();
            }
        };
    }

     /*要启用spring缓存支持,需创建一个 CacheManager的 bean，CacheManager 接口有很多实现，这里Redis 的集成，用 RedisCacheManager这个实现类
    Redis 不是应用的共享内存，它只是一个内存服务器，就像 MySql 似的，
    我们需要将应用连接到它并使用某种“语言”进行交互，因此我们还需要一个连接工厂以及一个 Spring 和 Redis 对话要用的 RedisTemplate，
    这些都是 Redis 缓存所必需的配置，把它们都放在自定义的 CachingConfigurerSupport 中
     */
    @Bean
    public CacheManager cacheManager(@SuppressWarnings("rawtypes") RedisTemplate redisTemplate){
        RedisCacheManager redisCacheManager=new RedisCacheManager(redisTemplate);
        redisCacheManager.setDefaultExpiration(300);//缓存时间 单位 s
        return  redisCacheManager;

    }

    public RedisTemplate<String,String> redisTemplate(RedisConnectionFactory factory){
        StringRedisTemplate template=new StringRedisTemplate(factory);
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer=new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper objectMapper=new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(objectMapper);
        template.setValueSerializer(jackson2JsonRedisSerializer);
        template.afterPropertiesSet();

        return template;
    }


}
