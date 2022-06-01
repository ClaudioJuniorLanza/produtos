FROM openjdk:11
VOLUME /tmp
ADD target/produtos-0.0.1-SNAPSHOT.jar produtos.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar","/produtos.jar"]