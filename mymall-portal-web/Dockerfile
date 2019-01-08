FROM java:8-alpine
ADD target/mymall-portal-web.jar mymall-portal-web.jar
EXPOSE 8082
ENV JAVA_OPTS=""
ENV ZOOKEEPER_HOST=192.168.237.100
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar /mymall-portal-web.jar"]