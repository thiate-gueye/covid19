FROM maven:3.8.6-jdk-8 AS build
COPY . .
RUN mvn clean package


FROM openjdk:8-jdk-slim
COPY --from=build /target/covid19-0.0.1-SNAPSHOT.jar covid.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "covid.jar"]