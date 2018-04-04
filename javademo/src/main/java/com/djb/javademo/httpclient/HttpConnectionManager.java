package com.djb.javademo.httpclient;


import net.sf.json.JSONObject;
import org.apache.http.*;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.config.ConnectionConfig;
import org.apache.http.config.MessageConstraints;
import org.apache.http.config.SocketConfig;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.SSLException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.UnknownHostException;
import java.nio.charset.CodingErrorAction;

/**
 * @authot Administrator
 * @date 03
 */
public class HttpConnectionManager {



       private static  PoolingHttpClientConnectionManager connManager=getConnManager();

       private static ConnectionConfig connectionConfig=getConnectionConfig();


       private static RequestConfig defaultRequestConfig=getDefaultRequestConfig();


      // private  HttpRequestRetryHandler myRetryHandler;

       private static CloseableHttpClient httpclient=getHttpClient();

       private static int max_total=200;

       private static int defaule_max_per_route=100;

       private static int so_timeout=500;

       private static int so_linger=60;

       private static int max_header_count=200;

       private static int max_line_length=2000;



        /**
         * 创建连接管理器，并设置相关参数
         */
        public  static PoolingHttpClientConnectionManager getConnManager(){
            if (connManager==null){
                //连接管理器，使用无惨构造
                connManager= new PoolingHttpClientConnectionManager();

                /**
                 * 连接数相关设置
                 */
                //最大连接数
                connManager.setMaxTotal(max_total);
                //默认的每个路由的最大连接数
                connManager.setDefaultMaxPerRoute(defaule_max_per_route);
                //设置到某个路由的最大连接数，会覆盖defaultMaxPerRoute
                connManager.setMaxPerRoute(new HttpRoute(new HttpHost("somehost", 80)), 150);

                /**
                 * socket配置（默认配置 和 某个host的配置）
                 */
                SocketConfig socketConfig = SocketConfig.custom()
                        .setTcpNoDelay(true)     //是否立即发送数据，设置为true会关闭Socket缓冲，默认为false
                        .setSoReuseAddress(true) //是否可以在一个进程关闭Socket后，即使它还没有释放端口，其它进程还可以立即重用端口
                        .setSoTimeout(so_timeout)       //接收数据的等待超时时间，单位ms
                        .setSoLinger(so_linger)         //关闭Socket时，要么发送完所有数据，要么等待60s后，就关闭连接，此时socket.close()是阻塞的
                        .setSoKeepAlive(true)    //开启监视TCP连接是否有效
                        .build();
                connManager.setDefaultSocketConfig(socketConfig);
                connManager.setSocketConfig(new HttpHost("somehost", 80), socketConfig);
            }

            return  connManager;
        }



        /**
         * HTTP connection相关配置（默认配置 和 某个host的配置）
         * 一般不修改HTTP connection相关配置，故不设置
         */
        public static ConnectionConfig getConnectionConfig(){
            if (connectionConfig==null){
                //消息约束
                MessageConstraints messageConstraints = MessageConstraints.custom()
                        .setMaxHeaderCount(max_header_count)
                        .setMaxLineLength(max_line_length)
                        .build();
                //Http connection相关配置
                connectionConfig = ConnectionConfig.custom()
                        .setMalformedInputAction(CodingErrorAction.IGNORE)
                        .setUnmappableInputAction(CodingErrorAction.IGNORE)
                        .setCharset(Consts.UTF_8)
                        .setMessageConstraints(messageConstraints)
                        .build();
                //一般不修改HTTP connection相关配置，故不设置
                //connManager.setDefaultConnectionConfig(connectionConfig);
                //connManager.setConnectionConfig(new HttpHost("somehost", 80), ConnectionConfig.DEFAULT);
            }

            return connectionConfig;

        }

        /**
         * request请求相关配置
         */
        public static RequestConfig getDefaultRequestConfig(){
            if (null ==defaultRequestConfig){
                defaultRequestConfig = RequestConfig.custom()
                        .setConnectTimeout(2 * 1000)         //连接超时时间
                        .setSocketTimeout(2 * 1000)          //读超时时间（等待数据超时时间）
                        .setConnectionRequestTimeout(500)    //从池中获取连接超时时间
                        .setStaleConnectionCheckEnabled(true)//检查是否为陈旧的连接，默认为true，类似testOnBorrow
                        .build();
            }
            return defaultRequestConfig;
        }


        /**
         * 重试处理
         * 默认是重试3次
         */
        //禁用重试(参数：retryCount、requestSentRetryEnabled)
       // HttpRequestRetryHandler requestRetryHandler = new DefaultHttpRequestRetryHandler(0, false);


        /**
         * 创建httpClient
         */
        public static CloseableHttpClient getHttpClient(){
            if (httpclient==null){
                System.out.println("httpclient is null");
                httpclient = HttpClients.custom()
                        .setConnectionManager(connManager)             //连接管理器
                        .setProxy(new HttpHost("myproxy", 8080))       //设置代理
                        .setDefaultRequestConfig(defaultRequestConfig) //默认请求配置
                        .setRetryHandler(new MyHttpRequestRetryHandler())               //重试策略
                        .build();
            }
            return httpclient;
        }

        public static String sendWeChatTest(String json){

            final String CONTENT_TYPE_TEXT_JSON = "text/json";
            String url = "http://wxt.tempustmc.cn/api/wxmsg";
            HttpPost httpPost = new HttpPost(url);
            httpPost.setConfig(getDefaultRequestConfig());
            httpPost.setHeader("Content-Type", "application/json;charset=UTF-8");
            CloseableHttpClient httpClienttemp=httpclient;
            CloseableHttpResponse response = null;
            System.out.println("httpClienttemp---"+httpClienttemp.hashCode());
            StringEntity se;
            String strResult = "";
            try {
                se = new StringEntity(json, "UTF-8");
                se.setContentType(CONTENT_TYPE_TEXT_JSON);
                httpPost.setEntity(se);
                response = httpClienttemp.execute(httpPost);
                if (response.getStatusLine().getStatusCode() == 200) {
                    //读返回数据
                    String conResult = EntityUtils.toString(response.getEntity());
                    System.out.println(" sendWeChat result response : " + conResult);
                    JSONObject sobj = new JSONObject();
                    sobj = sobj.fromObject(conResult);
                    strResult = sobj.getString("msg");
                } else {
                    strResult = "发送失败";
                    System.out.println(" sendWeChat send error : " + response.getStatusLine().getStatusCode());
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("sendWeChat send 调用接口出错 " + e);
            }finally{
                if(response != null){
                    try {
                        //关闭连接(如果已经释放连接回连接池，则什么也不做)
                        System.out.println("关闭  response");

                        response.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                /*if(httpClienttemp != null){
                    try {
                        //关闭连接管理器，并会关闭其管理的连接
                        httpClienttemp.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }*/
            }
            return strResult;
        }

    public static void main(String[] args) {
        for (int i=0;i<1;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        String string="{\"userId\":\"1054315\",\"infoId\":\"22018040300003\",\"wxMsgId\":\"3\",\"contents\":[\"您的出差订单已全部审批完成\",\"22018040300003 2018-04-03 11:50\",\"伊吾舞\",\"505.3 元  \",\"余廷test\",\"通过\",\"我们将尽快完成后续处理，敬请关注。为保证订单得到及时处理，请保持手机畅通。 \"]}";
                        String string1="{}";
                        sendWeChatTest(string1);
                        Thread.sleep(1000);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();

        }

    }

    }



//自定义重试策略
 class  MyHttpRequestRetryHandler  implements HttpRequestRetryHandler{

    public boolean retryRequest(IOException exception, int executionCount, HttpContext context) {
        //Do not retry if over max retry count
        if (executionCount >= 3) {
            return false;
        }
        //Timeout
        if (exception instanceof InterruptedIOException) {
            return false;
        }
        //Unknown host
        if (exception instanceof UnknownHostException) {
            return false;
        }
        //Connection refused
        if (exception instanceof ConnectTimeoutException) {
            return false;
        }
        //SSL handshake exception
        if (exception instanceof SSLException) {
            return false;
        }

        HttpClientContext clientContext = HttpClientContext.adapt(context);
        HttpRequest request = clientContext.getRequest();
        boolean idempotent = !(request instanceof HttpEntityEnclosingRequest);
        //Retry if the request is considered idempotent
        //如果请求类型不是HttpEntityEnclosingRequest，被认为是幂等的，那么就重试
        //HttpEntityEnclosingRequest指的是有请求体的request，比HttpRequest多一个Entity属性
        //而常用的GET请求是没有请求体的，POST、PUT都是有请求体的
        //Rest一般用GET请求获取数据，故幂等，POST用于新增数据，故不幂等
        if (idempotent) {
            return true;
        }

        return false;
    }


}






