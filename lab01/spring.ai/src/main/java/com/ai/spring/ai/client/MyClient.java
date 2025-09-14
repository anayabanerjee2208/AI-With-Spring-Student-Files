package com.ai.spring.ai.client;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("openai")
public class MyClient {

    private final ChatClient chatClient;

    public MyClient(ChatModel model) {
        chatClient = ChatClient.builder(model).build();
    }
    public String callFM(String input){
        return chatClient
                .prompt()
                .user(input)
                .call()
                .content();
    }
}