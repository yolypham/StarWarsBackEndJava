# StarWarsBackEndJava
Java back end REST API with Spring Boot 2
-Stack used: Java 13, Springboot2, JPA, 

## MySQL DB Set up
1. Create local instance connection with default hostname and port
>Hostname: 127.0.0.1 and Port: 3306
2. test db connection
3. cd into projec folder:  /StarWarsBackEndJava 
4. run script in: sql/create-db-script.sql

## Start up back end
1. In Terminal, cd into projec folder:  /StarWarsBackEndJava
2. type: 
>./mvnw
3. Ready... will startup in port 8080
4. Test in the browser
>http://localhost:8080/api/movie?sortBy=STORY
