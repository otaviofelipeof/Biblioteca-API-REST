# 📚 Biblioteca API REST

API REST de gerenciamento de biblioteca desenvolvida com **Spring Boot 3**, **Spring Data JPA** e banco de dados **H2** em memória.

---

## 🛠️ Tecnologias Utilizadas

| Tecnologia | Versão |
|---|---|
| Java | 17 |
| Spring Boot | 3.2.0 |
| Spring Web | 3.2.0 |
| Spring Data JPA | 3.2.0 |
| Spring Validation | 3.2.0 |
| H2 Database | Runtime |
| Maven | 3.x |

---

## 🏗️ Estrutura do Projeto

```
src/main/java/com/biblioteca/
│
├── BibliotecaApplication.java        # Classe principal
│
├── entity/
│   ├── Autor.java                    # Entidade Autor
│   └── Livro.java                    # Entidade Livro
│
├── dto/
│   ├── AutorRequestDTO.java          # DTO de entrada para Autor
│   ├── AutorResponseDTO.java         # DTO de saída para Autor
│   ├── LivroRequestDTO.java          # DTO de entrada para Livro
│   └── LivroResponseDTO.java         # DTO de saída para Livro
│
├── repository/
│   ├── AutorRepository.java          # Repositório JPA de Autor
│   └── LivroRepository.java          # Repositório JPA de Livro
│
├── service/
│   ├── AutorService.java             # Regras de negócio de Autor
│   └── LivroService.java             # Regras de negócio de Livro
│
└── controller/
    ├── AutorController.java          # Endpoints REST de Autor
    ├── LivroController.java          # Endpoints REST de Livro
    └── GlobalExceptionHandler.java   # Tratamento global de erros
```

---

## ▶️ Como Executar

### Pré-requisitos
- Java 17+
- Maven 3.x

### Passos

```bash
# Clone o repositório
git clone https://github.com/seu-usuario/biblioteca-api.git

# Entre na pasta do projeto
cd biblioteca-api

# Execute a aplicação
./mvnw spring-boot:run
```

A API estará disponível em: `http://localhost:8080`

---

## 🗄️ Console H2 (Banco de Dados)

Acesse o banco H2 em: `http://localhost:8080/h2-console`

| Campo | Valor |
|---|---|
| JDBC URL | `jdbc:h2:mem:bibliotecadb` |
| Username | `sa` |
| Password | *(vazio)* |

---

## 📡 Endpoints da API

### Autores

#### `POST /autores` — Cadastrar autor

**Corpo da requisição:**
```json
{
  "nome": "Machado de Assis",
  "nacionalidade": "Brasileira"
}
```

**Resposta (201 Created):**
```json
{
  "id": 1,
  "nome": "Machado de Assis",
  "nacionalidade": "Brasileira",
  "totalLivros": 0
}
```

---

#### `GET /autores` — Listar todos os autores

**Resposta (200 OK):**
```json
[
  {
    "id": 1,
    "nome": "Machado de Assis",
    "nacionalidade": "Brasileira",
    "totalLivros": 2
  }
]
```

---

### Livros

#### `POST /livros` — Cadastrar livro

**Corpo da requisição:**
```json
{
  "titulo": "Dom Casmurro",
  "isbn": "9788535910663",
  "anoPublicacao": 1899,
  "genero": "Romance",
  "autorId": 1
}
```

**Resposta (201 Created):**
```json
{
  "id": 1,
  "titulo": "Dom Casmurro",
  "isbn": "9788535910663",
  "anoPublicacao": 1899,
  "genero": "Romance",
  "nomeAutor": "Machado de Assis",
  "autorId": 1
}
```

---

#### `GET /livros` — Listar todos os livros

**Resposta (200 OK):**
```json
[
  {
    "id": 1,
    "titulo": "Dom Casmurro",
    "isbn": "9788535910663",
    "anoPublicacao": 1899,
    "genero": "Romance",
    "nomeAutor": "Machado de Assis",
    "autorId": 1
  }
]
```

---

#### `PUT /livros/{id}` — Atualizar livro

**Corpo da requisição:**
```json
{
  "titulo": "Dom Casmurro - Edição Especial",
  "isbn": "9788535910663",
  "anoPublicacao": 1899,
  "genero": "Romance Clássico",
  "autorId": 1
}
```

---

#### `DELETE /livros/{id}` — Excluir livro

**Resposta:** `204 No Content`

---

## ✅ Validações Aplicadas

| Campo | Regra |
|---|---|
| Autor - nome | Obrigatório, 2 a 100 caracteres |
| Autor - nacionalidade | Obrigatório |
| Livro - titulo | Obrigatório, 1 a 200 caracteres |
| Livro - isbn | Obrigatório, exatamente 13 dígitos |
| Livro - anoPublicacao | Obrigatório, entre 1000 e 2100 |
| Livro - genero | Obrigatório |
| Livro - autorId | Obrigatório, autor deve existir |

---

## ⚠️ Tratamento de Erros

**Erro de validação (400):**
```json
{
  "status": 400,
  "mensagem": "Dados inválidos",
  "erros": {
    "isbn": "O ISBN deve conter exatamente 13 dígitos numéricos",
    "titulo": "O título é obrigatório"
  }
}
```

**Erro de negócio (400):**
```json
{
  "status": 400,
  "mensagem": "Já existe um livro cadastrado com o ISBN: 9788535910663"
}
```

---

## 👤 Autor do Projeto

Desenvolvido como atividade prática da disciplina de Desenvolvimento Back-end.

## Integrantes

- Otávio Felipe
- Severino Neto
- Lucas Menezes
- Victor Laranjeira
- Júnior Lummertz
- Willyane