

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
 * The CancelandStopIntentHandler class responds to two different intents, Amazon.CancelIntent and Amazon.StopIntent.
 */
public class CancelandStopIntentHandler implements RequestHandler {
	//Data Encapsulation
	/**
	 * the intent name
	 */
	protected String skillIntentName1 = "AMAZON.StopIntent";
	/**
	 * the intent name
	 */
	protected String skillIntentName2 = "AMAZON.CancelIntent";
	/**
	 *Speech for the response for the stop and cancel intent
	 */
	protected String speechText = "Thank you for trying the quote central skill, GoodBye."; 
	
/**
 * canHandle method detects if the incoming request is an IntentRequest
 * <p> returns true if the intent name is "AMAZON.StopIntent" or "AMAZON.CancelIntent".
 * A response is then generated and returned.
 * @param input
 * @return boolean intent name matches
 */
 public boolean canHandle(HandlerInput input) {
        return input.matches(intentName(skillIntentName1).or(intentName(skillIntentName2)));
    }
 /**
  *handle method sends the help or stop directions to ALEXA.
  *@param input
  *@return input
  */
public Optional<Response> handle(HandlerInput input) {
             return input.getResponseBuilder()
                .withSpeech(speechText)  //our speech for our response
                .withSimpleCard("QuoteCentral", speechText)  //Sends back title and body
                .build();
    }

}