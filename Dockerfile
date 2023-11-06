FROM openjdk:11
ADD ./target/calculator-devops-1.0-SNAPSHOT-jar-with-dependencies.jar ./
WORKDIR ./
CMD ["java","-jar","calculator-devops-1.0-SNAPSHOT-jar-with-dependencies.jar"]