#!/bin/bash


source credentials

BASEDIR="$(dirname $0)"
echo "BASEDIR: $BASEDIR"
CLASSPATH=''
EXCLUDEPATH=""
LIBPATH="${BASEDIR}/lib"


# Loading classpath
c=1
for i in `ls $BASEDIR/lib/*.jar`
do
   if [ "$c" -eq "1" ]; then
      CLASSPATH=${i}
      c=2
   else
      CLASSPATH=${CLASSPATH}:${i}
   fi
done


LOG4J2_FILE=log4j2.xml

echo "StructuredDataMessageLog4jSend  using $KEYSTORE"
java -classpath ${CLASSPATH} -Dlog4j.configurationFile=$LOG4J2_FILE  -Dtruststore=$TRUSTSTORE -DtruststorePwd=$TRUSTSTOREPWD -Dkeystore=$KEYSTORE -DkeystorePwd=$KEYSTOREPWD   logtrust.StructuredDataMessageLog4jSend $@


