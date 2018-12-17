package com.quotecentral.handlers;

/**
 * @author Olivia Watson-Bonthu	
 * @author Michael Gipson
 * @Date 12/3/2018
 * @Note Alexa SKill Project
 */
import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import java.util.Optional;
import static com.amazon.ask.request.Predicates.intentName;

/**
 * THe FallbackIntentHandler helps the user if the user
 * provides utterances that do no match any of our skills intents .
 */
public class FallbackIntentHandler implements RequestHandler {
	//Data Encapsulation
	/**
	 * Response speech for fallback intent
	 */
	protected String speechText = "Sorry, I don't know that. You can say try saying help!";
	/**
	 * the intent name
	 */
	protected String skillIntentName = "AMAZON.FallbackIntent";
/**
 * canHandle method checks whether that particular handler can handle that request.
 * @param input
 * @return boolean
 */
	public boolean canHandle(HandlerInput input) {
        return input.matches(intentName(skillIntentName));
    }
/**
*handle method sends the directions to ALEXA for fallback intent.
*@param input
*@return input
*/
	public Optional<Response> handle(HandlerInput input) {
         return input.getResponseBuilder()
                .withSpeech(speechText) //our speech for our response
                .withSimpleCard("QuoteCentral", speechText) //Sends back title and body
                .withReprompt(speechText) //our reprompt speech sent to user
                .build();
    }

}
