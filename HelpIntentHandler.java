package com.quotecentral.handlers;

/**
 * @author Olivia Watson-Bonthu	
 * @author Michael Gipson
 * @Date 12/3/2018
 * @Note Alexa SKill Project
 */
import java.util.Optional;
import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import static com.amazon.ask.request.Predicates.intentName;
import com.amazon.ask.model.Response;

/**
 * THe HelpIntentHandler class gives a response to the user if they need help or if a response is needed
 * from the program to the user.
 */
public class HelpIntentHandler implements RequestHandler {
	//Data Encapsulation
	/**
	 * This is the intent name.
	 */
	protected String skillIntentName = "AMAZON.HelpIntent";
	/**
	 * This will be the response speech for the HelpIntent when user needs it.
	 */
	protected String speechText = "You can say quote teller, tell me a quote or, quote teller, get me a quote!";
/**
 * canHandle method checks whether that particular handler is the correct handler.
 * @param input
 * @return boolean true if the correct handler
 */
 public boolean canHandle(HandlerInput input) {
        return input.matches(intentName(skillIntentName));
    }
 /**
 *handle method sends the directions to ALEXA for help intent.
 *@param input
 *@return input along with Simplecard that displays plain text.
 */
public Optional<Response> handle(HandlerInput input) {
		return input.getResponseBuilder()
                .withSpeech(speechText) //our speech for our response
                .withSimpleCard("QuoteCentral", speechText) //Sends back title and body
                .withReprompt(speechText) //our reprompt speech sent to user
                .build();
    }

}