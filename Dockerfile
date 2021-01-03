FROM openjdk:11.0.9.1-jre
COPY target/mortgage-0.0.1-SNAPSHOT.jar mortgage.jar
EXPOSE 8080/tcp
ENTRYPOINT ["java","-jar","/mortgage.jar"]
