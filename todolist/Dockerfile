FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

# Baixando o wait-for-it
RUN apk add --no-cache bash
ADD https://raw.githubusercontent.com/vishnubob/wait-for-it/master/wait-for-it.sh /wait-for-it.sh
RUN chmod +x /wait-for-it.sh

COPY . .

# Usando wait-for-it para garantir que MySQL esteja pronto antes de iniciar o Spring Boot
CMD /wait-for-it.sh mysql:3306 -- ./mvnw clean package -DskipTests && java -jar target/todolist-0.0.1-SNAPSHOT.jar
