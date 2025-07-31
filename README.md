
# Projeto Finanças API

API RESTful para gerenciamento financeiro, com autenticação via JWT e persistência em MongoDB. A API é containerizada com Docker, incluindo a aplicação e o banco de dados MongoDB.

---

## Tecnologias utilizadas

- Java 21 com Spring Boot  
- MongoDB 7.0  
- JWT para autenticação  
- Docker e Docker Compose para containerização  
- Swagger para documentação da API

---

## Estrutura do projeto

- **components**  
  Contém o `JwtComponent`, responsável pela manipulação e validação dos tokens JWT.

- **configurations**  
  Contém as classes de configuração:  
  - `AuthConfiguration` (configuração do filtro de autenticação),  
  - `CorsConfiguration` (configuração CORS),  
  - `SwaggerConfiguration` (configuração da documentação via Swagger).

- **controllers**  
  - `CategoriasController` — gerencia os endpoints relacionados a categorias.  
  - `MovimentacoesController` — gerencia os endpoints relacionados a movimentações financeiras.

- **domain**  
  Contém os subpacotes:  
  - `dtos` (objetos de transferência de dados),  
  - `entities` (modelos das entidades),  
  - `enums` (enumerações),  
  - `exceptions` (exceções personalizadas),  
  - `services` (regras de negócio).

- **filter**  
  Contém o `AuthenticationFilter`, filtro que valida o JWT para cada requisição.

- **handlers**  
  Tratamento global de exceções.

- **repositories**  
  Interfaces para acesso ao banco MongoDB.

---

## Funcionalidades Principais

- Autenticação e autorização via token JWT.
- Persistência dos dados em MongoDB.
- Containerização com Docker para a aplicação e banco.
- Endpoints para gerenciamento das entidades movimentação e categoria.
- Documentação automática via Swagger.

---

## Como executar

1. Instale [Docker](https://docs.docker.com/get-docker/) e [Docker Compose](https://docs.docker.com/compose/install/).

2. Na raiz do projeto, execute:

```bash
docker-compose up --build
```

3\. A documentação Swagger pode ser encontrada em: http://localhost:8084/swagger-ui.html

---

## Endpoints principais

- `/api/v1/categorias` - CRUD de categorias
- `/api/v1/movimentacoes` - CRUD de movimentações financeiras

---

## Observações

- Todas as requisições protegidas precisam conter o header `Authorization` com o token JWT no formato:  
  `Bearer <token>`
- O banco MongoDB está configurado via container e inicializado automaticamente com usuário e banco apropriados.

---