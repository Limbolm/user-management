package com.ray.userCenter.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * jsion转化工具
 * @author ray
 *
 */
public class JsonUtil {

    private static final Logger LOG = LoggerFactory.getLogger(JsonUtil.class);

    public JsonUtil() {
    }

    /**
     * 单例模式 创建 ObjectMapper 供全局使用
     */
    private static class singletonObjectMapperBuiler{
        private static ObjectMapper objectMapper;

        static {
            objectMapper=new ObjectMapper();
            // 设置日期对象的输出格式
            objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINESE));
            // 设置输入时忽略在JSON字符串中存在但Java对象实际没有的属性
            objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        }
    }

    /**
     * 获取ObjectMapper
     * @return
     */
    private static ObjectMapper getObjectMapper(){
        return singletonObjectMapperBuiler.objectMapper;
    }

    /**
     * 将对象转化成json字符串
     * @param object
     * @return
     */
    public static String parseJsonString(Object object){
        if (object==null){
            return null;
        }
        try {
            return getObjectMapper().writeValueAsString(object);
        } catch (JsonProcessingException e) {
            LOG.error("对象{}转换失败",object.getClass());
            return null;
        }
    }

    /**
     * 将字符串转化成json格式
     * @param value
     * @return
     */
    public  static JsonNode parseJson(String value){
        if (value == null || value.length()<0){
            return null;
        }
        try {
            return getObjectMapper().readTree(value);
        } catch (IOException e) {
            LOG.error("数据{}转化失败！错误：{}",value,e);
            return null;
        }
    }

    /**
     * 将输入流转化成json格式
     * @param inputStream
     * @return
     */
    public static JsonNode parseInputStremToJson(InputStream inputStream){
        try {
            return getObjectMapper().readTree(inputStream);
        } catch (IOException e) {
            LOG.error("数据转化失败！错误：{}",e);
            return null;
        }
    }

    /**
     * 将json 转化成java bean
     * @param jsonvalue
     * @param classType
     * @param <T>
     * @return
     */
    public static <T>T parseObject(String jsonvalue,Class<T> classType ){
        if (jsonvalue!=null && jsonvalue.length()>0){
            try {
                return getObjectMapper().readValue(jsonvalue,classType);
            } catch (IOException e) {
                LOG.error("类{}转化失败！错误：{}",classType,e);
            }
        }
        return null;
    }

    /**
     * 将json 转化成collection
     * @param jsonvalue
     * @param collection
     * @param elementClass
     * @param <T>
     * @return
     */
    public static <T>T parseCollection(String jsonvalue,Class<?> collection,Class<?>... elementClass){
        if (jsonvalue!=null && jsonvalue.length()>0){
            try {
                com.fasterxml.jackson.databind.JavaType type=getObjectMapper().getTypeFactory().constructParametrizedType(collection,collection,collection);
                return getObjectMapper().readValue(jsonvalue,type);
            } catch (IOException e) {
                LOG.error("类{}转化失败！错误：{}",collection,e);
            }
        }
        return null;
    }

    /**
     * 创建一个空的json对象
     *
     * @return
     */
    public static ObjectNode createObjectNode() {
        return getObjectMapper().createObjectNode();
    }


    /**
     * 创建一个空的json数组对象
     *
     * @return
     */
    public static ArrayNode createArrayNode() {
        return getObjectMapper().createArrayNode();
    }

    /**
     * 对象与对象间的转化
     * @param object
     * @param tClass
     * @param <T>
     * @return
     */
    public static <T> T parseToObject(Object object,Class<T> tClass){
        if (object!=null){
            return getObjectMapper().convertValue(object,tClass);
        }
        return null;
    }

    /**
     * collection 间的转化
     * @param object
     * @param collectionCalss
     * @param targCalass
     * @param <T>
     * @return
     */
    public static <T> T parseToCollection(Object object,Class<?> collectionCalss,Class<?>... targCalass){
        if (object!=null){
            JavaType type=getObjectMapper().getTypeFactory().constructParametrizedType(collectionCalss,collectionCalss,targCalass);
            return getObjectMapper().convertValue(object,type);
        }
        return null;

    }


}
