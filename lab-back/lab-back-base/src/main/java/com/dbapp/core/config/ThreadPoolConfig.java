package com.dbapp.core.config;

import cn.hutool.core.thread.ThreadFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.*;

@Configuration
public class ThreadPoolConfig {

    /**
     * 处理任务用
     * 不会有很多，多余的任务让主线程执行
     * @return
     */
    @Bean
    public ExecutorService taskExecutor(){
        return new ThreadPoolExecutor(2,2,0, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(500),new ThreadFactoryBuilder().setNamePrefix("blog-").build(),
                new ThreadPoolExecutor.CallerRunsPolicy());
    }
}
