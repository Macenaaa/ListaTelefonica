# Lista Telefônica - Aplicação Java com JDBC e MySQL

## Descrição

Este projeto é uma aplicação Java simples para gerenciamento de uma lista telefônica, utilizando JDBC para conectar e interagir com um banco de dados MySQL. A aplicação roda via terminal e permite listar, inserir, atualizar e deletar contatos.

---

## Tecnologias Utilizadas

- Java 17
- Maven
- MySQL
- JDBC (Java Database Connectivity)

---

## Configuração do Banco de Dados MySQL

1. **Instale o MySQL** (se ainda não estiver instalado):

   Baixe e instale o MySQL Community Server em https://dev.mysql.com/downloads/mysql/

2. **Crie o banco de dados e a tabela**

   Conecte ao MySQL e execute os comandos abaixo:

   ```sql
   CREATE DATABASE ListaTelefonica;

   USE ListaTelefonica;

   CREATE TABLE contato (
       id INT AUTO_INCREMENT PRIMARY KEY,
       nome VARCHAR(100) NOT NULL,
       telefone VARCHAR(20) NOT NULL
   );

