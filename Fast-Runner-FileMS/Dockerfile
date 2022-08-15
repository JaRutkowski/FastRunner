FROM openjdk:17-jdk-alpine
MAINTAINER company.com
VOLUME /tmp
EXPOSE 8081
ADD target/Fast-Runner-FileMS-0.0.1-SNAPSHOT.war Fast-Runner-FileMS.war
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/Fast-Runner-FileMS.war"]