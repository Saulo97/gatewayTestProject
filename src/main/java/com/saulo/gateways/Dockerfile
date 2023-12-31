FROM maven:3.8.3-openjdk-17 AS build
WORKDIR /app
COPY . /app/
RUN mvn clean package -DskipTests

FROM openjdk:17-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar /app/gateways.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "gateways.jar"]