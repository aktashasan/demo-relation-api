FROM openjdk:17-jdk-slim
COPY target/demo-relation.war demo-relation.war
ENTRYPOINT ["java","-jar","/demo-relation.war"]
EXPOSE 8080
