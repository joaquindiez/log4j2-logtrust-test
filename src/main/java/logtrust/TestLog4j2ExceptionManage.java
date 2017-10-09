package logtrust;


import org.apache.logging.log4j.ThreadContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by joaquindiez on 22/9/16.
 */
public class TestLog4j2ExceptionManage {


  static Logger log = LoggerFactory.getLogger("TestLogs");

  public static void main( String[] args ){
    //System.setProperty("line.separator", " ");

    ThreadContext.put("user"  , "usuario");
    ThreadContext.put("domain", "dominio");
    ThreadContext.put("cid"   , "000013FFF");


    try {
      throwExceptionMethod();
    }catch(Exception e) {
      log.info("Error Mensaje info mensaje.....", e);
    }

    ThreadContext.clearAll();

  }



  private static void throwExceptionMethod() throws Exception{
    throw new Exception("Nueva Excepcion Generada!!!");
  }
}
