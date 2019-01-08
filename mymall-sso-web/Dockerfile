FROM java:8-alpine
ADD target/mymall-sso-web.jar mymall-sso-web.jar
EXPOSE 8085
ENV JAVA_OPTS=""
ENV ZOOKEEPER_HOST=192.168.237.100
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar /mymall-sso-web.jar"]