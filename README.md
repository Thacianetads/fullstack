
# 📝 ToDo List - Fullstack (Angular + Spring Boot)

Este projeto é uma aplicação simples de gerenciamento de tarefas (ToDo List) fullstack, desenvolvida para um desafio técnico de estágio.  
Ela possui:

- Backend API REST em **Java Spring Boot** com endpoints para CRUD de tarefas.
- Frontend em **Angular** consumindo a API para listar, criar, atualizar e excluir tarefas.
- Banco de dados **MySQL** para persistência das tarefas.
- Configuração via **Docker Compose** para subir backend, frontend e banco MySQL com um único comando.

---

## 📋 Requisitos atendidos

### Backend (Spring Boot)

- API REST com endpoints:  
  - POST `/tasks`  
  - GET `/tasks`  
  - GET `/tasks/{id}`  
  - PUT `/tasks/{id}`  
  - DELETE `/tasks/{id}`
- Persistência usando MySQL
- Código organizado em camadas: Controller, Service, Repository
- Validações e tratamento básico de erros

### Frontend (Angular)

- Interface simples para listar, criar, atualizar e excluir tarefas
- Consumo correto da API REST
- Layout funcional e básico

### Banco de dados (MySQL)

- Script SQL para criação da tabela `tasks` incluído
- Configuração para conectar com backend

### Diferencial (Docker)

- Serviços backend, frontend e banco rodando em containers via Docker Compose
- Imagens buildadas automaticamente pelo Compose

---

## 🚀 Como rodar o projeto usando Docker

### Pré-requisitos

- Docker e Docker Compose instalados (https://docs.docker.com/get-docker/)

### Passos

1. Clone o repositório e entre na pasta do projeto

```
git clone <url-do-repositorio>
cd <pasta-do-projeto>
```

2. Suba os containers com build das imagens

```
docker-compose up --build
```

3. Aguarde os containers iniciarem.  
O frontend estará disponível em:  
http://localhost:4200

O backend estará disponível em:  
http://localhost:8080

O banco MySQL estará rodando na porta padrão 3306 (internamente para o backend).

---

## 🗄 Banco de dados

O banco MySQL será inicializado com um banco chamado `todo`.  
Caso precise rodar o script SQL manualmente, ele está localizado em `db/init.sql`.

Exemplo de criação da tabela tasks:

```
-- Cria o banco de dados 'todo' se não existir
CREATE DATABASE IF NOT EXISTS todo;

-- Usa o banco de dados 'todo'
USE todo;

-- Cria a tabela 'todo'
CREATE TABLE IF NOT EXISTS todo (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    completed BOOLEAN DEFAULT FALSE
);
```

---

## ⚙️ Comandos úteis Docker

- Parar containers

```
docker-compose down
```

- Apenas parar sem remover

```
docker-compose stop
```

- Rebuildar somente frontend

```
docker-compose build frontend
```

- Rebuildar somente backend

```
docker-compose build backend
```

---

## 📝 Estrutura do projeto

- `/frontend` → Código Angular
- `/todolist` → Código Spring Boot


---

## 🛠 Considerações finais

- Projeto atende o requisito do desafio para vaga de estágio.
- Boa organização do código backend com camadas.
- Docker Compose facilita o deploy local e testes.
- Frontend simples, funcional e conectado à API.
- Script SQL para banco disponível.


---


