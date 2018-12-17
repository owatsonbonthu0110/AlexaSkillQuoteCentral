
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
import com.amazon.ask.model.LaunchRequest;
import com.amazon.ask.model.Response;
import static com.amazon.ask.request.Predicates.requestType;

/**
 * The LaunchRequestHandler class is invoked when the skill receives a LaunchRequest. 
 * The LaunchRequest event occurs when the skill is invoked without a specific intent.
 */
public class LaunchRequestHandler implements RequestHandler  {
	//Data Encapsulation
	/**
	 * This will be the response speech for the LaunchRequestHandler when user needs it.
	 */
	protected String speechText = "Welcome to the Quote Central Skill! You can say, quote teller, tell me a quote, or give me quote.";
	
/**
* canHandle method checks whether that particular handler is the correct handler.
* @param input
* @return boolean true if the correct handler
*/
 public boolean canHandle(HandlerInput input) {
        return input.matches(requestType(LaunchRequest.class));
    }
 /**
 *handle method sends the directions to ALEXA for user.
 *@param input
 *@return input along with Simplecard that displays plain text.
 */
public Optional<Response> handle(HandlerInput input) {
	    return input.getResponseBuilder()
                .withSpeech(speechText) //our speech for our response
                .withSimpleCard("QuoteCentral", speechText)  //Sends back title and body               
                .withReprompt(speechText) //our reprompt speech sent to user
                .build();
    }

}
