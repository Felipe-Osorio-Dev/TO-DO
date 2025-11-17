# 📝 To‑Do List API

Uma API de To‑Do List desenvolvida em **Java + Spring Boot**, utilizando **PostgreSQL**, **Flyway**, **JPA/Hibernate**, **Spring Validation** e **MapStruct** para conversão de objetos.

---

## 🚀 Tecnologias Utilizadas

* **Java 17+**
* **Spring Boot** (Web, Validation)
* **Spring Data JPA / Hibernate**
* **MapStruct**
* **Flyway** para controle de migrações
* **PostgreSQL** como banco de dados

---

## 📌 Funcionalidades da API

* Criar tarefas
* Listar todas as tarefas
* Buscar tarefa por ID
* Atualizar tarefa
* Deletar tarefa
* Validação de campos com Bean Validation
* Mapeamento de DTOs utilizando MapStruct
* Persistência e versionamento da base com Flyway

---

## 🗂️ Estrutura do Projeto

```
src/
 ├── main/
 │    ├── java/
 │    │    └── ... (controllers, services, repositories, dtos, mappers)
 │    └── resources/
 │         ├── application.properties
 │         └── db/migration/ (scripts do Flyway)
 └── test/
```

---

## 🗄️ Configuração do Banco de Dados (application.properties)

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/todolist
spring.datasource.username=postgres
spring.datasource.password=senha
spring.jpa.hibernate.ddl-auto=validate
spring.jpa.show-sql=true
spring.flyway.enabled=true
```

---

## 🛠️ Migrações com Flyway

As migrações ficam em:

```
src/main/resources/db/migration
```

Exemplo de script:

```sql
V1__create_table_tasks.sql
```

---

## 🔄 Mapeamento com MapStruct

Exemplo de mapper:

```java
@Mapper(componentModel = "spring")
public interface TaskMapper {
    TaskDto toDto(TaskEntity entity);
    TaskEntity toEntity(TaskDto dto);
}
```

---

## ✔️ Validações

Utilizando `javax.validation` / `jakarta.validation`:

```java
@NotBlank
@Size(min = 3, max = 100)
private String title;
```

---

## ▶️ Como Rodar o Projeto

1. Instale PostgreSQL e crie o database
2. Configure o `application.properties`
3. Rode as migrações automaticamente com o Flyway
4. Execute:

```bash
mvn spring-boot:run
```

---

## 📬 Endpoints Principais

### **POST /tasks** – Criar tarefa

### **GET /tasks** – Listar todas as tarefas

### **GET /tasks/{id}** – Buscar por ID

### **PUT /tasks/{id}** – Atualizar tarefa

### **DELETE /tasks/{id}** – Deletar tarefa

---

## 🔮 Futuras Atualizações

* Adicionar **Swagger / OpenAPI** para documentação da API
* Implementar testes unitários com JUnit + Mockito
* Adicionar autenticação JWT
* Criar docker-compose para subir a aplicação e o banco

## 📄 Licença

Distribuído sob a licença MIT.

---

Caso queira adicionar imagens, badges, documentação da API (Swagger) ou instruções de Docker, posso complementar o README!
