# log4j2-logtrust-test
Test de integración de Log4j2 para que envie los logs a Logtrust


Para ejecutar cada unas de las clases es necesario añadir a los paramentros de la VM la localizacion de los keystore y truststore asi como sus claves

Sample:

<pre><code>
 -Dtruststore=/Users/joaquindiez/truststore.jks
 -DtruststorePwd=changeit
 -Dkeystore=/Users/joaquindiez/mydomainInlogtrust.jks
 -DkeystorePwd=23423
</pre></code>

Para simplicarlo en el ejemplo se ha creado un fichero credentials donde se pueden meter esos datos para que los script de test los utilicen directamente

Sample file credendials:

<pre><code>
 TRUSTSTORE=/Users/joaquindiez/truststore.jks
 TRUSTSTOREPWD=changeit
 KEYSTORE=/Users/joaquindiez/mydominioenlogtrust.jks
 KEYSTOREPWD=90900
</pre></code>


El KeyStore se descarga de la Aplicación de Logtrust, Administracion -> Credentials -> x.509 Certificates

El trustStore, se puede utilizar el que viene en el proyecto en main/resources/truststore.jks o bien generarlo usando los fichero chain.crt que se pueden descargar
de la página  Administracion -> Credentials -> x.509 Certificates


 keytool -importcert -keystore truststore.jks -file Downloads/chain.crt -alias userca


AVISO!!!
========

chain.cert contiene 2 certificados si se edita se pueden separar en 2 ficheros independientes (chainca0.crt, chainca1.crt ) y añadirlo al mismo truststore.jks


<pre><code>
 keytool -importcert -keystore truststore.jks -file Downloads/chainca0.crt -alias userca
 keytool -importcert -keystore truststore.jks -file Downloads/chainca1.crt -alias ca
 </pre></code>

 Compilación y Uso
 =================

 Compila con maven
<pre><code>
mvn clean install
</pre></code>

En target genera un fichero log4j2-logtrust-test-bin.tar,  descomprimelo

<pre><code>
tar xvf log4j2-logtrust-test-bin.tar
cd log4j2-logtrust-test
</pre></code>

Edita el fichero credentials y pon los valores adecuados para los certificados y sus claves.

## Nombre Tabla de Logtrust 

Si estas familiarizado con Logtrust, sabrás que los Logs se asocian a un identificador de tabla que tiene el formato my.app.XXX.YYYY

Donde XXX y YYY son dos etiquetas cuyo valor tu decides

En log4j2.xml, veras que se ha configurado el appName como

<pre><code>
 appName="my.app.log4j2.test:"
</pre></code>


Pon el nombre que desees, pero RESPETA el prefijo my.app.   y el caracter ":"  final!!





