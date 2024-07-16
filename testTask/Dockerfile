# Этап 1: сборка приложения с помощью Maven
FROM maven:3.8.5-openjdk-21 AS build

# Устанавливаем рабочую директорию
WORKDIR /app

# Копируем файлы pom.xml и исходные коды проекта в контейнер
COPY pom.xml .
COPY src ./src

# Выполняем команду Maven для сборки проекта
RUN mvn clean package -DskipTests

FROM openjdk:21-jdk-slim

ARG JAR_FILE=target/*.jar

COPY ./target/testTask-0.0.1-SNAPSHOT.jar app.jar

# Запускаем приложение
ENTRYPOINT ["java", "-jar", "app.jar"]