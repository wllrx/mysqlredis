package com.zoe;

import cn.gjing.lock.core.EnableRedisLock;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRedisLock
public class MysqlredisApplication {

    public static void main(String[] args) {
        SpringApplication.run(MysqlredisApplication.class, args);
    }

}
