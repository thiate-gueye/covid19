FROM openjdk:8-jdk-slim
COPY --from=build /target/covid19-0.0.1-SNAPSHOT.jar covid.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "covid.jar"]