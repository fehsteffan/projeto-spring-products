# 📦 Products API RESTful

API RESTful para gerenciamento de produtos, desenvolvida com as versões mais recentes do **Spring Boot 3**, **Spring Framework 6** e **Java 17**.  
O sistema permite operações de CRUD (Create, Read, Update, Delete) sobre produtos, com atributos principais `name` e `value`.

---

## 🛠️ Tecnologias utilizadas
- **JDK 17**
- **Spring Boot 3**
- **Spring Framework 6**
- **Maven** (gerenciamento de dependências e build)
- **Postgres** (banco de dados relacional, gerenciado via PgAdmin)
- **Postman** (testes de API)
- **IntelliJ IDEA** (IDE de desenvolvimento)

---

## ⚙️ Arquitetura
- **Controller** → expõe os endpoints REST.  
- **Service** → implementa regras de negócio (validação de duplicidade, valor > 0, exclusão lógica).  
- **Repository** → abstração da camada de persistência com Spring Data JPA.  
- **DTOs** → objetos de transferência para entrada e saída de dados.  

