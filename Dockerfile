FROM openjdk:17-jdk
COPY build/libs/ec2-rds-spring-boot-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]