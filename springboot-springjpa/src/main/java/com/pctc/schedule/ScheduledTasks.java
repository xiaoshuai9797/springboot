package com.pctc.schedule;

import com.pctc.model.User;
import com.pctc.service.UserService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class ScheduledTasks {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Resource
    private UserService userService;


    //@Scheduled(fixedRate = 5000)
    @Scheduled(cron = "*/5 * * * * ?")//定时5秒执行一次
    //@Scheduled(cron="0 0 23 L * ?")定时每月最后一天的23点执行一次
    @Async//同步异步
    public void reportCurrentTime(){
        User findUser = userService.findUserOne(1);
        System.out.println(findUser);
        System.out.println("现在的时间是:"+dateFormat.format(new Date()));

        System.out.println(Thread.currentThread().getName());
    }
}
