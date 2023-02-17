package com.example.applicationsys.controller;

import com.example.applicationsys.dto.Response;
import org.springframework.cache.CacheManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/api/ehcache")
public class EhcacheController {
    private CacheManager cacheManager;

    public EhcacheController(CacheManager cacheManager)
    {
        this.cacheManager = cacheManager;
    }

    @GetMapping("/all")
    public Response<Object> findAll(){
        List<Map<String, String>> result = new ArrayList<>();

        System.out.println();

        /*
        cacheName의 데이터를 까볼 수 있습니다.
        for (String cacheName : cacheManager.getCacheNames()) {
            EhCacheCache cache = (EhCacheCache) cacheManager.getCache(cacheName);
            Ehcache ehcache = cache.getNativeCache();
            for (Object key : ehcache.getKeys()) {
                Element element = ehcache.get(key);
                if (element != null) {
                    result.add(Map.of(cacheName, element.toString()));
                }
            }
        }*/

        return Response.builder()
                .data(cacheManager.getCacheNames())
                .message("ehcache find All")
                .build();
    }
}
