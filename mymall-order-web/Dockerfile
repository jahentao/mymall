FROM java:8-alpine
ADD target/mymall-order-web.jar mymall-order-web.jar
EXPOSE 8087
ENV JAVA_OPTS=""
ENV ZOOKEEPER_HOST=192.168.237.100
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar /mymall-order-web.jar"]