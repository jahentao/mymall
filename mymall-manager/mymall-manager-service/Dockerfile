FROM java:8-alpine
ADD target/mymall-manager-service.jar mymall-manager-service.jar
EXPOSE 20880
ENV JAVA_OPTS=""
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar /mymall-manager-service.jar"]