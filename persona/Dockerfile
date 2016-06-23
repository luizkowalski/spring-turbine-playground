FROM java:8
VOLUME /persona
ADD target/persona-1.0.0.jar app.jar
RUN sh -c 'touch app.jar'
EXPOSE 8080
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Dspring.profiles.active=docker","-jar","/app.jar"]
