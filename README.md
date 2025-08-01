
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


2. Clone o repositório:

```bash
git clone https://https://github.com/a-devrepo/projetoFinancasApi
cd projetoFinancasApi
```

3. Na raiz do projeto, execute:

```bash
docker-compose up --build
```

3. A documentação Swagger pode ser encontrada em: http://localhost:8084/swagger-ui.html

Uso do Token JWT na documentação Swagger

O token JWT necessário para acessar os endpoints protegidos deve ser obtido através da API de usuários disponível no repositório:
https://github.com/a-devrepo/projetoUsuariosApi

## Como usar o token na interface Swagger:

1. Obtenha o token JWT autenticando-se na API de usuários.

2. Na interface do Swagger da API Finanças (em http://localhost:8084/swagger-ui.html), clique no botão Authorize no canto superior direito.

3. No campo que aparecer, digite o token obtido na API de usuários

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