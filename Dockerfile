FROM openjdk:17-jdk
EXPOSE 8505
ADD target/sexsiofis-0.0.1-SNAPSHOT.jar sexsiofis.jar
HEALTHCHECK --interval=30s --timeout=10s --retries=3 \
  CMD curl --fail http://localhost:8505/ || exit 1
ENTRYPOINT ["java", "-jar", "sexsiofis.jar"]
