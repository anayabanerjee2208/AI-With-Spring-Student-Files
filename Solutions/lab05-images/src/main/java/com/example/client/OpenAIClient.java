package com.example.client;

import org.springframework.ai.image.ImageModel;
import org.springframework.ai.image.ImagePrompt;
import org.springframework.ai.image.ImageResponse;
import org.springframework.ai.openai.OpenAiImageOptions;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

//  TODO-04: Use a stereotype annotation to mark this class as a Spring bean.
//  Provide an explicit bean name to avoid naming conflicts with internal SpringAI beans.
@Component("openAIClientBean")
@Profile("openai")
public class OpenAIClient implements AIClient {

    //  TODO-05: Define a private final field named "model" of type ImageModel.
    //   Define a constructor which dependency injects this field:
    private final ImageModel model;
    public OpenAIClient(ImageModel model) {
        this.model = model;
    }

    private static final OpenAiImageOptions DEFAULT_OPTIONS = OpenAiImageOptions.builder().N(1).build();

    public String createImageUrl(String request) {

        //  TODO-06: Create an ImagePrompt object using the request and the DEFAULT_OPTIONS:
        //  (Feel free to experiment with your own custom-defined OpenAiImageOptions later).
        ImagePrompt prompt = new ImagePrompt(
                request,
                DEFAULT_OPTIONS
            );

        //  TODO-07: Create a variable of type ImageResponse.
        //   Populate it by calling model.call(), passing the prompt you've just created:
        ImageResponse response = model.call(prompt);

        //  TODO-08: Remove the "return null;" line.
        //  Return the URL String from the previous call.
        //  It can be found by traversing the result / output.
        //  Organize your imports and save your work:
        return response.getResult().getOutput().getUrl();
        // return null;

    }



    public String createImageB64(String request) {

        //  TODO-13 (Optional): Create an OpenAiImageOptions object named B64_OPTIONS.
        //  Use the builder pattern to set  "responseFormat" to "b64_json" (Base-64 encoded String):
        OpenAiImageOptions B64_OPTIONS = OpenAiImageOptions.builder().responseFormat("b64_json").build();

        //  TODO-14 (Optional): Using your earlier code as a guide, create an
        //  ImagePrompt object using the request and the B64_OPTIONS:
        ImagePrompt prompt = new ImagePrompt(
                request,
                B64_OPTIONS
        );

        //  TODO-15 (Optional): Using your earlier code as a guide, create a variable of type ImageResponse.
        //  Populate it by calling model.call(), passing the prompt you've just created.
        ImageResponse response = model.call(prompt);

        //  TODO-16 (Optional): Remove the "return null;" line.
        //  Using your earlier code as a guide, return the Base-64 encoded String from the previous call.
        //  Organize your imports and save your work.
        return response.getResult().getOutput().getB64Json();
        // return null;

    }


}
