FROM java:8-alpine
ADD target/mymall-item-web.jar mymall-item-web.jar
EXPOSE 8084
ENV JAVA_OPTS=""
ENV ACTIVEMQ_HOST=192.168.237.100
ENV ZOOKEEPER_HOST=192.168.237.100
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar /mymall-item-web.jar"]