# 🍽️ BestMealsAPI

BestMeals é uma API REST desenvolvida com **Spring Boot** para gerenciar **restaurantes**, **pratos** e **avaliações de pratos**. Ela permite o cadastro de restaurantes, pratos vinculados e avaliações com nota, comentário e data — ideal para sistemas de recomendação gastronômica.

## 📦 Tecnologias Utilizadas

- Java 17+
- Spring Boot
- Spring Data JPA
- MySQL
- Gradle

## 📌 Funcionalidades

### Restaurante
- 🔍 Listar todos os restaurantes
- 🔍 Buscar restaurante por ID
- ➕ Criar restaurante
- ✏️ Atualizar restaurante
- ❌ Deletar restaurante

### Prato
- 🔍 Listar todos os pratos
- 🔍 Buscar prato por ID (com média de avaliações)
- ➕ Criar prato (vinculado a um restaurante)
- ✏️ Atualizar prato
- ❌ Deletar prato

### Avaliação
- ➕ Criar avaliação para um prato (nota de 0 a 5, comentário e data)

## 📂 Estrutura de Pacotes

```
com.juan.BestMeals
├── controller      # Endpoints da API
├── dto             # Objetos de transferência de dados (DTOs)
├── model           # Entidades JPA
├── repository      # Interfaces JPA para persistência
├── service         # Regras de negócio
```

## 🔧 Como Executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/BestMeals.git
   cd BestMeals
   ```

2. Abra o projeto na sua IDE favorita (como IntelliJ ou VSCode com suporte a Spring).

3. Execute a aplicação com o Spring Boot:
   - Pelo terminal:
     ```bash
     ./mvnw spring-boot:run
     ```
   - Ou pela sua IDE (rodar a classe `BestMealsApplication.java`)

4. Acesse o Postman ou Insomnia para testar a API:
   - Exemplo de rota para criar um restaurante:
     ```
     POST http://localhost:8080/api/restaurantes
     {
       "nome": "Restaurante da Esquina",
       "endereco": "Rua Central, 123",
       "telefone": "11999999999"
     }
     ```

## 🧪 Testando Avaliações no Postman

### Criar Avaliação
```
POST /api/avaliacoes

{
  "pratoId": 1,
  "nota": 4.5,
  "comentario": "Muito saboroso!",
  "dataAvaliacao": "2025-04-04"
}
```

📌 **Nota máxima permitida é 5.0.**

## 🧠 Observações

- A nota da avaliação é validada no backend (não pode ultrapassar 5).
- O campo `média das avaliações` é retornado no `PratoDTO`.

---

Desenvolvido por [Juan Victor](https://github.com/zxo21) 🚀
