FROM openjdk:17-jdk-alpine
VOLUME /tmp
ADD target/* .jar app.jar
CMD ["java","-jar","app.jar","--spring.profiles.active=prod"]
EXPOSE 8080
