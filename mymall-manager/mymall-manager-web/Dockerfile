FROM java:8-alpine
ADD target/mymall-manager-web.jar mymall-manager-web.jar
EXPOSE 8081
ENV JAVA_OPTS=""
ENV ZOOKEEPER_HOST=192.168.237.100
ENTRYPOINT ["java", "$JAVA_OPTS", "-jar", "/mymall-manager-web.jar"]