package com.forezp.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


//@Component
public class BBossOrderRetryScheduled {
	
	private static final Logger logger = LoggerFactory.getLogger(BBossOrderRetryScheduled.class);

	/**
	 *
	 */
	@Scheduled(cron="0 */1 * * * ?")
	public void retryAddDevReq() {

		// 间隔1分钟,执行工单上传任务
		Thread current = Thread.currentThread();
		System.out.println("定时任务1:"+current.getId());
		logger.info("ScheduledTest.executeFileDownLoadTask 定时任务1:"+current.getId()+ ",name:"+current.getName());
	}





}
