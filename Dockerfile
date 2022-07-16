FROM openjdk:17-jdk-alpine
MAINTAINER company.com
VOLUME /tmp
EXPOSE 8080
ADD target/Fast-Runner-0.0.1-SNAPSHOT.war Fast-Runner.war
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/Fast-Runner.war"]