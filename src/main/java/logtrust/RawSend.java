package logtrust;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.appender.SyslogAppender;
import org.apache.logging.log4j.core.config.Configurator;

/**
 * Created by joaquindiez on 27/8/15.
 */
public class RawSend {

    public static void main( String[] args )
    {
        String displayname ="displayname";


        String configLocation = "log4j2.xml";
        LoggerContext context =  Configurator.initialize(
                displayname,
                configLocation);


       Logger logger =  context.getLogger("RawSend");


        logger.info("Test Raw Send");

    }
}
