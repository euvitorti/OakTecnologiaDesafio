# Oak Tecnologia
 
Esta aplicação foi desenvolvida utilizando **Java 21**, **Spring Boot**, e **MySQL**. O objetivo do projeto é permitir o cadastro e a listagem de produtos, seguindo os requisitos descritos abaixo. A aplicação conta com um formulário para inserção de novos produtos e uma listagem que ordena os produtos pelo valor.

## Requisitos da Aplicação

### Cadastro:
- Formulário com os seguintes campos:
  - **Nome do Produto** (campo de texto)
  - **Descrição do Produto** (campo de texto)
  - **Valor do Produto** (campo de valor)
  - **Disponível para Venda** (campo com duas opções: Sim / Não)

### Listagem:
- A listagem deve ser ordenada do valor **menor para o maior**
- Após o cadastro de um novo produto, a listagem deve ser exibida automaticamente
- Um botão para cadastrar novos produtos deve estar disponível na página de listagem

## Configuração do Projeto

### Pré-requisitos:
- **Java 21** (ou superior)
- **MySQL** (ou outro banco de dados compatível, caso venha usar outro, troque a dependência no pom.xml)

### Banco de Dados
Não se esqueça de criar o banco de dados no MySQL antes de executar a aplicação. Você pode usar o seguinte comando para criar o banco:

```
  CREATE DATABASE nome_do_banco;

  CREATE TABLE products (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    product_name VARCHAR(100) NOT NULL,
    product_description VARCHAR(255),
    product_price DECIMAL(10, 2) NOT NULL,
    available_for_sale BOOLEAN NOT NULL
);

CREATE TABLE users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);
```

## Executando a Aplicação
Clone este repositório e importe o projeto em sua IDE preferida. Configure o acesso ao banco de dados no arquivo application.properties.
Certifique-se de que o banco de dados esteja rodando e execute os scripts SQL para criar as tabelas.
Acesse o frontend da aplicação, que pode ser encontrado neste repositório:
```
https://github.com/euvitorti/OakTecnologiaFront.
```

## Tecnologias Utilizadas
- Java 21
- Spring Boot
- Spring Data JPA
- Spring Security
- MySQL
