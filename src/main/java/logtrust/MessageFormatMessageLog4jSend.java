package logtrust;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;
import org.apache.logging.log4j.message.MessageFormatMessage;
import org.apache.logging.log4j.message.StructuredDataMessage;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Hello world!
 *
 */
public class MessageFormatMessageLog4jSend
{

    private static final Logger logger = LogManager.getLogger("HelloWorld");

    public static void main( String[] args )
    {
        Random random = new Random();
        int count = 1;
        if (args.length > 0){
            count = Integer.parseInt(args[0]);
        }

        for (int i = 0; i < count; i++) {
            String user = "user_" + random.nextLong();

            //Envio Usando MessageFormatMessage
            MessageFormatMessage msg0 = new MessageFormatMessage("Logging  {0} of {1} random value {2}", i+1, count, user);
            logger.info(msg0);


        }

    }
}
