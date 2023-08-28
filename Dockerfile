# Этап 1: Сборка Java-приложения
FROM maven:3.9.1-amazoncorretto-17 as builder
WORKDIR /app
COPY . /app/
COPY ./resources/ /app/resources/
RUN mvn -f /app/pom.xml clean package -Dmaven.test.skip=true

# Этап 2: Контейнер с Java-приложением
FROM openjdk:17-jdk-buster
WORKDIR /app
COPY --from=builder /app/target/jira-1.0.jar /app/jira.jar
COPY --from=builder /app/resources/ /app/resources/
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/jira.jar"]

