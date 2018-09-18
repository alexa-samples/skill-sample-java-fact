package com.amazon.ask.airplanefacts;

import com.amazon.ask.Skill;
import com.amazon.ask.Skills;
import com.amazon.ask.SkillStreamHandler;
import com.amazon.ask.airplanefacts.handlers.*;

public class AirplaneFactsStreamHandler extends SkillStreamHandler {

    private static Skill getSkill() {
        return Skills.standard() 
                .addRequestHandlers(
                        new CancelandStopIntentHandler(),
                        new FactIntentHandler(),
                        new HelpIntentHandler(),
                        new LaunchRequestHandler(),
                        new SessionEndedRequestHandler(),
                        new FallBackIntentHandler())
                // Add your skill id below and uncomment to enable skill ID verification
                // .withSkillId("")
                .build();
    }

    public AirplaneFactsStreamHandler() {
        super(getSkill());
    }

}
