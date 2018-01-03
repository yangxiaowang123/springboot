package com.forezp.httpClient;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.UnknownHostException;

import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;

import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpRequest;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.protocol.HttpContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 描述：HttpClient的重试处理机制
 */
@Configuration
public class MyhttpRequestRetryHandler {

    @Value("${httpclient.config.retryTime}")
    private int retryTime;

    @Bean
    public HttpRequestRetryHandler httpRequestRetryHandler() {
        // 请求重试
        final int retryTime = this.retryTime;
        return new HttpRequestRetryHandler() {
            public boolean retryRequest(IOException exception, int executionCount, HttpContext context) {
                // Do not retry if over max retry count,如果重试次数超过了retryTime,则不再重试请求
                if (executionCount >= retryTime) {
                    System.out.print("如果重试次数超过了retryTime,则不再重试请求,记录log,24小时人工干预");
                    return false;
                }
                // 服务端断掉客户端的连接异常
                if (exception instanceof NoHttpResponseException) {
                    System.out.print("服务端断掉客户端的连接异常重试");
                    return true;
                }
                // time out 超时重试
                if (exception instanceof InterruptedIOException) {
                    System.out.print("time out 超时重试");
                    return true;
                }
                // Unknown host
                if (exception instanceof UnknownHostException) {
                    System.out.print("Unknown host");
                    return false;
                }
                // Connection refused
                if (exception instanceof ConnectTimeoutException) {
                    System.out.print("Connection refused");
                    return false;
                }
                // SSL handshake exception
                if (exception instanceof SSLException) {
                    System.out.print("SSL handshake exception");
                    return false;
                }
                HttpClientContext clientContext = HttpClientContext.adapt(context);
                HttpRequest request = clientContext.getRequest();
                if (!(request instanceof HttpEntityEnclosingRequest)) {
                    System.out.print("=============Retry");

                    return true;
                }
                return false;
            }
        };
    }
}