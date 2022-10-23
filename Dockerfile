FROM openjdk:8u191-jre-alpine3.8

#Create Workspace
WORKDIR /usr/share/udemy

#ADD .jars under target from host into this image
ADD target/selenium-docker.jar       selenium-docker.jar
ADD target/selenium-docker-tests.jar selenium-docker-tests.jar
ADD target/libs                      libs

#Add suite files
ADD book-flight-module.xml book-flight-module.xml
ADD search-module.xml      search-module.xml

# BROWSER
# HUB_HOST
# MODULE

ENTRYPOINT java -cp selenium-docker.jar:selenium-docker-tests.jar:libs/* -DBROWSER=$BROWSER -DHUB_HOST=$HUB_HOST org.testng.TestNG $MODULE
