# CARBIGDATA Backend

## Stack
- Java 19 + Spring Boot
- PostgreSQL
- Flyway
- JWT (expira em 30 minutos)
- MapStruct
- MinIO

## Subir ambiente completo
```bash
docker compose up --build
```

## Usuário inicial
- username: `admin`
- password: `admin123`

## Login
`POST /api/auth/login`
```json
{
  "username": "admin",
  "password": "admin123"
}
```

Use o token JWT no header `Authorization: Bearer <token>`.

## Recursos
- `/api/clientes`
- `/api/enderecos`
- `/api/ocorrencias`
- `/api/ocorrencias/{ocorrenciaId}/fotos`

Todos os GET listam dados com paginação nativa (`page`, `size`, `sort`).
