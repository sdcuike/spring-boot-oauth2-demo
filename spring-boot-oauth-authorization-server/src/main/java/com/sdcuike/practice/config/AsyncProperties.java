package com.sdcuike.practice.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by beaver on 2017/4/28.
 */
@ConfigurationProperties(prefix = "async", ignoreUnknownFields = false)
public class AsyncProperties {
    
    private int corePoolSize = 2;
    
    private int maxPoolSize = 50;
    
    private int queueCapacity = 10000;
    
    private String namePrefix = "";
    
    public int getCorePoolSize() {
        return corePoolSize;
    }
    
    public void setCorePoolSize(int corePoolSize) {
        this.corePoolSize = corePoolSize;
    }
    
    public int getMaxPoolSize() {
        return maxPoolSize;
    }
    
    public void setMaxPoolSize(int maxPoolSize) {
        this.maxPoolSize = maxPoolSize;
    }
    
    public int getQueueCapacity() {
        return queueCapacity;
    }
    
    public void setQueueCapacity(int queueCapacity) {
        this.queueCapacity = queueCapacity;
    }
    
    public String getNamePrefix() {
        return namePrefix+"-ThreadPool:";
    }
    
    public void setNamePrefix(String namePrefix) {
        this.namePrefix = namePrefix;
    }
    
    @Override
    public String toString() {
        return "AsyncProperties{" +
                "corePoolSize=" + corePoolSize +
                ", maxPoolSize=" + maxPoolSize +
                ", queueCapacity=" + queueCapacity +
                ", namePrefix='" + namePrefix + '\'' +
                '}';
    }
}
