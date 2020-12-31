package com.dbapp.stream;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class TestStream {

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            String data = "{\"user\": \"dobb\",\"age\": 34,\"ints\": [3,4,5,7],\"book\": {\n" +
                    "\"name\": \"你好\"\n" +
                    "}}";
            Map<String,Object> map = JSONObject.parseObject(data, new TypeReference<Map<String,Object>>(){});
            Map<String, Object> output = new HashMap<>();
        }

        IntStream.of(0,10).filter(i -> i != 4).mapToObj(String::valueOf).forEach(System.out::println);
    }

}
