FROM java:8-alpine
ADD target/mymall-dubbo-admin.jar mymall-dubbo-admin.jar
EXPOSE 7001
ENV JAVA_OPTS=""
ENV ZOOKEEPER_HOST=192.168.237.100
ENV ZOOKEEPER_PORT=2181
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar /mymall-dubbo-admin.jar"]