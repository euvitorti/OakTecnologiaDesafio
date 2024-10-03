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

## Executando a Aplicação
Clone este repositório e importe o projeto em sua IDE preferida.

- Abra src/main/resources/application.properties.
- Atualize a configuração do banco de dados com suas credenciais:
```
spring.datasource.url=jdbc:mysql://localhost/seu_banco_de_dados
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
```

Certifique-se de que o banco de dados esteja rodando e execute os scripts SQL para criar as tabelas:
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

Acesse o frontend da aplicação, que pode ser encontrado neste repositório:
```
https://github.com/euvitorti/OakTecnologiaFront
```

## Configuração do CORS
Acesse a classe Security e localize o método responsável pela configuração do CORS. Atualize a linha de código que define a URL permitida com a URL onde o front-end está rodando (seja em ambiente de desenvolvimento ou produção).

Exemplo de configuração de CORS em uma classe de configuração Java:
```
    @Override
    public void addCorsMappings(CorsRegistry corsRegistry) {
        corsRegistry.addMapping("/**") // Allow CORS for all endpoints
                .allowedOrigins("http://127.0.0.1:5500") // Specify allowed origins
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Specify allowed HTTP methods
                .allowedHeaders("*") // Allow all headers
                .allowCredentials(true); // Allow credentials to be included in CORS requests
    }
```
Substitua "http://127.0.0.1:5500" pela URL correta onde o front-end está rodando, por exemplo:

Desenvolvimento local: http://127.0.0.1:5501
Produção: A URL do seu servidor de produção.

Isso vai garantir que o front-end consiga acessar a API corretamente!

## Tecnologias Utilizadas
- Java 21
- Spring Boot
- Spring Data JPA
- Spring Security
- MySQL
