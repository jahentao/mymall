FROM java:8-alpine
ADD target/mymall-manager-web.jar mymall-manager-web.jar
EXPOSE 8081
ENV JAVA_OPTS=""
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar /mymall-manager-web.jar"]