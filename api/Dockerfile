FROM maven:3.5.2-jdk-8-alpine AS BUILD_JAR
COPY api/pom.xml /tmp/
COPY api/src /tmp/src/
COPY .git /tmp/.git/
WORKDIR /tmp/
RUN mvn package -Dmaven.test.skip=true
 
FROM openjdk:8-alpine
COPY --from=BUILD_JAR /tmp/target/*.jar .
ENTRYPOINT ["java", "-Xmx256m", "-Xms256m", "-jar", "api.jar"]
#HEALTHCHECK --interval=1m --timeout=3s CMD wget --quiet --tries=1 --spider http://localhost:9000/health/ || exit 1