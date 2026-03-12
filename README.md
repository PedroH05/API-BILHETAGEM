# 🚌 API de Estatísticas de Bilhetagem

API REST para processamento de dados de embarque de ônibus em tempo real, com cálculo de estatísticas em janela móvel de 60 segundos.

---

## O que essa API faz?

Imagine que ônibus estão enviando dados de embarque (valor da passagem, horário etc.) para um servidor a todo momento. Essa API:

1. **Recebe** os dados de embarque em tempo real
2. **Calcula automaticamente** estatísticas dos últimos 60 segundos: média, soma, mínimo, máximo e contagem
3. **Descarta** dados com mais de 60 segundos automaticamente

Tudo isso em memória, sem banco de dados, para máxima velocidade.

---

## Tecnologias utilizadas

| Tecnologia | Para que serve |
|---|---|
| Java 17 | Linguagem principal |
| Spring Boot 3 | Framework para criar a API |
| Maven | Gerenciar dependências do projeto |
| Swagger/OpenAPI | Documentação interativa da API |

---

## Pré-requisitos

Antes de rodar o projeto, você precisa ter instalado:

- [Java 17+](https://adoptium.net/) — a linguagem do projeto
- [Maven 3.8+](https://maven.apache.org/) — para buildar o projeto
- [Git](https://git-scm.com/) — para clonar o repositório

Para verificar se já tem instalado, rode no terminal:
```bash
java -version
mvn -version
```

---

## Como executar

**1. Clone o repositório**
```bash
git clone https://github.com/PedroH05/SEU-REPOSITORIO.git
cd SEU-REPOSITORIO
```

**2. Build do projeto**
```bash
mvn clean install
```

**3. Rode a aplicação**
```bash
mvn spring-boot:run
```

A API estará disponível em: `http://localhost:8080`

---

## 📖 Endpoints

### `POST /embarques`
Registra um novo embarque.

```json
{
  "valor": 4.50,
  "dataHora": "2024-01-15T10:30:00Z"
}
```

| Resposta | Significa |
|---|---|
| `201 Created` | Embarque registrado com sucesso |
| `422 Unprocessable Entity` | Dados inválidos (ex: valor negativo) |
| `204 No Content` | Embarque mais antigo que 60 segundos, ignorado |

---

### `GET /estatisticas`
Retorna as estatísticas dos embarques dos últimos 60 segundos.

```json
{
  "count": 10,
  "sum": 45.00,
  "avg": 4.50,
  "min": 4.00,
  "max": 5.00
}
```

---

### `DELETE /embarques`
Limpa todos os embarques da memória.

| Resposta | Significa |
|---|---|
| `204 No Content` | Dados apagados com sucesso |

---

## Documentação interativa

Com a aplicação rodando, acesse o Swagger para testar os endpoints pelo navegador:

```
http://localhost:8080/swagger-ui.html
```

---
