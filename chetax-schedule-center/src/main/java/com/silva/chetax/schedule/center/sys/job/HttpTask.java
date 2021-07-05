package com.silva.chetax.schedule.center.sys.job;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.silva.chetax.schedule.center.sys.entity.SysScheduleInfoEntity;
import com.silva.chetax.schedule.center.sys.service.ISysScheduleInfoService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HttpTask extends QuartzJobBean {
	@Autowired
	ISysScheduleInfoService iScheduleInfoService;
	@Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
		SysScheduleInfoEntity httpJobEntity = (SysScheduleInfoEntity)jobExecutionContext.getMergedJobDataMap().get("scheduleInfo");
		iScheduleInfoService.doExecuteJob(httpJobEntity);
    }
}


