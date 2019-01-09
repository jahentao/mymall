FROM java:8-alpine
ADD target/mymall-cart-service.jar mymall-cart-service.jar
EXPOSE 20884
ENV JAVA_OPTS=""
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar /mymall-cart-service.jar"]