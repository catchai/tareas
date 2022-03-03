# from template
FROM openjdk:jdk-11.0.11_9-alphine
RUN addgroup -S paymentchain && adduser -G paymentchain
USER admin:paymentchain
VOLUME /tmp 
ARG JAR_FILE-target/*.jar
ADD target/${JAR_FILE} app.jar
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]