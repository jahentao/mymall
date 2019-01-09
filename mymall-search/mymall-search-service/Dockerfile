FROM java:8-alpine
ADD target/mymall-search-service.jar mymall-search-service.jar
EXPOSE 20882
ENV JAVA_OPTS=""
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar /mymall-search-service.jar"]