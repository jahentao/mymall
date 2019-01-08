FROM java:8-alpine
ADD target/mymall-search-web.jar mymall-search-web.jar
EXPOSE 8083
ENV JAVA_OPTS=""
ENV ZOOKEEPER_HOST=192.168.237.100
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar /mymall-search-web.jar"]