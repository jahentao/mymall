FROM java:8-alpine
ADD target/mymall-order-web.jar mymall-order-web.jar
EXPOSE 8087
ENV JAVA_OPTS=""
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar /mymall-order-web.jar"]