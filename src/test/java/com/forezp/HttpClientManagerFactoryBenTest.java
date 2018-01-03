package com.forezp;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.annotation.Resource;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HttpClientManagerFactoryBenTest {
    // 注入HttpClient实例
    @Resource(name = "httpClientManagerFactoryBen")
    private CloseableHttpClient client;

    @Test
    public void getTest() throws ClientProtocolException, IOException, InterruptedException{
        ExecutorService service = Executors.newFixedThreadPool(2);
        for(int i=0; i<10; i++){
            service.submit(new Runnable() {

                @Override
                public void run() {
                    System.out.println("the current thread is:"+Thread.currentThread().getName());
                    HttpEntity entity = null;
                    try {
                        HttpGet get = new HttpGet("http://localhost:8081/springboot/girls");
                        // 通过httpclient的execute提交 请求 ，并用CloseableHttpResponse接受返回信息
                        CloseableHttpResponse response = client.execute(get);
                        System.out.println("client object:"+client);
                        entity = response.getEntity();
                        System.out.println("============"+EntityUtils.toString(entity, Consts.UTF_8)+"=============");
                        EntityUtils.consumeQuietly(entity);// 释放连接
                    } catch (ClientProtocolException e) {
                        e.printStackTrace();
                    } catch (ParseException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally{
                        if(null != entity){// 释放连接
                            EntityUtils.consumeQuietly(entity);
                        }
                    }
                }
            });
        }
        Thread.sleep(60000);
    }
    @Test
    public void postTest() throws InterruptedException {

        ExecutorService service = Executors.newFixedThreadPool(2);
        for(int i=0; i<10; i++){
            service.submit(new Runnable() {

                @Override
                public void run() {
                    System.out.println("the current thread is:"+Thread.currentThread().getName());
                    HttpEntity entity = null;
                    try {
                        HttpPost post = new HttpPost("http://localhost:8081/springboot/girls");

                        //设置参数
                        Map<String,String> createMap = new HashMap<String,String>();
                        createMap.put("cupSize","H");
                        createMap.put("age","22");
                        List<NameValuePair> list = new ArrayList<NameValuePair>();
                        Iterator iterator = createMap.entrySet().iterator();
                        while(iterator.hasNext()){
                            Map.Entry<String,String> elem = (Map.Entry<String, String>) iterator.next();
                            list.add(new BasicNameValuePair(elem.getKey(),elem.getValue()));
                        }
                        if(list.size() > 0){
                            UrlEncodedFormEntity entity_1 = new UrlEncodedFormEntity(list,Consts.UTF_8);
                            post.setEntity(entity_1);
                        }
                        CloseableHttpResponse response = client.execute(post);
                        System.out.println("client object:"+client);
                        entity = response.getEntity();
                        System.out.println("============"+EntityUtils.toString(entity, Consts.UTF_8)+"=============");
                        EntityUtils.consumeQuietly(entity);// 释放连接
                    } catch (ClientProtocolException e) {
                        e.printStackTrace();
                    } catch (ParseException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally{
                        if(null != entity){// 释放连接
                            EntityUtils.consumeQuietly(entity);
                        }
                    }

                }
            });
        }
        Thread.sleep(5000);
    }
    @Test
    public void post2Test(){



        System.out.println("the current thread is:"+Thread.currentThread().getName());
        HttpEntity entity = null;
        try {
            String url = "http://localhost:8081/springboot/verifyPrimaryMsisdn"; //local
            String newUrl = "http://localhost:8080/ReceiveBossWS";
            HttpPost post = new HttpPost(newUrl);

            String xmlHead = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                    "<InterBOSS>\n" +
                    "<Version>0100</Version>\n" +
                    "<TestFlag>0</TestFlag>\n" +
                    "<BIPType>\n" +
                    "<BIPCode>BIP3B523</BIPCode>\n" +
                    "<ActivityCode>T4011004</ActivityCode>\n" +
                    "<ActionCode>0</ActionCode>\n" +
                    "</BIPType>\n" +
                    "<RoutingInfo>\n" +
                    "<OrigDomain>BBSS</OrigDomain>\n" +
                    "<RouteType>00</RouteType>\n" +
                    "<Routing>\n" +
                    "<HomeDomain>BOSS</HomeDomain>\n" +
                    "<RouteValue>210</RouteValue>\n" +
                    "</Routing>\n" +
                    "</RoutingInfo>\n" +
                    "<TransInfo>\n" +
                    "<SessionID>BBSS1499915394095</SessionID>\n" +
                    "<TransIDO>BBSST40110042017071301553039</TransIDO>\n" +
                    "<TransIDOTime>20170713110954</TransIDOTime>\n" +
                    "</TransInfo>\n" +
                    "</InterBOSS>\n" +
                    "\n";
            String xmlBody = "<?xml version='1.0' encoding='UTF-8'?><InterBOSS><SvcCont><![CDATA[<?xml version=\"1.0\" encoding=\"UTF-8\"?><OrderInfoReq> <OrderSourceID>0</OrderSourceID> <CustomerNumber>210019999210000049</CustomerNumber> <OrderInfo> <POOrderNumber>2101707132003924</POOrderNumber> <POSpecNumber>50005</POSpecNumber> <ProductOfferingID>837564</ProductOfferingID> <HostCompany>210</HostCompany> <POOrderBusinesses> <OperationSubTypeID>1</OperationSubTypeID> </POOrderBusinesses> <BusinessMode>5</BusinessMode> <POOrderRatePolicys/> <PORatePolicyEffRule>1</PORatePolicyEffRule> <ProductOrders> <ProductOrderInfo> <ProductOrder> <ProductOrderNumber>2101707132003924001</ProductOrderNumber> <ProductID>9000924524</ProductID> <ProductSpecNumber>5000501</ProductSpecNumber> <AccessNumber/> <PriAccessNumber/> <Description/> <ServiceLevelID>1</ServiceLevelID> </ProductOrder> <ProductOrderRatePlans> <ProductOrderRatePlan> <RatePlanID>6</RatePlanID> <Action>1</Action> <Description>免费套餐</Description> </ProductOrderRatePlan> </ProductOrderRatePlans> <ProductOrderBusinesses> <OperationSubTypeID>1</OperationSubTypeID> </ProductOrderBusinesses> <ProductOrderCharacters> <ProductOrderCharacter> <ProductSpecCharacterNumber>50005010001</ProductSpecCharacterNumber> <CharacterValue>1</CharacterValue> <Name>带宽种类</Name> <Action>1</Action> </ProductOrderCharacter> <ProductOrderCharacter> <ProductSpecCharacterNumber>50005010009</ProductSpecCharacterNumber> <CharacterValue>0</CharacterValue> <Name>端口处理结果</Name> <Action>1</Action> <CharacterGroup>1001</CharacterGroup> </ProductOrderCharacter> <ProductOrderCharacter> <ProductSpecCharacterNumber>50005010004</ProductSpecCharacterNumber> <CharacterValue>33</CharacterValue> <Name>上浮比例（%）</Name> <Action>1</Action> </ProductOrderCharacter> <ProductOrderCharacter> <ProductSpecCharacterNumber>50005010003</ProductSpecCharacterNumber> <CharacterValue>1</CharacterValue> <Name>单价（元/月/带宽）</Name> <Action>1</Action> </ProductOrderCharacter> <ProductOrderCharacter> <ProductSpecCharacterNumber>50005010005</ProductSpecCharacterNumber> <CharacterValue>2</CharacterValue> <Name>计费类型</Name> <Action>1</Action> </ProductOrderCharacter> <ProductOrderCharacter> <ProductSpecCharacterNumber>50005010008</ProductSpecCharacterNumber> <CharacterValue>陆奥</CharacterValue> <Name>端口名称</Name> <Action>1</Action> <CharacterGroup>1002</CharacterGroup> </ProductOrderCharacter> <ProductOrderCharacter> <ProductSpecCharacterNumber>50005010007</ProductSpecCharacterNumber> <CharacterValue>10.10.141.143</CharacterValue> <Name>设备IP地址</Name> <Action>1</Action> <CharacterGroup>1001</CharacterGroup> </ProductOrderCharacter> <ProductOrderCharacter> <ProductSpecCharacterNumber>50005010009</ProductSpecCharacterNumber> <CharacterValue>0</CharacterValue> <Name>端口处理结果</Name> <Action>1</Action> <CharacterGroup>1002</CharacterGroup> </ProductOrderCharacter> <ProductOrderCharacter> <ProductSpecCharacterNumber>50005010006</ProductSpecCharacterNumber> <CharacterValue>长门</CharacterValue> <Name>设备名称</Name> <Action>1</Action> <CharacterGroup>1001</CharacterGroup> </ProductOrderCharacter> <ProductOrderCharacter> <ProductSpecCharacterNumber>50005010002</ProductSpecCharacterNumber> <CharacterValue>1</CharacterValue> <Name>带宽条数</Name> <Action>1</Action> </ProductOrderCharacter> <ProductOrderCharacter> <ProductSpecCharacterNumber>50005010006</ProductSpecCharacterNumber> <CharacterValue>陆奥</CharacterValue> <Name>设备名称</Name> <Action>1</Action> <CharacterGroup>1002</CharacterGroup> </ProductOrderCharacter> <ProductOrderCharacter> <ProductSpecCharacterNumber>50005010007</ProductSpecCharacterNumber> <CharacterValue>10.10.141.162</CharacterValue> <Name>设备IP地址</Name> <Action>1</Action> <CharacterGroup>1002</CharacterGroup> </ProductOrderCharacter> <ProductOrderCharacter> <ProductSpecCharacterNumber>50005010008</ProductSpecCharacterNumber> <CharacterValue>长门</CharacterValue> <Name>端口名称</Name> <Action>1</Action> <CharacterGroup>1001</CharacterGroup> </ProductOrderCharacter> </ProductOrderCharacters> </ProductOrderInfo> </ProductOrders> <ContactorInfo> <ContactorType>2</ContactorType> <ContactorName>俞俊剑</ContactorName> <ContactorPhone>13564162435</ContactorPhone> </ContactorInfo> <ContactorInfo> <ContactorType>5</ContactorType> <ContactorName>肖天威</ContactorName> <ContactorPhone>13651887161</ContactorPhone> </ContactorInfo> <ContactorInfo> <ContactorType>4</ContactorType> <ContactorName>-</ContactorName> <ContactorPhone>-</ContactorPhone> </ContactorInfo> <FinishTime>20170713110926</FinishTime> <TimeStamp>20170713110925</TimeStamp> </OrderInfo></OrderInfoReq>]]></SvcCont></InterBOSS>\n" +
                    "\n";
            //设置参数xmlHead xml 报文头 xmlBody报文体
                   MultipartEntity reqEntity = new MultipartEntity();
            reqEntity.addPart("xmlhead", new StringBody(xmlHead, Charset.forName("UTF-8")));
            reqEntity.addPart("xmlbody", new StringBody(xmlBody, Charset.forName("UTF-8")));
            post.setEntity(reqEntity);
            CloseableHttpResponse response = client.execute(post);
            System.out.println("client object:"+client);

            entity = response.getEntity();
            System.out.println("============"+EntityUtils.toString(entity, Consts.UTF_8)+"=============");
            EntityUtils.consumeQuietly(entity);// 释放连接
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            if(null != entity){// 释放连接
                System.out.println("释放连接");
                EntityUtils.consumeQuietly(entity);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("中文测试");
    }

}