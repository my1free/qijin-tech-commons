package tech.qijin.commons.test.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;
import tech.qijin.commons.test.TestService;

/**
 * 与SampleJob3组成一种方式。这种方式写代码较少
 *
 * @author michealyang
 * @date 2018/11/22
 * 开始做眼保健操：←_← ↑_↑ →_→ ↓_↓
 **/
public class SampleJob4 extends QuartzJobBean {

    @Autowired
    private TestService testService;

    @Override
    protected void executeInternal(JobExecutionContext context) {
        testService.sayHello("job4");
    }
}
