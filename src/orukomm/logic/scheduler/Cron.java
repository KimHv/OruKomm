package orukomm.logic.scheduler;

import static org.quartz.DateBuilder.todayAt;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import orukomm.logic.scheduler.jobs.EmailJob;

public class Cron {
    
    public static void main(String[] args) throws SchedulerException {
        JobDetail jobDetail = JobBuilder.newJob(EmailJob.class).build();
        System.out.println("hehe");
        Trigger trigger = TriggerBuilder
                .newTrigger()
                .withIdentity("EmailTrigger")
                .startAt(todayAt(12, 0, 0)) // Email job fires at 12:00:00 every day.
                .withSchedule(simpleSchedule()
                    .withIntervalInHours(24)
                    .repeatForever())
                .build();

        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        scheduler.start();
        scheduler.scheduleJob(jobDetail, trigger);
    }
    
}
