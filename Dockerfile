FROM openjdk:17
COPY "./target/clients-0.0.1-SNAPSHOT.jar" "clients.jar"
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "clients.jar"]