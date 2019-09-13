FROM ubuntu:latest
RUN apt update
RUN apt install -y openjdk-8-jdk
RUN apt install -y maven
COPY server/ .
CMD mvn spring-boot:run
EXPOSE 9000/tcp
