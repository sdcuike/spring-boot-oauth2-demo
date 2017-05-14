package com.sdcuike.practice.config;

import liquibase.exception.LiquibaseException;
import liquibase.integration.spring.SpringLiquibase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.core.task.TaskExecutor;
import org.springframework.util.StopWatch;

/**
 * Created by beaver on 2017/4/28.
 */
public class AsyncSpringLiquibase extends SpringLiquibase {
    
    // named "logger" because there is already a field called "log" in "SpringLiquibase"
    private final Logger logger = LoggerFactory.getLogger(getClass());
    
    private final TaskExecutor taskExecutor;
    
    private final Environment env;
    
    public AsyncSpringLiquibase(@Qualifier("taskExecutor") TaskExecutor taskExecutor, Environment env) {
        this.taskExecutor = taskExecutor;
        this.env = env;
    }
    
    @Override
    public void afterPropertiesSet() throws LiquibaseException {
        taskExecutor.execute(() -> {
            
            try {
                logger.warn("Starting Liquibase asynchronously, your database might not be ready at startup!");
                initDb();
            } catch (LiquibaseException e) {
                logger.error("Liquibase could not start correctly, your database is NOT ready: {}",
                        e.getMessage(), e);
            }
            
        });
    }
    
    protected void initDb() throws LiquibaseException {
        StopWatch watch = new StopWatch();
        watch.start();
        super.afterPropertiesSet();
        watch.stop();
        logger.debug("Started Liquibase in {} ms", watch.getTotalTimeMillis());
    }
}
