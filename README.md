# CARBIGDATA Backend

Backend REST do projeto **CARBIGDATA**, construído com Spring Boot para gerenciamento de clientes, endereços, ocorrências e fotos de ocorrência.

---

## 1) Visão geral do projeto

A aplicação foi desenhada com arquitetura em camadas e foco em boas práticas de API:

- **Controller**: expõe endpoints HTTP REST e valida payloads.
- **Service**: concentra as regras de negócio.
- **Repository**: abstrai o acesso ao banco via Spring Data JPA.
- **Mapper (MapStruct)**: converte entidades JPA em DTOs e vice-versa.
- **Security (JWT)**: autenticação stateless com token Bearer.

Além disso, o projeto utiliza:

- **Flyway** para versionamento de schema e dados iniciais.
- **ProblemDetail** para padronização de respostas de erro.
- **Bean Validation** (jakarta.validation) com validações padrão e customizadas (CPF).
- **Java records** para DTOs, reduzindo boilerplate.

---

## 2) Stack e dependências principais

### Plataforma
- **Java 19**
- **Spring Boot 3.5.6**
- **Maven**

### Dependências de runtime
- `spring-boot-starter-web`
- `spring-boot-starter-validation`
- `spring-boot-starter-data-jpa`
- `spring-boot-starter-security`
- `flyway-core` + `flyway-database-postgresql`
- `postgresql`
- `jjwt-api`, `jjwt-impl`, `jjwt-jackson`
- `mapstruct`
- `minio`

### Build
- `mapstruct-processor` via `maven-compiler-plugin` (geração automática dos mappers em build time).

> Observação: o projeto possui código de integração com MinIO já modelado, porém atualmente comentado no adapter/porta de storage.

---

## 3) Arquitetura em camadas (detalhada)

### 3.1 Controllers
Endpoints REST em `/api/**`:

- `AuthController` → autenticação/login (`/api/auth/login`).
- `ClienteController` → CRUD inicial de clientes (listar, buscar por id, criar).
- `EnderecoController` → CRUD inicial de endereços (listar, buscar por id, criar).
- `OcorrenciaController` → CRUD inicial de ocorrências (listar, buscar por id, criar).
- `FotoOcorrenciaController` → listagem de fotos por ocorrência.

### 3.2 Services
As regras de negócio e orquestração ficam nos serviços:

- validação de existência de entidades relacionadas (ex.: ocorrência exige cliente/endereço válidos);
- orquestração de persistência;
- paginação e transformação de resposta.

### 3.3 Repositories
Interfaces Spring Data JPA para cada agregado:

- `ClienteRepository`
- `EnderecoRepository`
- `OcorrenciaRepository`
- `FotoOcorrenciaRepository`
- `AppUserRepository`

### 3.4 DTOs com `record`
A API usa **records** em request/response para ganhar imutabilidade semântica, clareza e menos código.

Exemplos de request:
- `AuthRequestDto`
- `ClienteRequestDto`
- `EnderecoRequestDto`
- `OcorrenciaRequestDto`

Exemplos de response:
- `AuthResponseDto`
- `ClienteResponseDto`
- `EnderecoResponseDto`
- `OcorrenciaResponseDto`
- `FotoOcorrenciaResponseDto`

### 3.5 MapStruct
Os mapeamentos entre entidade e DTO são feitos por interfaces anotadas com `@Mapper(componentModel = "spring")`.

Benefícios:
- menos mapeamento manual repetitivo;
- melhor legibilidade em serviços;
- geração de implementação em compile-time (sem reflection pesada para mapeamento).

---

## 4) Autenticação e autorização (JWT)

A autenticação é **stateless** com token JWT:

1. Cliente chama `POST /api/auth/login` com usuário e senha.
2. `AuthenticationManager` valida credenciais via `UserDetailsService` + `DaoAuthenticationProvider`.
3. `JwtService` gera token com:
   - `subject`: username
   - `issuedAt`
   - `expiration`
   - assinatura HMAC com chave `app.jwt.secret`
4. Cliente envia token no header:
   - `Authorization: Bearer <jwt>`
5. `JwtAuthenticationFilter` intercepta requests, valida token e popula `SecurityContext`.

### Regras de acesso
- Permitido sem token:
  - `/api/auth/**`
  - `/actuator/health`
- Demais endpoints exigem autenticação.

### Expiração do token
- `app.jwt.expiration-seconds: 1800` (30 minutos).

---

## 5) Modelo de dados / entidades

### `Cliente`
- `id` (`cod_cliente`)
- `nome` (`nme_cliente`)
- `dataNascimento` (`dta_nascimento`)
- `cpf` (`nro_cpf`, único)
- `dataCriacao` (`dta_criacao`, preenchida em `@PrePersist`)

### `Endereco`
- `id` (`cod_endereco`)
- `logradouro`, `bairro`, `cep`, `cidade`, `estado`

### `Ocorrencia`
- `id` (`cod_ocorrencia`)
- relação `ManyToOne` com `Cliente`
- relação `ManyToOne` com `Endereco`
- `dataOcorrencia`
- `status` (`ATIVA` ou `FINALIZADA`)

### `FotoOcorrencia`
- `id` (`cod_foto_ocorrencia`)
- relação `ManyToOne` com `Ocorrencia`
- `dataCriacao`
- `pathBucket`
- `hash`

### `AppUser`
- `id`
- `username` (único)
- `password` (codificada)
- `role`

---

## 6) Migrações e seed de dados

As migrações ficam em `src/main/resources/db/migration`:

- `V1__create_schema.sql` → cria as tabelas (`cliente`, `endereco`, `ocorrencia`, `foto_ocorrencia`, `app_user`).
- `V2__seed_data.sql` → carga inicial de clientes, endereços e ocorrências.

Além disso, há um seed em código (`SeedDataConfig`) que cria usuário admin padrão se não existir:

- `username: admin`
- `password: admin123`
- `role: ROLE_ADMIN`

---

## 7) Validação e tratamento de erros

### Validação
- Uso de anotações padrão (`@NotBlank`, `@NotNull`, `@Pattern`, `@Size`).
- Validação customizada de CPF com `@Cpf` e `CpfValidator`.

### Erros padronizados
`ApiExceptionHandler` centraliza exceções e responde com `ProblemDetail`, incluindo:
- status HTTP;
- título e detalhe;
- path;
- lista de erros (quando aplicável).

Casos cobertos: entidade não encontrada, validação de bean, payload inválido, credenciais inválidas/acesso negado.

---

## 8) Configuração (application.yml)

Principais propriedades:

### Banco
- `spring.datasource.url`
- `spring.datasource.username`
- `spring.datasource.password`

### JPA/Flyway
- `spring.jpa.hibernate.ddl-auto=validate`
- `spring.flyway.enabled=true`

### JWT
- `app.jwt.secret`
- `app.jwt.expiration-seconds`

### MinIO
- `app.minio.url`
- `app.minio.access-key`
- `app.minio.secret-key`
- `app.minio.bucket`

Todas podem ser sobrescritas por variáveis de ambiente.

---

## 9) Como executar

### 9.1 Com Docker (recomendado)
```bash
docker compose up --build
```

### 9.2 Localmente (sem Docker)
Pré-requisitos:
- Java 19
- Maven
- PostgreSQL disponível

Passos:
```bash
mvn spring-boot:run
```

---

## 10) Endpoints principais

### Autenticação
- `POST /api/auth/login`

Body:
```json
{
  "username": "admin",
  "password": "admin123"
}
```

Resposta (exemplo):
```json
{
  "token": "<jwt>",
  "expiresInSeconds": 1800
}
```

### Recursos protegidos
- `GET/POST /api/clientes`
- `GET /api/clientes/{id}`
- `GET/POST /api/enderecos`
- `GET /api/enderecos/{id}`
- `GET/POST /api/ocorrencias`
- `GET /api/ocorrencias/{id}`
- `GET /api/ocorrencias/{ocorrenciaId}/fotos`

> Todas as rotas protegidas exigem header `Authorization: Bearer <token>`.

---

## 11) Paginação e ordenação

Os endpoints de listagem usam paginação nativa do Spring Data:

- `page` (default 0)
- `size` (default do Spring)
- `sort` (ex.: `sort=id,desc`)

Exemplo:
```http
GET /api/clientes?page=0&size=10&sort=nome,asc
```

---

## 12) Pontos de evolução do projeto

- Reativar upload de fotos em `FotoOcorrenciaService` e `MinioStorageAdapter`.
- Adicionar documentação OpenAPI/Swagger.
- Expandir testes unitários e de integração.
- Evoluir autorização por papéis/permissões em nível de endpoint/negócio.

---

## 13) Resumo rápido

Se você está começando agora no projeto:

1. Suba o ambiente com Docker.
2. Faça login em `/api/auth/login` com `admin/admin123`.
3. Use o JWT para acessar os recursos.
4. Explore entidades `cliente`, `endereco`, `ocorrencia` e `foto_ocorrencia`.

Esse backend já está estruturado com base sólida (segurança, migração, validação e separação por camadas), pronto para escalar novas features com segurança.
