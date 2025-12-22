package com.lblandi.itemms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ItemMsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ItemMsApplication.class, args);
    }

}
