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

 keytool -importcert -keystore truststore.jks -file Downloads/chainca0.crt -alias userca
 keytool -importcert -keystore truststore.jks -file Downloads/chainca1.crt -alias ca