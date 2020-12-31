package com.dbapp.core.api;

import cn.hutool.core.lang.Dict;
import com.dbapp.core.response.Response;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BaseController {


    @RequestMapping(value = "/lab",method = RequestMethod.GET)
    public Response getLabList(){
        List<Dict> dicts = new ArrayList<>(9);
        dicts.add(
            Dict.create().set("title","微服务入门：任务管理器")
                .set("difficulty", "简单")
                .set("time", "15分钟")
                .set("description", "使用 Spring Cloud Alibaba 实现一个简易的任务管理器；学习和体验微服务开发。")
                .set("href", "https://www.baidu.com")
                .set("open", true)
        );

        dicts.add(
                Dict.create().set("title","微服务入门：任务管理器")
                        .set("difficulty", "简单")
                        .set("time", "15分钟")
                        .set("description", "使用 Spring Cloud Alibaba 实现一个简易的任务管理器；学习和体验微服务开发。")
                        .set("href", "https://www.baidu.com")
                        .set("open", true)
        );

        dicts.add(
                Dict.create().set("title","微服务入门：任务管理器")
                        .set("difficulty", "简单")
                        .set("time", "15分钟")
                        .set("description", "使用 Spring Cloud Alibaba 实现一个简易的任务管理器；学习和体验微服务开发。")
                        .set("href", "https://www.baidu.com")
                        .set("open", true)
        );

        dicts.add(
                Dict.create().set("title","微服务入门：任务管理器")
                        .set("difficulty", "简单")
                        .set("time", "15分钟")
                        .set("description", "使用 Spring Cloud Alibaba 实现一个简易的任务管理器；学习和体验微服务开发。")
                        .set("href", "https://www.baidu.com")
                        .set("open", true)
        );

        dicts.add(
                Dict.create().set("title","微服务入门：任务管理器")
                        .set("difficulty", "简单")
                        .set("time", "15分钟")
                        .set("description", "使用 Spring Cloud Alibaba 实现一个简易的任务管理器；学习和体验微服务开发。")
                        .set("href", "")
                        .set("open", false)
        );

        dicts.add(
                Dict.create().set("title","微服务入门：任务管理器")
                        .set("difficulty", "简单")
                        .set("time", "15分钟")
                        .set("description", "使用 Spring Cloud Alibaba 实现一个简易的任务管理器；学习和体验微服务开发。")
                        .set("href", "")
                        .set("open", false)
        );


        return Response.success(dicts);
    }
}
