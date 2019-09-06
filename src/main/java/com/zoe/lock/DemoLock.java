package com.zoe.lock;

import cn.gjing.lock.AbstractLock;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author zoe
 **/

@Component
@Service
public class DemoLock extends AbstractLock {

    @Resource
    private StringRedisTemplate stringRedisTemplate;


    @Override
    public String lock(String key, String value, int expire, int timeout, int retry) {
        boolean  result =  stringRedisTemplate.opsForValue().setIfAbsent(key,value,timeout,TimeUnit.SECONDS);
        if (result){
            return key;
        }
        return null;
    }

    @Override
    public String release(String key, String value) {
        String result = stringRedisTemplate.opsForValue().get(key);
        assert result != null;
        if (result.isEmpty()){
            return null;
        }
        return result;
    }
}
