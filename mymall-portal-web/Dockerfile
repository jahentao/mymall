FROM java:8-alpine
ADD target/mymall-portal-web.jar mymall-portal-web.jar
EXPOSE 8082
ENV JAVA_OPTS=""
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar /mymall-portal-web.jar"]