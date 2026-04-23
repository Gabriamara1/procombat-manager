#  ProCombat Manager

API REST desenvolvida em Spring Boot para gestão de alunos, com operações de CRUD, validação de dados via DTO e controle de status (ATIVO / INATIVO).


  Tecnologias utilizadas

- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- PostgreSQL
- Maven
- Jakarta Validation

---

📌 Funcionalidades

✅ Cadastro de alunos  
✅ Listagem de alunos  
✅ Busca por ID  
✅ Atualização de cadastro  
✅ Ativação / Inativação  
✅ Filtro por status  
✅ Validação de dados (DTO + @Valid)  
✅ Tratamento de erros (400 / 404)



🧱 Estrutura da API

A aplicação segue uma arquitetura em camadas:

- **Controller** → Camada HTTP (endpoints)
- **Service** → Regras de negócio
- **Repository** → Acesso ao banco
- **DTO** → Transferência de dados
- **Entity** → Persistência (JPA)



📡 Endpoints principais

🔹 Health Check
