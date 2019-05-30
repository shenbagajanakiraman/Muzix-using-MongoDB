From openjdk:11-jdk-stretch

ADD target/musix-service-0.0.1-SNAPSHOT.jar /src/app/music/musix-service-0.0.1-SNAPSHOT.jar

WORKDIR /src/app/music

ENTRYPOINT ["java","-jar", "musix-service-0.0.1-SNAPSHOT.jar"]