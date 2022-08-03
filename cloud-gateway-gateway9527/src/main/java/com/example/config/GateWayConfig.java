package com.example.config;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpStatus;
import org.apache.http.client.methods.HttpPost;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@Configuration
public class GateWayConfig {
    /**
     * 配置了一个id为route-name的路由规则，
     * 当访问地址 http://localhost:9527/guonei时会自动转发到地址：http://news.baidu.com/guonei
     *
     * @param builder
     * @return
     */
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        RouteLocatorBuilder.Builder routes = builder.routes();

        routes.route("path_route_atguigu", r -> r.path("/guonei").uri("http://news.baidu.com/guonei")).build();

        return routes.build();

    }

    @Bean
    public RouteLocator customRouteLocator2(RouteLocatorBuilder builder) {
        RouteLocatorBuilder.Builder routes = builder.routes();
        routes.route("path_route_atguigu2", r -> r.path("/guoji").uri("http://news.baidu.com/guoji")).build();
        return routes.build();
    }

    public static void main(String[] args) throws MalformedURLException {
//        ZonedDateTime zbj = ZonedDateTime.now(); // 默认时区
//        System.out.println(zbj);
//// 2020-02-05T15:10:03.685+08:00[Asia/Shanghai]
//        ZonedDateTime zny = ZonedDateTime.now(ZoneId.of("Asia/Shanghai")); // 用指定时区获取当前时间
//        System.out.println(zny);

        String url ="https://ip.tool.lu/";
//        URL url = new URL("https://ip.tool.lu/");
//        HttpPost httpPost = new HttpPost(String.valueOf(url));

        HttpResponse response = HttpRequest
                .get(url)
                .keepAlive(true)
                .timeout(20000) //超时，毫秒
                .execute();
        if (response.getStatus() == HttpStatus.HTTP_OK) {
            String result = response.body();
            System.out.println(result);
        } else {
            System.out.println("失败");
        }
    }

}
