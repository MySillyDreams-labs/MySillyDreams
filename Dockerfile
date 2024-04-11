FROM gradle:8.6 AS build
WORKDIR /app
COPY build.gradle .
COPY settings.gradle .
COPY gradle.properties .
COPY src src
RUN gradle clean build --no-daemon

FROM openjdk
WORKDIR /app
COPY --from=build /app/build/libs/*.jar app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]
