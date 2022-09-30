package com.example.applicationsys;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Component;


@Slf4j
@Component
public class CacheManagerCheck implements CommandLineRunner {

    @Autowired
    CacheManager cacheManager;

    @Override
    public void run(String... strings) throws Exception {
        log.info("\n\n" + "=========================================================\n"
                + "Using cache manager: " + this.cacheManager.getClass().getName() + "\n"
                + "=========================================================\n\n");
    }

}
