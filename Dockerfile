FROM openjdk:11.0.16-jre-slim
COPY target/demo-relation-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 8080