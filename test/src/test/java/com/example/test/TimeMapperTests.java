package com.example.test;

import com.example.test.mapper.TimeMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class TimeMapperTests {

    @Autowired
    private TimeMapper timeMapper;

    @Test
    public void testTime1(){
        log.info(timeMapper.getTime());
    }

    @Test
    public void testTime2(){
        log.info(timeMapper.getTIme2());
    }
}
