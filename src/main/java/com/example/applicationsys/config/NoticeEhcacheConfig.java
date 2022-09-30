package com.example.applicationsys.config;


import org.springframework.cache.annotation.EnableCaching;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.config.CacheConfiguration;
import net.sf.ehcache.config.Configuration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

@EnableCaching
@org.springframework.context.annotation.Configuration
public class NoticeEhcacheConfig {
    @Bean(destroyMethod = "shutdown")
    public CacheManager makeEhcacheManager(){
        Configuration config = new Configuration();
        config.setName("__meeting");

        config.addCache(getCacheConfiguration("findAll",60*10));
        return CacheManager.newInstance(config);
    }

    private CacheConfiguration getCacheConfiguration(String name , long second){
        return getCacheConfiguration(name ,second , 100L);
    }

    private CacheConfiguration getCacheConfiguration(String name , long second , long size){
        CacheConfiguration cacheConfiguration = new CacheConfiguration();
        cacheConfiguration.setName(name);
        cacheConfiguration.setMemoryStoreEvictionPolicy("LRU");
        cacheConfiguration.setMaxEntriesLocalHeap(size);
        cacheConfiguration.setTimeToLiveSeconds(second);
        cacheConfiguration.setTimeToIdleSeconds(0L);

        return cacheConfiguration;
    }
}
