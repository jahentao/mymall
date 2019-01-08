FROM java:8-alpine
ADD target/mymall-cart-web.jar mymall-cart-web.jar
EXPOSE 8086
ENV JAVA_OPTS=""
ENV ZOOKEEPER_HOST=192.168.237.100
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar /mymall-cart-web.jar"]