FROM maven:3.8.6-jdk-8 AS build
COPY . .
RUN mvn clean package -Pprod -DskipTests


FROM openjdk:8-jdk-alpine
COPY --from=build /target/covid19-0.0.1-SNAPSHOT.jar covid.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "covid.jar"]