FROM gradle:jdk17-alpine
WORKDIR /auth-sync-service

COPY src /auth-sync-service/src/
COPY build.gradle .
COPY lombok.config .

RUN gradle clean build -x test

ENTRYPOINT ["java", "-jar", "./build/libs/auth-sync-service-1.0.0.jar"]