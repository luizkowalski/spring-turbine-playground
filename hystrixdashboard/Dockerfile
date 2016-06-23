FROM java:8
VOLUME /hystrix_dashboard
ADD target/hystrix_dashboard-1.0.0.jar app.jar
RUN sh -c 'touch app.jar'
EXPOSE 8989
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
