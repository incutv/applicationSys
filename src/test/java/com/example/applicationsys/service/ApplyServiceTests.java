package com.example.applicationsys.service;

import com.example.applicationsys.dto.Apply;
import com.example.applicationsys.mapper.read.LectureReadMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ApplyServiceTests {

    @Autowired
    ApplyService applyService;

    @Autowired
    LectureReadMapper lectureReadMapper;

    @Test
    public void testCounterWithConcurrency() throws InterruptedException {
        int numberOfThreads = 100;
        ExecutorService service = Executors.newFixedThreadPool(100);
        CountDownLatch latch = new CountDownLatch(numberOfThreads);

        for (int i = 0; i < numberOfThreads; i++) {
            service.execute(() -> {
                Apply apply = Apply.builder()
                        .lectureId(1L)
                        .who("naver.com")
                        .status("cm")
                        .build();
                applyService.apply(apply);
                latch.countDown();
            });
        }

        latch.await();
        assertEquals(20, lectureReadMapper.findById(1L).getNowPerson());

    }
}
