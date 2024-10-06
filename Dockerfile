FROM openjdk:17-jdk-alpine

WORKDIR /aplicación

COPY target/app-inditex-1.0.0-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
