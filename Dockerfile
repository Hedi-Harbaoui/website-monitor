FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY . /app
WORKDIR /app/src
RUN javac de/frankfurt_uas/websitemonitor/Main.java
ENTRYPOINT ["java", "de.frankfurt_uas.websitemonitor.Main"]
