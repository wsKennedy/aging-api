FROM openjdk:8-jdk-alpine

ENV PORT 8080

EXPOSE ${PORT}

COPY ${pwd}/aging-api/build/libs/*.jar app.jar

ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=dev", "app.jar"]
