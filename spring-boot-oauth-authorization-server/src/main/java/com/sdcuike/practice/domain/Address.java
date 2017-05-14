package com.sdcuike.practice.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

@Data
@NoArgsConstructor
public class Address {
    private Long addrId;
    
    private String street;
    
    private String city;
    
    private String state;
    
    private String zip;
    
    private String country;
    
    public static void main(String[] args) throws InterruptedException {
        CompletableFuture.supplyAsync(()-> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName());
            return  8;
        }).thenApplyAsync( t -> {
            System.out.println(Thread.currentThread().getName());
            return  t*t;
        })
        .thenAccept(t ->{
            System.out.println(Thread.currentThread().getName());
            System.out.println(t);
        });
        
        System.out.println("main");
        TimeUnit.HOURS.sleep(1L);
    }
    
    
}