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
import com.amazon.ask.model.Response;
import com.amazon.ask.model.SessionEndedRequest;
import static com.amazon.ask.request.Predicates.requestType;

/**
 * SessionEndedRequestHandler class
 * handles the session ending when the user makes that request. 
 */
public class SessionEndedRequestHandler implements RequestHandler  {
/**
 * canHandle method checks whether that particular handler handles that request.
 * @param input 
 * @return boolean true id handler matches request type
 */
 public boolean canHandle(HandlerInput input) {
        return input.matches(requestType(SessionEndedRequest.class));
    }
 /**
  *handle method handles session ended.
  *@param input
  *@return nothing is sent back to user. It just handles that the session is ended.
  */
public Optional<Response> handle(HandlerInput input) {
        return input.getResponseBuilder().build();
    }

}