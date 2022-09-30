package com.example.applicationsys.controller;

import com.example.applicationsys.dto.Notice;
import com.example.applicationsys.dto.Response;
import com.example.applicationsys.service.NoticeService;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;
import org.springframework.cache.CacheManager;
import org.springframework.cache.ehcache.EhCacheCache;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
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
    public Response<Object> findAll(HttpServletRequest request){
        List<Map<String, String>> result = new ArrayList<>();
        /*for (String cacheName : cacheManager.getCacheNames()) {
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
                .url(request.getRequestURI())
                .build();
    }
}
