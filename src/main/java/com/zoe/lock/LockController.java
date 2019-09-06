package com.zoe.lock;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zoe
 **/
@RestController
public class LockController {


    @Resource
    private DemoLock demoLock;

    @PostMapping("/test")
    public ResponseEntity test(String key, String value, int expire, int timeout, int retry){
        return ResponseEntity.ok(demoLock.lock(key,value,expire,timeout,retry));
    }

    @GetMapping("test1")
    public ResponseEntity test1(String key, String value){
        return ResponseEntity.ok(demoLock.release(key,value));
    }
}
