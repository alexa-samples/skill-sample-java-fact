package com.amazon.ask.airplanefacts.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.LaunchRequest;
import com.amazon.ask.model.Response;
import com.amazon.ask.model.interfaces.display.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.amazon.ask.request.Predicates.requestType;

public class LaunchRequestHandler implements RequestHandler {

    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(requestType(LaunchRequest.class));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {

        String title = "Airplane Facts";
        String primaryText = "Welcome to Airplane Facts.";
        String secondaryText = "Would you like to hear an airplane fact?";
        String speechText = "Welcome to Airplane Facts. I can tell you facts about popular airplanes. Would you like to hear an airplane fact?";
        //FIXME Replace below with the appropriate url for the background image
        String imageUrl = "https://s3.amazonaws.com/ask-samples-resources/background-image.jpg";

        Image image = getImage(imageUrl);

        Template template = getBodyTemplate6(primaryText, secondaryText, image);

        // Device supports display interface
        if(null!=input.getRequestEnvelope().getContext().getDisplay()) {
            return input.getResponseBuilder()
                    .withSpeech(speechText)
                    .withSimpleCard(title, speechText)
                    .addRenderTemplateDirective(template)
                    .withReprompt(speechText)
                    .build();
        } else {
            //Headless device
            return input.getResponseBuilder()
                    .withSpeech(speechText)
                    .withSimpleCard(title, speechText)
                    .withReprompt(speechText)
                    .build();
        }
    }

    /**
     * Helper method to create a body template 6
     * @param primaryText the primary text to be displayed in the template on the show
     * @param secondaryText the secondary text to be displayed in the template on the show
     * @param image  the url of the image
     * @return Template
     */
    private Template getBodyTemplate6(String primaryText, String secondaryText, Image image) {
        return BodyTemplate6.builder()
                .withBackgroundImage(image)
                .withTextContent(getTextContent(primaryText, secondaryText))
                .build();
    }

    /**
     * Helper method to create the image object for display interfaces
     * @param imageUrl the url of the image
     * @return Image that is used in a body template
     */
    private Image getImage(String imageUrl) {
        List<ImageInstance> instances = getImageInstance(imageUrl);
        return Image.builder()
                .withSources(instances)
                .build();
    }

    /**
     * Helper method to create List of image instances
     * @param imageUrl the url of the image
     * @return instances that is used in the image object
     */
    private List<ImageInstance> getImageInstance(String imageUrl) {
        List<ImageInstance> instances = new ArrayList<>();
        ImageInstance instance = ImageInstance.builder()
                .withUrl(imageUrl)
                .build();
        instances.add(instance);
        return instances;
    }

    /**
     * Helper method that returns text content to be used in the body template.
     * @param primaryText
     * @param secondaryText
     * @return RichText that will be rendered with the body template
     */
    private TextContent getTextContent(String primaryText, String secondaryText) {
        return TextContent.builder()
                .withPrimaryText(makeRichText(primaryText))
                .withSecondaryText(makeRichText(secondaryText))
                .build();
    }

    /**
     * Helper method that returns the rich text that can be set as the text content for a body template.
     * @param text The string that needs to be set as the text content for the body template.
     * @return RichText that will be rendered with the body template
     */
    private RichText makeRichText(String text) {
        return RichText.builder()
                .withText(text)
                .build();
    }

}
