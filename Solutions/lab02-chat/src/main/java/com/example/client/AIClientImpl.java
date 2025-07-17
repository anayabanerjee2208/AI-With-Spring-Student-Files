package com.example.client;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.stereotype.Component;

//  TODO-05: Use a stereotype annotation to mark this class as a Spring bean.

@Component
public class AIClientImpl implements AIClient {
    
    //  TODO-06: Define a private member variable of type ChatClient named client.
    //  Create a constructor for this bean.
    //  Inject a ChatModel object into the constructor.
    //  Pass the model to the ChatClient.builder to build a ChatClient object.
    //  Save the ChatClient object in the client field.
    
    private ChatClient client;
    
    public AIClientImpl(ChatModel model) {
        client = ChatClient.builder(model).build();
    }


    public String callApi(String input ) {

        //  TODO-07: Use the client object to call the API.
        //  .prompt() creates a prompt to pass to the Model.class
        //  .user() sets the "user" message. Pass the input String parameter.
        //  .call() invokes the model.  It returns a CallResponse.
        //  .content() is a simple means of extracting String content from the response. 
        //  Have the method return the content of the response.
        return 
            client
                .prompt()
                .user(input)
                .call()
                .content();
    }

}
