FROM openjdk:17

LABEL maintainer="lnv-0033"

COPY target/user-service-0.0.1-SNAPSHOT.jar /app/user-service.jar

WORKDIR /app

EXPOSE 8089

ENTRYPOINT ["java", "-jar", "user-service.jar"]