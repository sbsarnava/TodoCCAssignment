from openjdk:21
EXPOSE 8080
ADD target/todo-java.jar todo-java.jar
ENTRYPOINT ["java", "-jar", "./todo-java.jar"]