FROM openjdk:17-alpine

WORKDIR /app

COPY target/*.jar app.jar

ENV API_URL="https://dummyjson.com/products"

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]