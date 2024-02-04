FROM eclipse-temurin:21
VOLUME /tmp
ARG JAR_FILE
COPY task-maneger.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]