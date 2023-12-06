# Usar a imagem base do OpenJDK 17
FROM openjdk:17

# Definir o diretório de trabalho dentro do container
WORKDIR /app

# Copiar todos os arquivos do diretório atual para o diretório de trabalho no container
COPY . .

# Executar o Maven para limpar e construir o projeto
RUN mvn clean install

# Copiar o arquivo JAR gerado para o diretório de trabalho (ajuste o caminho do arquivo JAR conforme necessário)
COPY target/events-0.0.1-SNAPSHOT.jar /app/events.jar

# Comando para executar o aplicativo
CMD ["java", "-jar", "/app/events.jar"]
