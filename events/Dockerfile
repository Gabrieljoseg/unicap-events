# Usar a imagem base do Debian e instalar o Java e o Maven
FROM debian:buster as build

# Instalar o Java e o Maven
RUN apt-get update && \
    apt-get install -y openjdk-17-jdk maven

# Definir o diretório de trabalho no container
WORKDIR /workspace/app

# Copiar o arquivo pom.xml e baixar as dependências
COPY pom.xml .
RUN mvn dependency:go-offline

# Copiar os arquivos do projeto
COPY src src

# Construir a aplicação
RUN mvn clean package -DskipTests

# Usar a imagem base do OpenJDK 17 para a imagem final
FROM openjdk:17

# Definir o diretório de trabalho no container
WORKDIR /app

# Copiar o arquivo JAR do estágio de build
COPY --from=build /workspace/app/target/events-0.0.1-SNAPSHOT.jar /app/events.jar

# Comando para executar o aplicativo
CMD ["java", "-jar", "events.jar"]
