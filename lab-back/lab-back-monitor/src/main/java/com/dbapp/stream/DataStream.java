package com.dbapp.stream;


import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * 功能处理
 * @param <T>
 */
public interface DataStream<T> {

    /**
     * 数据转换 相当于流的map
     * @param processFunction
     * @param <R>
     * @return
     */
    public <R> DataStream<R> process(ProcessFunction<T,R> processFunction);

    /**
     * 主要做一个map
     * @param mapFunction
     * @return
     */
    public DataStream<T> map(MapFunction<T> mapFunction);

    /**
     * 过滤
     * @param predicate
     * @return
     */
    public DataStream<T> filter(Predicate<T> predicate);
}
