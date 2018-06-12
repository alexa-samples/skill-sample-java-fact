package com.amazon.ask.airplanefacts.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;

import java.util.Optional;

import static com.amazon.ask.request.Predicates.intentName;

public class CancelandStopIntentHandler implements RequestHandler {
    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(intentName("AMAZON.StopIntent").or(intentName("AMAZON.CancelIntent")).or(intentName("AMAZON.NoIntent")));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {
        String speechText = "Goodbye. Come back soon to hear an airplane fact";
        return input.getResponseBuilder()
                .withSpeech(speechText)
                .withSimpleCard("Airplane Facts", speechText)
                .build();
    }
}
