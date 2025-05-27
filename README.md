# 🎲 API de Mercado RPG - Java Spring Boot

Projeto desenvolvido como prova da faculdade, uma API REST para gerenciamento de um mercado de RPG, com CRUD de itens e personagens.

A API segue boas práticas de desenvolvimento, incluindo paginação, filtros de pesquisa e organização clara do código.

---

## 🚀 Funcionalidades

- CRUD de **Itens** (criar, listar, atualizar, deletar)
- CRUD de **Personagens** (criar, listar, atualizar, deletar)
- Paginação nas listagens para melhor desempenho
- Filtros de pesquisa para facilitar a busca por itens e personagens
- Validação de dados de entrada
- Boas práticas com Spring Boot e Java

---

## 🛠️ Tecnologias Utilizadas

- Java 21
- Spring Boot
- Spring Data JPA
- Hibernate
- Banco de dados Oracle
- Maven
- Spring Validation

---

## ▶️ Como executar

1. Clone o repositório:
```
git clone https://github.com/Vitor4818/market-api.git
```
2. Navegue até o diretório
```
cd market-api
```
3. Configure o banco de dados no arquivo application.properties (exemplo para H2):
```
spring.datasource.username=seu usuario
spring.datasource.password=sua senha
```
4. Execute o projeto
```
mvn spring-boot:run
```
