FROM maven:3-openjdk-11 AS MAVEN_BUILD
MAINTAINER Marco Yuquilima
COPY pom.xml /build/
COPY src /build/src/
WORKDIR /build/
RUN mvn package -DskipTests
FROM openjdk:11
WORKDIR /app
COPY --from=MAVEN_BUILD /build/target/voting-0.0.1-SNAPSHOT.jar /app/
ENTRYPOINT ["java", "-jar", "voting-0.0.1-SNAPSHOT.jar"]