package com.wisely.ch9_2.batch;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

public class CsvJobListener implements JobExecutionListener{ 

    long startTime;
    long endTime;
    @Override
    public void beforeJob(JobExecution jobExecution) {
        startTime = System.currentTimeMillis();
        System.out.println("浠诲姟澶勭悊寮�濮�");
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        endTime = System.currentTimeMillis();
        System.out.println("浠诲姟澶勭悊缁撴潫");
        System.out.println("鑰楁椂:" + (endTime - startTime) + "ms");
    }

}
