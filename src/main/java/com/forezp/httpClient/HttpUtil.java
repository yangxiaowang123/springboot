package com.forezp.httpClient;

import com.forezp.entity.BBOSSHttpReqLog;
import com.forezp.entity.RspMsg;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class HttpUtil {


	@Resource(name = "httpClientManagerFactoryBen")
	private CloseableHttpClient client;

	@Value("${httpclient.config.httpUrl}")
	private String httpUrl;
	/**
	 * 发送报文给网状网
	 * 
	 * @param address
	 * @param xmlHead
	 * @param xmlBody
	 * @return
	 * @throws Exception
	 */
	public RspMsg post2Tsn(String address, String xmlHead, String xmlBody){

		RspMsg msg = new RspMsg();

		HttpEntity entity = null;
		try {
			HttpPost post = new HttpPost(address);

			//设置参数xmlHead xml 报文头 xmlBody报文体
			MultipartEntity reqEntity = new MultipartEntity();
			reqEntity.addPart("xmlhead", new StringBody(xmlHead, Charset.forName("UTF-8")));
			reqEntity.addPart("xmlbody", new StringBody(xmlBody, Charset.forName("UTF-8")));
			post.setEntity(reqEntity);

			CloseableHttpResponse response = client.execute(post);
			int respHttpStatus = response.getStatusLine().getStatusCode();
			msg.setErrCode(respHttpStatus + "");
			if (respHttpStatus == 200) {
				entity = response.getEntity();
				// 保存反馈报文
				msg.setErrDesc(EntityUtils.toString(entity, "UTF-8"));
			}
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
		return msg;
	}

	/*public void postBBossNThread(List<XMLObjects> XMLObjects){

		ExecutorService service = Executors.newFixedThreadPool(2);
		for (BBOSSHttpReqLog req:bbossHttpReqLogs)
		{
			service.submit(new Runnable() {

				@Override
				public void run() {
					System.out.println("the current thread is:"+Thread.currentThread().getName());
					RspMsg msg = new RspMsg();

					HttpEntity entity = null;
					try {
						HttpPost post = new HttpPost(httpUrl);

						//设置参数xmlHead xml 报文头 xmlBody报文体
						MultipartEntity reqEntity = new MultipartEntity();
						reqEntity.addPart("xmlhead", new StringBody(xmlHead, Charset.forName("UTF-8")));
						reqEntity.addPart("xmlbody", new StringBody(xmlBody, Charset.forName("UTF-8")));
						post.setEntity(reqEntity);

						CloseableHttpResponse response = client.execute(post);
						int respHttpStatus = response.getStatusLine().getStatusCode();
						msg.setErrCode(respHttpStatus + "");
						if (respHttpStatus == 200) {
							entity = response.getEntity();
							// 保存反馈报文
							msg.setErrDesc(EntityUtils.toString(entity, "UTF-8"));
						}
						EntityUtils.consumeQuietly(entity);
					} catch (ClientProtocolException e) {
						System.out.println(e);
					} catch (ParseException e) {
						System.out.println(e);
					} catch (IOException e) {
						System.out.println(e);
					} finally{
						if(null != entity){// 释放连接
							System.out.println("释放连接");
							EntityUtils.consumeQuietly(entity);
						}
					}

				}
			});
		}
		return msg;

	}*/

}
