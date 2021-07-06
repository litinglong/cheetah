package com.silva.chetax.schedule.center.sys.controller;


import java.math.BigDecimal;

import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.silva.chetax.schedule.center.sys.entity.SysScheduleInfoEntity;
import com.silva.chetax.schedule.center.sys.service.ISysScheduleInfoService;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author litinglong
 * @since 2021-06-27
 */
@RestController
@RequestMapping("/sys/scheduleInfoController")
@Slf4j
public class SysScheduleInfoController {
	@Autowired
	ISysScheduleInfoService iScheduleInfoService;
	
	@GetMapping("getScheduleInfoById/{id}")
	public SysScheduleInfoEntity getScheduleInfoById(@PathVariable("id") BigDecimal id){
		return iScheduleInfoService.getScheduleInfoById(id);
	}
	
	@GetMapping("deleteScheduleInfoById/{id}")
	public void deleteScheduleInfoById(@PathVariable("id") BigDecimal id) throws SchedulerException{
		iScheduleInfoService.deleteScheduleInfoById(id);
	}
	
	@PostMapping("insertSysScheduleInfoEntity")
	public void insertSysScheduleInfoEntity(@RequestBody SysScheduleInfoEntity scheduleInfo){
		iScheduleInfoService.insertSysScheduleInfoEntity(scheduleInfo);
		log.info("11");
	}
	
	@PostMapping("findPage/{pageNum}/{pageSize}")
	public PageInfo<SysScheduleInfoEntity> findPage(@PathVariable("pageNum") int pageNum,
			@PathVariable("pageSize")  int pageSize){
		PageInfo<SysScheduleInfoEntity> pageInfo = iScheduleInfoService.findPage(pageNum,pageSize);
		return pageInfo;
	}
	
	@GetMapping("executeJob/{id}")
	public void executeJob(@PathVariable("id") BigDecimal id) throws SchedulerException{
		iScheduleInfoService.executeById(id);
	}
	
	@GetMapping("changeStatus/{id}")
	public void changeStatus(@PathVariable("id") BigDecimal id) throws SchedulerException{
		iScheduleInfoService.changeStatus(id);
	}
	
	@PostMapping("updateScheduleInfoCron/{id}")
	public void updateScheduleInfoCron(@PathVariable("id") BigDecimal id, @RequestParam("cron") String cron){
		iScheduleInfoService.updateScheduleInfoCron(id,cron);
	}
}
