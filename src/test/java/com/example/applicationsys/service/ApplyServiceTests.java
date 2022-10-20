package com.example.applicationsys.service;

import com.example.applicationsys.dto.Apply;
import com.example.applicationsys.mapper.LectureMapper;
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
    LectureMapper lectureMapper;

    @Test
    public void testCounterWithConcurrency() throws InterruptedException {
        int numberOfThreads = 100;
        ExecutorService service = Executors.newFixedThreadPool(10);
        CountDownLatch latch = new CountDownLatch(numberOfThreads);

        for (int i = 0; i < numberOfThreads; i++) {

            service.execute(() -> {
                Apply apply = Apply.builder()
                        .lectureId(1L)
                        .who("luca@naver.com")
                        .status("cm")
                        .build();
                applyService.apply(apply);
                latch.countDown();
            });
        }
        latch.await();
        assertEquals(20, lectureMapper.findById(1L).getNowPerson());

    }
}
