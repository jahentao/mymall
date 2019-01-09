FROM java:8-alpine
ADD target/mymall-content-service.jar mymall-content-service.jar
EXPOSE 20881
ENV JAVA_OPTS=""
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar /mymall-content-service.jar"]