FROM openjdk:8-jdk-alpine
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
# provide secrets at build
ARG USR=mpp04
ARG PWD=>lf,o=5D
# persist secrets in future container
ENV postgresql_usr=${USR}
ENV postgresql_pwd=${PWD}
ENTRYPOINT ["java","-jar","/app.jar"]