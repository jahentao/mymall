FROM java:8-alpine
ADD target/mymall-dubbo-admin.jar mymall-dubbo-admin.jar
EXPOSE 7001
ENV JAVA_OPTS=""
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar /mymall-dubbo-admin.jar"]