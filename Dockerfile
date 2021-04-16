FROM openjdk:16
ADD target/spring-boot-swagger-application-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]