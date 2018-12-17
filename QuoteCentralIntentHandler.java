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
import static com.amazon.ask.request.Predicates.intentName;
/**
 * The QuoteCentralIntentHandler gets a random quote and returns to the user.
 */
public class QuoteCentralIntentHandler implements RequestHandler {
	//Data Encapsulation
	/**
	 * holds the random quote sent for the skill
	 */
	protected String quote;
	/**
	 * intent name
	 */
	protected String skillIntentName = "QuoteCentralIntent";
	/**
	 * speech response
	 */
	protected String speechText = "Here's your quote.";
	/**
	 * audio file according to Alexa SKills standard
	 */
	protected String audioFile1 = "<audio src ='https://s3.amazonaws.com/silver-giggle-bucket/Bpm095_F%23m_SpaceWasteland_Pad_firstfile.mp3'/>";
	/**
	 * String [] that contains quotes for our skill with different voices, attached short clip audio using SSML tags.
	 */
	protected final String[] COOL_QUOTES = new String[]{
			
		"<voice name = \"Joey\"> Just because something doesn’t do what you planned it to do, doesn’t mean it’s useless. By Thomas Edison.</voice>"+
		(audioFile1),
		
    	" <voice name = \"Matthew\"> One machine can do the work of fifty ordinary men." +
    	" No machine can do the work of one extraordinary man. By Elbert Hubbard.</voice>"+
    	(audioFile1),
    	
    	"<voice name = \"Brian\"> Tell me and I forget. Teach me and I remember. Involve me and I learn. By Benjamin Franklin.</voice>"+
    	(audioFile1),
    	
    	"<voice name = \"Matthew\"> It does not matter how slowly you go as long as you do not stop. By Confucius.</voice>" + 
    	(audioFile1),
    	
    	"<voice name = \"Kendra\"> Set your goals high, and dont stop till you get there. By Bo Jackson.</voice>" +
    	(audioFile1),
    	
    	"<voice name = \"Joey\"> Our greatest weakness lies in giving up. The most certain way to succeed is always to " +
    	"try just one more time. By Thomas Edison.</voice>" +
    	(audioFile1),	
    	
    	"<voice name = \"Matthew\"> If you can dream it, you can do it. By Walt Disney.</voice>" +
    	(audioFile1),
    	
    	"<voice name = \"Brian\"> You cannot cross the sea merely by standing and staring at the water. By Rabindranath Tagore.</voice>" +
    	(audioFile1),
    	
    	"<voice name = \"Joey\"> If you want to conquer fear, dont sit at home and think about it. Go out and get busy. By Dale Carnegie.</voice>" +
    	(audioFile1),
    	
    	"<voice name = \"Matthew\"> The secret of getting ahead is getting started. By Mark Twain.</voice>" +
    	(audioFile1),
    	
    	"<voice name = \"Brian\"> Without hard work, nothing grows but weeds. By Gordon B. Hinckley.</voice>" +
    	(audioFile1),
    	
    	"<voice name = \"Joey\"> Quality is not an act, it is a habit. By Aristotle.</voice>" +
    	(audioFile1),
    	
    	"<voice name = \"Matthew\"> Start where you are. Use what you have. Do what you can. By Arthur Ashe.</voice>" +
    	(audioFile1),
    			
    	"<voice name = \"Brian\"> What you do today can improve all your tomorrows. By Ralph Marston.</voice>" +
    	(audioFile1),
    	
    	"<voice name = \"Joey\"> Dont watch the Clock. Do what it does. Keep going. By Sam Levenson.</voice>" +
    	(audioFile1),
    	
    	"<voice name = \"Matthew\"> Aim for the moon. If you miss, you may hit a star. By W. Clement Stone.</voice>" +
    	(audioFile1)
    	};

	
/**
 * The canHandle method detects if the incoming request is an IntentRequest, 
 * and returns true if the intent name is QuoteCentralIntent.
 * @param input
 * @return boolean true if the correct handler
 */
 public boolean canHandle(HandlerInput input) {
        return input.matches(intentName(skillIntentName));
       }
 /**
  *handle method sends random quote response.
  *@param input
  *@return input
  */
 public Optional<Response> handle(HandlerInput input) {
		speechText += getQuote();
			    return input.getResponseBuilder()
                .withSpeech(speechText) //our speech for our response
                .withSimpleCard("QuoteCentral", speechText) //Sends back title and body
                .build();
 		}
/**
 * getQuote method generates a random quote from the String[] COOL_QUOTES.
 * @return String random quote
 */
 public String getQuote() {
	 		//Generate a random quote to send back as our QuoteCentralIntent response
			int quoteIndex = (int) Math.floor(Math.random() * COOL_QUOTES.length);
			this.quote = COOL_QUOTES[quoteIndex];
			return quote;
 		}

}