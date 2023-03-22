FROM maven:3.8.6-jdk-8 AS build
COPY . .
RUN mvn clean package -Pprod -DskipTests


FROM openjdk:8-jdk-slim
COPY --from=build /target/covid.jar covid.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "pgsenpa.jar"]