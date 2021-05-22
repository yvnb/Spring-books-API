# Spring-books-API
Steps to run the Spring Boot Application
Go to the Project Root directory and run the following commands
# For creating the executable jar file for Spring Boot Application
mvn clean package
# Start the Spring Boot Application
java -jar target/spring-books-service-0.0.1-SNAPSHOT.jar
Now we have a working Spring Boot application that we can access at localhost:8080
# Rest API documentation can be accessed using Swagger Editor
http://localhost:8080/swagger-ui/
# To create an image from our Dockerfile, we have to run ‘docker build'
docker build --tag=spring-book-service:latest .
# To run the container from the image
docker run -p8080:8080 spring-book-service:latest
This will start our application in Docker and we can access it from the host machine at localhost:8080/
