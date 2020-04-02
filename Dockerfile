FROM openjdk:13
ADD target/starwars-service.jar starwars-service.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "starwars-service.jar"]