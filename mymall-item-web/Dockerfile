FROM java:8-alpine
ADD target/mymall-item-web.jar mymall-item-web.jar
EXPOSE 8084
ENV JAVA_OPTS=""
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar /mymall-item-web.jar"]