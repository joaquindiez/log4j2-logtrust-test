package logtrust;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.message.StructuredDataMessage;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by joaquindiez on 27/8/15.
 */
public class StructuredDataMessageLog4jSend {

    private static final Logger logger = LogManager.getLogger("StructuredDataMessageLog4jSend");

    public static void main( String[] args )
    {
        Random random = new Random();
        int count = 1;
        if (args.length > 0){
            count = Integer.parseInt(args[0]);
        }

        for (int i = 0; i < count; i++) {
            // Ennvio usando StructuredDataMessage
            Map data = new HashMap<String, String>();
            data.put("i", Integer.toString(i));
            data.put("count", Integer.toString(count));
            data.put("rnd", Long.toString(random.nextLong()));
            StructuredDataMessage msg = new StructuredDataMessage("elid", "un mensaje", "tipo" ,data);
            logger.info(msg);
        }

    }
}
