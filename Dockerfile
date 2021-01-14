FROM   adoptopenjdk/openjdk11:jre-11.0.6_10-alpine
VOLUME /tmp
EXPOSE 8081
ADD target/LogViewer-0.0.1-SNAPSHOT.jar LogViewer-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "LogViewer-0.0.1-SNAPSHOT.jar"]docker