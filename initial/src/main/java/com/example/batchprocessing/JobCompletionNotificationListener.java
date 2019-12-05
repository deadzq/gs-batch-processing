package com.example.batchprocessing;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 * What's this Class use to?
 * The last bit of batch configuration is a way to get notified
 * when the job completes.
 *
 * This Class listens for when a job is BatchStatus.COMPLETED
 * and then uses JdbcTemplate to inspect the results.
 */
@Component
public class JobCompletionNotificationListener extends JobExecutionListenerSupport {

    private static final Logger log = LoggerFactory.getLogger(JobCompletionNotificationListener.class);

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JobCompletionNotificationListener(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void afterJob(JobExecution jobExecution){
        if(jobExecution.getStatus()==BatchStatus.COMPLETED){
            log.info("!!!Job Finished! Time to verify the results");

            jdbcTemplate.query("SELECT first_name,last_name FROM people",
                    (rs,row)-> new Person(
                            rs.getString(1),
                            rs.getString(2)
                    )).forEach(person -> log.info("Found <"+person+"> in the database."));
        }
    }
}
