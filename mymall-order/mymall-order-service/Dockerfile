FROM java:8-alpine
ADD target/mymall-order-service.jar mymall-order-service.jar
EXPOSE 20885
ENV JAVA_OPTS=""
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar /mymall-order-service.jar"]