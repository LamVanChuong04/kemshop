FROM openjdk:17

ARG FILE_JAR=target/*.jar

ADD ${FILE_JAR} test.jar

ENTRYPOINT ["java", "-jar", "test.jar" ]

EXPOSE 8081