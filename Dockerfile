FROM openjdk:17-jdk-slim
COPY target/demo-relation.jar demo-relation.jar
ENTRYPOINT ["java","-jar","/demo-relation.jar"]
EXPOSE 8080