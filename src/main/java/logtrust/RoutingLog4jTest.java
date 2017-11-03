package logtrust;

import org.apache.logging.log4j.ThreadContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

public class RoutingLog4jTest {



  static Logger logger = LoggerFactory.getLogger(RoutingLog4jTest.class);

  public static void main( String[] args ){

    ThreadContext.put("user"  , "usuario");
    ThreadContext.put("domain", "dominio");
    ThreadContext.put("cid"   , "000013FFF");


    Random random = new Random();
    int count = 1;
    if (args.length > 0){
      count = Integer.parseInt(args[0]);
    }

    for (int i = 0; i < count; i++) {
      logger.info("Logging {} of {} random value {}", i+1,count,  random.nextLong());
    }

    ThreadContext.clearAll();

  }

}
