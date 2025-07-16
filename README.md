Lista Telefônica - Aplicação Java com JDBC e MySQL
Descrição
Este projeto é uma aplicação Java simples para gerenciamento de uma lista telefônica, utilizando JDBC para conectar e interagir com um banco de dados MySQL. A aplicação roda via terminal e permite listar, inserir, atualizar e deletar contatos.

Tecnologias Utilizadas
Java 17

Maven

MySQL

JDBC (Java Database Connectivity)

Configuração do Banco de Dados MySQL
Instalar o MySQL (se ainda não tiver instalado):

Baixe e instale o MySQL Community Server em https://dev.mysql.com/downloads/mysql/

Criar o banco de dados e a tabela

Conecte ao MySQL e execute os comandos abaixo para criar o banco e a tabela:

sql
Copiar
Editar
CREATE DATABASE ListaTelefonica CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

USE ListaTelefonica;

CREATE TABLE contato (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    telefone VARCHAR(20) NOT NULL
);
Configurar usuário e senha

Certifique-se de que o usuário root (ou outro que preferir) tenha acesso ao banco e defina a senha correta.

Configuração do Projeto
Clone este repositório ou copie os arquivos para sua máquina.

Configurar a conexão no arquivo Conexao.java

No pacote util, abra o arquivo Conexao.java e ajuste as configurações de conexão para o seu ambiente MySQL:

java
Copiar
Editar
private static final String URL = "jdbc:mysql://localhost:3306/ListaTelefonica?useSSL=false&serverTimezone=UTC";
private static final String USER = "root";  // seu usuário do MySQL
private static final String PASSWORD = "sua_senha";  // sua senha do MySQL
Nota: Ajuste a porta (3306 é a padrão, mas no seu Docker pode ser diferente, ex: 3355) e as credenciais conforme seu ambiente.

Dependências

O projeto usa Maven e a dependência do conector MySQL está no pom.xml:

xml
Copiar
Editar
<dependency>
    <groupId>com.mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>8.0.33</version>
</dependency>
Execute o comando para baixar as dependências:

bash
Copiar
Editar
mvn clean install
Como Rodar a Aplicação
Compile e rode o projeto pelo IntelliJ IDEA ou via linha de comando:

bash
Copiar
Editar
mvn compile
mvn exec:java -Dexec.mainClass="main.Main"
O sistema exibirá um menu no terminal para:

Listar contatos

Cadastrar novo contato

Alterar contato por ID

Deletar contato por ID

Pesquisar contato por nome

Sair

Interaja conforme as opções no menu.

Possíveis Problemas
Erro: No suitable driver found

Verifique se a dependência mysql-connector-java está corretamente adicionada no Maven.

Confira se o driver foi carregado na classe Conexao (adicionar Class.forName("com.mysql.cj.jdbc.Driver"); no método getConnection).

Verifique se a URL, usuário e senha do banco estão corretos.

Erro de conexão

Confirme se o MySQL está rodando e se a porta está correta.

Se usar Docker, confirme o mapeamento de portas do container.

Teste conexão ao banco pelo terminal ou MySQL Workbench.

Observações
Essa aplicação é básica, para estudo e prática de JDBC e CRUD.
