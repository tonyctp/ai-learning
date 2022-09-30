package com.ss.crdt.service;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

//@SpringBootTest
public class NLPTransferServiceTest {

	@Test
	public void test_NLP() {
		String content = "I want to know something about financial system";

		List<String> tags = NLPTransferService.getOriginalText(content);
		for (String item : tags) {
			System.out.print("=> " + item);
		}
		assertNotNull(tags);

	}

}
