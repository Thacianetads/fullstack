Desafio técnico - Estágio em desenvolvimento de software

você deve desenvolver uma aplicação full stack simples para gerenciamento de tarefas (To-do-List).,atendendo aos requisitos abaixo:

BACKEND (Spring Boot)
- Criar uma API REST  utilizando Java Spring Boot
- Endpoints minimos: post /tasks, GET /tasks, PUT /tasks/{id}, DELETE /tasks/{id}, -  GET/tasks{id}
- Persistência dos dados em Mysql
- Utilizar boas práticas de organização de código (camadas: controller, service, repository)

FRONT-ENND (React ou Angular)
- Desenvolver uma interface simples que consuma a API
- Listar, criar, atualizar e excluir tarefas
- Layoyt simples e funcional

BANCO DE DADOS (MySQL)
- Usar MySQL para armazenar as tarefas
- Fornecer script de criação da tabela

DIFERENCIAL (não obrigatório,mas contará pontos)
- Utilizar docker para subir os serviços (API, Front-end e Banco de Dados) via docker-compose

ENTREGA
- Disponibilizar o projeto em repositório GitHub/GitLab
- Incluir código do back-end, front-end e script SQL/migrations
- Opcional: Arquivos de configuração do Docker
- README.md com instruções claras de como rodar a aplicação

CRITÉRIOS DE AVALIAÇÃO
- Obrigatório: API funcional com CRUD, integração com Mysql, front-end consumindo API corretamente, estrutura organizada  e README explicativo.
- Diferenciais: Uso de Docker, boas práticas de código (camadas separadas, tratamento de erros, validações), deploy simples.
