package com.ai.spring.ai.client;



import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@ActiveProfiles("openai")
public class MyClientTests {
    @Autowired
    MyClient myClient;

    @Test
    public void testCallFM() {
        String input = "Hello, how are you?";
        String response = myClient.callFM(input);
        assertThat(response).contains("Hello"); // Adjust the assertion based on expected response
        System.out.println("Response from callFM: " + response);
    }
}
