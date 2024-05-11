FROM openjdk:17

LABEL maintainer="javaguides.net"

ADD target/api-gateway-0.0.1-SNAPSHOT.jar /app/api-gateway.jar

WORKDIR /app

ENTRYPOINT ["java", "-jar", "api-gateway.jar"]