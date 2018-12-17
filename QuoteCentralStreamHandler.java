/**
The stream handler is the entry point for my AWS Lambda function. Every request made by an end user to 
Alexa which invokes my skill will pass through this class, into the configured Skill instance, 
and then be forwarded to the handler appropriate for the request. 
The following QuoteCentralStreamHandler creates an SDK Skill instance configured with the request handlers.
 */
package com.main;

/**
 * @author Olivia Watson-Bonthu	
 * @author Michael Gipson
 * @Date 12/3/2018
 * @Note Alexa SKill Project
 */
import com.amazon.ask.Skill;
import com.amazon.ask.SkillStreamHandler;
import com.amazon.ask.Skills;
import com.quotecentral.handlers.CancelandStopIntentHandler;
import com.quotecentral.handlers.QuoteCentralIntentHandler;
import com.quotecentral.handlers.HelpIntentHandler;
import com.quotecentral.handlers.LaunchRequestHandler;
import com.quotecentral.handlers.SessionEndedRequestHandler;

public class QuoteCentralStreamHandler extends SkillStreamHandler {
	//Data Encapsulation
	/**
	 * Quote Central Skill ID
	 */
	protected static String amazonSkillID = "amzn1.ask.skill.20c4816b-39f0-47f9-841c-***********"; 
/**
 * The getSkill method creates an SDK instance using the Skills.standard builder. We create instances of our
 * request handlers and register them with our skill with the addRequestHandlers builder method. 
 * @return Skill
 */
 private static Skill getSkill() {
        return Skills.standard()
                .addRequestHandlers(
                        new CancelandStopIntentHandler(), 
                        new QuoteCentralIntentHandler(),
                        new HelpIntentHandler(),
                        new LaunchRequestHandler(),
                        new SessionEndedRequestHandler())
                .withSkillId(amazonSkillID) //contains Quote Central skill id 
                .build();
    }

 /**
  * QuoteCentralStreamHandler constructor passes the constructed Skill instance to the constructor 
  * for the superclass SkillStreamHandler
  */
public QuoteCentralStreamHandler() {
        super(getSkill());
    }

}