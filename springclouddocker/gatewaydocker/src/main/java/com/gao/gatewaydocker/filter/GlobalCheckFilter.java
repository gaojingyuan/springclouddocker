package com.gao.gatewaydocker.filter;

import com.gao.gatewaydocker.staff.service.StaffService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.RequestPath;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;


/**
 * @author 段华微
 * @version V1.0
 * @description 描述
 * @ClassName: AuthCheckGatewayFilter
 * @Date 2018/6/11 Copyright(c) 2015 www.wallet.com All rights
 * reserved
 */
@Component
public class GlobalCheckFilter implements GlobalFilter, Ordered {

    private static Logger logger = LoggerFactory.getLogger(GlobalCheckFilter.class);

    private StaffService staffService;

    //设置不拦截的URL
    private List<String> excludedUrls = Arrays.asList(
            "/media/"
    );

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        //获取path
        RequestPath allPath = request.getPath();
        String path = allPath.pathWithinApplication().value();
        //不拦截资源文件
        for (String url : excludedUrls) {
            if (path.contains(url)) {
                return chain.filter(exchange);
            }
        }
        staffService = exchange.getApplicationContext().getBean(StaffService.class);

        //获取参数
        String userName = request.getQueryParams().getFirst("userName");
        String pwd = request.getQueryParams().getFirst("pwd");

        //获取response
        ServerHttpResponse response = exchange.getResponse();
        response.setStatusCode(HttpStatus.OK);
        //设置headers
        HttpHeaders httpHeaders = response.getHeaders();
        httpHeaders.add("Content-Type", "application/json; charset=UTF-8");
        httpHeaders.add("X-Content-Type-Options", "");

        if (null == userName || null == pwd) {
            DataBuffer bodyDataBuffer = response.bufferFactory().wrap("global wrong".getBytes());
            return response.writeWith(Mono.just(bodyDataBuffer));
        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return -200;//数字越小优先级越高
    }
}
