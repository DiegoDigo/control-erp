FROM openjdk:8-alpine

MAINTAINER Diego Delmiro

WORKDIR app

ADD ./target/controlEAD-0.0.1-SNAPSHOT.jar app/

CMD ["java", "-jar", "-Dspring.profiles.active=prod" ,"app/controlEAD-0.0.1-SNAPSHOT.jar"]