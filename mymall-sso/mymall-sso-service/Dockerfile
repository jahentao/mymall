FROM java:8-alpine
ADD target/mymall-sso-service.jar mymall-sso-service.jar
EXPOSE 20883
ENV JAVA_OPTS=""
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar /mymall-sso-service.jar"]