FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY target/giftOrchids-0.0.1-SNAPSHOT.jar giftOrchids-0.0.1-SNAPSHOT.jar
EXPOSE 8080
CMD ["java", "-jar", "giftOrchids-0.0.1-SNAPSHOT.jar"]
