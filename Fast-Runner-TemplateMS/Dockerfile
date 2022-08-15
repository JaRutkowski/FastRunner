FROM openjdk:17-jdk-alpine
MAINTAINER company.com
VOLUME /tmp
EXPOSE 8081
ADD target/Fast-Runner-TemplateMS-0.0.1-SNAPSHOT.war Fast-Runner-TemplateMS.war
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/Fast-Runner-TemplateMS.war"]