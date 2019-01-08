FROM java:8-alpine
ADD target/mymall-content-service.jar mymall-content-service.jar
EXPOSE 20881
ENV JAVA_OPTS=""
ENV MYSQL_HOST=192.168.237.100
ENV MYSQL_PORT=3307
ENV MYSQL_DATABASE=mymall
ENV MYSQL_PASSWORD=123456
ENV REDIS_HOST=192.168.237.100
ENV ZOOKEEPER_HOST=192.168.237.100
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar /mymall-content-service.jar"]