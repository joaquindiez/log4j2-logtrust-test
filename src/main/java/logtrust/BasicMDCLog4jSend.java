package logtrust;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;

import java.util.Random;

/**
 * Created by joaquindiez on 27/8/15.
 */
public class BasicMDCLog4jSend {

    private static final Logger logger = LogManager.getLogger("TestMDC");

    public static void main( String[] args )
    {
        Random random = new Random();
        int count = 10;
        if (args.length > 0){
            count = Integer.parseInt(args[0]);
        }
        ThreadContext.put("USER", "usuario");


        for (int i = 0; i < count; i++) {
            String user = "user_" + random.nextLong();
            //Envio Usando una cadena de forma normal
            logger.info("Logging {} of {} random value {}", i+1,count,  user);
        }
        ThreadContext.clearAll();

    }
}
