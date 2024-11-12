package com.example.test;

import com.example.test.sample.Restaurant;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class TestApplicationTests {
	// Logger 생성
	private static final Logger logger = LoggerFactory.getLogger(TestApplicationTests.class);

	@Autowired
	private Restaurant restaurant;

	@Test
	void contextLoads() {

		assertNotNull(restaurant);
		// 로그 출력
		logger.info(String.valueOf(restaurant));
		logger.info(String.valueOf(restaurant.getChef()));

		// 테스트에서 추가적인 로그 예시
		logger.debug("This is a debug level log");
		logger.warn("This is a warning level log");
		logger.error("This is an error level log");

		// 여기에 추가적인 테스트 로직을 작성할 수 있습니다.
	}

}
