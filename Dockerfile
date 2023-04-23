# Build a JAR File
FROM maven:3.8.2-jdk-8-slim AS build
WORKDIR /app
COPY . /app/
RUN mvn -f /app/pom.xml clean package

# Create an Image
FROM openjdk:8-jdk-alpine
EXPOSE 8080
COPY --from=build /app/target/java-0.0.1-SNAPSHOT.war app.war
ENTRYPOINT ["sh", "-c", "java -jar app.war"]
