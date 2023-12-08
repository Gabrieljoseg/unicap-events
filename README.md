# Plataforma de Eventos Estudantis

Bem-vindo à Plataforma de Eventos Estudantis, um projeto Spring Boot com Java 17 e PostgreSQL como banco de dados. Esta plataforma permite o gerenciamento de eventos, inscrições de estudantes e muito mais.

## Requisitos

Certifique-se de ter as seguintes ferramentas instaladas antes de executar o projeto:

- [Java Development Kit (JDK) 17](https://adoptopenjdk.net/?variant=openjdk17&jvmVariant=hotspot)
- [Maven](https://maven.apache.org/download.cgi)
- [PostgreSQL](https://www.postgresql.org/download/)

## Configuração do Banco de Dados

Antes de executar o projeto, você deve criar o banco de dados "eventosunicap" no PostgreSQL e configurar as credenciais de acesso no arquivo `application.properties` ou `application.yml` do aplicativo.

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/eventosunicap
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha


