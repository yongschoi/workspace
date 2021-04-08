FROM openjdk:11.0.4-jre-slim-buster

ARG FILENAME
ADD $FILENAME.jar service.jar
ENV JAVA_OPTS=""
ENTRYPOINT ["java","-jar","/service.jar"]

