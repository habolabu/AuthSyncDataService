package edu.ou.authsyncdataservice;

import edu.ou.coreservice.annotation.BaseSyncDataAnnotation;
import org.springframework.boot.SpringApplication;

@BaseSyncDataAnnotation
public class AuthSyncDataServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthSyncDataServiceApplication.class, args);
    }
}
