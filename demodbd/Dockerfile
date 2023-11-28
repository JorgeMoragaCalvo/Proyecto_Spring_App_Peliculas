FROM openjdk:17
ARG JAR_FILE=target/demodbd-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} demodbd-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/demodbd-0.0.1-SNAPSHOT.jar"]