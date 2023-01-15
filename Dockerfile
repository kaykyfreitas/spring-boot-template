FROM openjdk:17

WORKDIR /app

COPY target/*.jar /app/application.jar

EXPOSE 8080

ENTRYPOINT [ "java", "-jar", "application.jar" ]

