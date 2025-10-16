# build
#FROM maven:3.8.5-openjdk-17 as build
#WORKDIR /app
#COPY . .
#RUN  mvn clean package -DskipTests


# running
FROM openjdk:17

ARG FILE_JAR=target/*.jar

ADD ${FILE_JAR} test.jar

ENTRYPOINT ["java", "-jar", "test.jar" ]

EXPOSE 8081

#FROM openjdk:17
#WORKDIR /app
#COPY --from=build /app/target/*.jar kemshop.jar
#EXPOSE 8081
#
#ENTRYPOINT ["java", "-jar", "kemshop.jar"]