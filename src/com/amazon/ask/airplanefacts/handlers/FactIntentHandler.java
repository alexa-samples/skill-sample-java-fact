package com.amazon.ask.airplanefacts.handlers;

import com.amazon.ask.airplanefacts.util.FactsUtil;
import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import com.amazon.ask.model.interfaces.display.*;

import java.util.*;

import static com.amazon.ask.request.Predicates.intentName;

public class FactIntentHandler implements RequestHandler {

    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(intentName("FactIntent").or(intentName("AMAZON.YesIntent")));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {

        Map<String, String> facts = FactsUtil.getFactMap();
        Map<String, String> images = FactsUtil.getImageMap();
        List<String> keys = FactsUtil.getKeys();

        if (keys.size() <= 0) {
            keys = FactsUtil.getKeys();
        }

        int index = new Random().nextInt(keys.size());
        String key = keys.get(index);
        keys.remove(index);

        String title = "Airplane Facts";
        String primaryText = facts.get(key);
        //FIXME: If you would like to display additional text, please set the secondary text accordingly
        String secondaryText = "";
        String speechText = "<speak> " + primaryText + "<break time=\"1s\"/>  Would you like to hear another airplane fact?" + " </speak>";
        String imageUrl = images.get(key);

        Image image = getImage(imageUrl);

        Template template = getBodyTemplate3(title, primaryText, secondaryText, image);

        // Device supports display interface
        if(null!=input.getRequestEnvelope().getContext().getDisplay()) {
            return input.getResponseBuilder()
                    .withSpeech(speechText)
                    .withSimpleCard(title, speechText)
                    .addRenderTemplateDirective(template)
                    .withReprompt(speechText)
                    .build();
        } else {
            // Headless device
            return input.getResponseBuilder()
                    .withSpeech(speechText)
                    .withSimpleCard(title, speechText)
                    .withReprompt(speechText)
                    .build();
        }
    }

    /**
     * Helper method to create a body template 3
     * @param title the title to be displayed on the template
     * @param primaryText the primary text to be displayed on the template
     * @param secondaryText the secondary text to be displayed on the template
     * @param image  the url of the image
     * @return Template
     */
    private Template getBodyTemplate3(String title, String primaryText, String secondaryText, Image image) {
        return BodyTemplate3.builder()
                .withImage(image)
                .withTitle(title)
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
