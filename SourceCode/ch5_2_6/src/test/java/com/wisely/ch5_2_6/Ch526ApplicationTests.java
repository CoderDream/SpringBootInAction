package com.wisely.ch5_2_6;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;

import com.wisely.ch5_2_6.Ch526Application;

import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Ch526Application.class)
@WebAppConfiguration
public class Ch526ApplicationTests {

	@Test
	public void contextLoads() {
	}

}
