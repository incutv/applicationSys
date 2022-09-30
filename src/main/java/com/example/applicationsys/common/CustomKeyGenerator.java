package com.example.applicationsys.common;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class CustomKeyGenerator implements KeyGenerator {
    @Override
    public Object generate(Object target, Method method, Object... params) {
        List<String> collect = Streams.ofNullable(params)
                .map(param -> {
                    if (Objects.isNull(param)) {
                        return "";
                    }
                    return String.valueOf(param.hashCode());
                })
                .collect(Collectors.toList());

        String join = String.join("-", collect);
        return target.hashCode() + method.getName() + join;

    }

}
