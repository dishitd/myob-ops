FROM maven:3.5.2-jdk-8-alpine AS BUILD_JAR
COPY pom.xml /tmp/
COPY src /tmp/src/
WORKDIR /tmp/
RUN mvn package
 
FROM openjdk:8-alpine
COPY --from=BUILD_JAR /tmp/target/*.jar .
ENTRYPOINT ["java", "-Xmx256m", "-Xms256m", "-jar", "myob-ops-0.0.1-SNAPSHOT.jar"]
#HEALTHCHECK --interval=1m --timeout=3s CMD wget --quiet --tries=1 --spider http://localhost:9000/health/ || exit 1