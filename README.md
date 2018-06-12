# Alexa Skills Kit SDK Sample - Airplane Facts
An Alexa Skill Sample to demonstrate how to write skills for Echo Show and Echo Spot in Java using the Alexa Skills Kit (ASK) SDK v2.

## Concepts
This sample shows how to write Alexa skills that:

- Support display templates with graphical components such as text, images etc. to complement voice experience on Echo Show and Echo Spot.

## Setup
To run this example skill you need to do two things. The first is to deploy the example code in lambda, and the second is to configure the Alexa skill to use Lambda.

### AWS Lambda Setup
Refer to [Hosting a Custom Skill as an AWS Lambda Function](https://developer.amazon.com/docs/custom-skills/host-a-custom-skill-as-an-aws-lambda-function.html) reference for a walkthrough on creating a AWS Lambda function with the correct role for your skill. When creating the function, select the “Author from scratch” option, and select the Java 8 runtime. 

Next, open a terminal and go to the directory containing pom.xml, and run 'mvn assembly:assembly -DdescriptorId=jar-with-dependencies package'. This will generate a zip file named "airplanefacts-1.0-jar-with-dependencies.jar" in the target directory.

Once you've created your AWS Lambda function and configured “Alexa Skills Kit” as a trigger, upload the JAR file produced in the previous step and set the handler to the fully qualified class name of your handler function. Finally, copy the ARN for your AWS Lambda function because you’ll need it when configuring your skill in the Amazon Developer console.

### Alexa Skill Setup
Now that the skill code has been uploaded to AWS Lambda we're ready to configure the skill with Alexa. First, navigate to the [Alexa Skills Kit Developer Console](https://developer.amazon.com/alexa/console/ask). Click the “Create Skill” button in the upper right. Enter “Airplane Facts” as your skill name. On the next page,  select “Custom” and click “Create skill”.
 
Now we're ready to define the interaction model for the skill. Under “Invocation” tab on the left side, define your Skill Invocation Name to be `airplane facts`. 
 
Now it’s time to add an intent to the skill. Click the “Add” button under the Intents section of the Interaction Model. Leave “Create custom intent” selected, enter “FactIntent” for the intent name, and create the intent. Now it’s time to add some sample utterances that will be used to invoke the intent. For this example, we’ve provided the following sample utterances, but feel free to add others. 

```
tell me a fact
tell me recent airplane fact
tell me new airplane fact
airplane fact please
i want to hear airplane fact
i want to hear an airplane fact
give airplane fact
give me airplane fact
tell me airplane fact
read me an airplane fact
read airplane fact
tell me an airplane fact
airplane fact
fact
```

Since AMAZON.YesIntent, AMAZON.NoIntent, AMAZON.CancelIntent, AMAZON.HelpIntent, and AMAZON.StopIntent are built-in Alexa intents, sample utterances do not need to be provided as they are automatically inherited.

Click on the `Interfaces` tab and make sure you select Display Interface since you will be using Display Templates.

The Developer Console alternately allows you to edit the entire skill model in JSON format by selecting “JSON Editor” on the navigation bar. For this sample, [this JSON schema](models/en-US.json) can be used.

Once you’re done editing the interaction model don't forget to save and build the model.
 
Let's move on to the skill configuration section. Under “Endpoint” select “AWS Lambda ARN” and paste in the ARN of the function you created previously. The rest of the settings can be left at their default values. Click “Save Endpoints” and proceed to the next section.
 
Finally you're ready to test the skill! In the “Test” tab of the developer console you can simulate requests, in text and voice form, to your skill. Use the invocation name along with one of the sample utterances we just configured as a guide. You should also be able to go to the [Alexa webpage](https://alexa.amazon.com/#skills) and see your skill listed under “Your Skills”, where you can enable the skill on your account for testing from an Alexa enabled device.
 
At this point, feel free to start experimenting with your Intent Schema as well as the corresponding request handlers in your skill's implementation.

## Examples
### One-shot model:
    User: "Alexa, ask airplane facts for an airplane fact."
    Alexa: "As of 31 March 2018, a total of 8,074 Airbus A320-family aircraft have been delivered, of which 7,722 are in service."