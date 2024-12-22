# Projeto Api Banco de Sangue

## Descrição do Projeto

Este projeto foi desenvolvido utilizando **Java 21** e visa processar dados de doares. Implementamos a **Clean
Architecture** para estruturar de forma organizada e desacoplada os diferentes módulos do projeto, garantindo facilidade
de manutenção e escalabilidade.

---

## Tecnologias Utilizadas

- **Java 21:** Linguagem de programação do projeto.
- **Spring Boot:** Framework Utilizado.
- **Spring Data JPA:** Framework para gerenciamento do banco de dados.
- **Spring MVC:** Biblioteca para desenvolvimento do serviço REST.
- **Lombok:** Biblioteca para reduzir boilerplate em classes Java ao automatizar a geração de getters, setters,
  construtores, etc.
- **Docker Compose Support (Spring):** Utilizado para integração simplificada entre o serviço e o banco de dados,
  eliminando a necessidade de configurações manuais complexas.
- **MySQL:** Banco de dados relacional utilizado no backend.
- **Gradle (com Gradlew):** Ferramenta de automação de build que simplifica a compilação, teste e execução do projeto.

---

## Arquitetura do Projeto

<img src="clean_img.png" alt="Arquitetura do Projeto" width="300" style="display: block; margin: auto;">

Este projeto foi desenvolvido utilizando os princípios da **Clean Architecture**, que organiza a aplicação em camadas,
separando responsabilidades para facilitar o entendimento do código e melhorar a manutenibilidade. Abaixo uma explicação
das principais camadas:

### Camadas Principais

1. **Entities (Domínio):**
    - Contém as regras de negócio e entidades fundamentais. Essa camada é independente de qualquer framework ou
      tecnologia.

2. **Use Cases:**
    - Implementa os casos de uso específicos do projeto. Aqui é onde a lógica do que a aplicação deve fazer é
      implementada.

3. **Interface Adapters:**
    - Faz a conversão de dados entre as camadas de domínio e as interfaces primárias (controllers, gateways). Por
      exemplo, transformar inputs HTTP em objetos de negócio.

4. **Infraestrutura:**
    - Contém as implementações de frameworks e serviços externos, como o repositório do banco de dados utilizando Spring
      Data JPA.

---

## Endpoints da API

A API expõe os seguintes endpoints:

### 1. **Buscar Compatibilidade por Tipo Sanguíneo**

- **URL:** `public/api/blood-types/compatibility`
- **Método:** `GET`
- **Descrição:** Retorna a lista com o total de doadores possíveis para cada tipo sanguíneo receptor.
- **Exemplo de Resposta (JSON):**
  ```json
  [
    { "bloodType": "O_NEGATIVE", "totalRecipient": 100 },
    { "bloodType": "O_POSITIVE", "totalRecipient": 200 },
    { "bloodType": "A_NEGATIVE", "totalRecipient": 80 },
    { "bloodType": "A_POSITIVE", "totalRecipient": 120 }
  ]
  ```

### 2. **Listar Todos os Doadores**

- **URL:** `public/api/donor/all`
- **Método:** `GET`
- **Descrição:** Retorna uma lista de todos os doadores cadastrados no sistema.
- **Exemplo de Resposta (JSON):**
  ```json
  [
       {
         "name": "Milena Analu Pires",
         "birthDate": [
           1964,
           5,
           23
         ],
         "gender": "Feminino",
         "number": 675,
         "city": "Teófilo Otoni",
         "state": "MG",
         "height": 1.53,
         "weight": 80,
         "bloodType": "O-"
       },
       {
         "name": "Marcos Vinicius Kevin Samuel Santos",
         "birthDate": [
           1992,
           9,
           7
         ],
         "gender": "Masculino",
         "number": 634,
         "city": "Aracaju",
         "state": "SE",
         "height": 1.92,
         "weight": 95,
         "bloodType": "O-"
       }
  ]
  ```

### 3. **Cadastrar Novo Doador**

- **URL:** `public/api/donor/save`
- **Método:** `POST`
- **Descrição:** Cadastra um novo doador no sistema.
    - **Body de Exemplo:**
     ```json
      [
   
        {	
            "nome": "Milena Analu Pires",
            "cpf": "775.256.099-50",
            "rg": "44.084.541-5",
            "data_nasc": "23\/05\/1964",
            "sexo": "Feminino",
            "mae": "Isadora Marli",
            "pai": "Noah Severino César Pires",
            "email": "mmilenaanalupires@keffin.com.br",
            "cep": "39801-678",
            "endereco": "Rua Kurt W. Rothe",
            "numero": 675,
            "bairro": "Castro Pires",
            "cidade": "Teófilo Otoni",
            "estado": "MG",
            "telefone_fixo": "(33) 3611-4613",
            "celular": "(33) 98481-0191",
            "altura": 1.53,
            "peso": 80,
            "tipo_sanguineo": "O-"
        }
      ]
  ```

- **Exemplo de Resposta (JSON):**
  ```json
  {
    "code": 201,
    "message": "Registered with successfully" 
  }
  ```

## Executando o Projeto

### Pré-requisitos

- **Java 21:** Certifique-se de ter o Java 21 instalado na máquina.
- **Docker:** O Docker deve estar instalado para que o banco de dados seja iniciado automaticamente.

### Passos para Execução

1. Clone este repositório:
   ```bash
   git clone <https://github.com/GuiParpineli/donors-api.git>
   cd <donors-api>
   ```

2. Conceda permissão para o executável `gradlew` (caso necessário):
   ```bash
   chmod +x gradlew
   ```

3. Compile o projeto:
   ```bash
   ./gradlew build
   ```

4. Execute o projeto diretamente com Gradle:
   ```bash
   ./gradlew bootRun
   ```

---

### Banco de Dados com Docker

Este projeto utiliza **Spring Boot Docker Compose Support**, ou seja, quando o projeto é iniciado (via Gradle ou IDE), o
banco de dados MySQL é automaticamente inicializado em um contêiner Docker. Não é necessário executar configurações
adicionais para o banco de dados.

O Docker Compose está configurado no projeto para subir um contêiner MySQL com os seguintes detalhes:

- **Host:** `localhost`
- **Porta:** `3306`
- **Database:** `my_database`
- **Usuário:** `root`
- **Senha:** `verysecret`

Se desejar fazer conexões independentes com o banco de dados, certifique-se de que o Docker esteja em execução.

---

### Testando o Código

Para rodar todos os testes automatizados (se existentes), use:

```bash
./gradlew test
```

---

### Estrutura de Pacotes

Abaixo está um breve resumo da organização dos pacotes do projeto seguindo o modelo de Clean Architecture:

```plaintext
src/
├── domain/          # Regras de negócio e entidades
├── usecases/        # Casos de uso específicos
├── adapters/        # Adaptadores de interface (controladores, gateways)
├── infrastructure/  # Configurações e implementação de frameworks
```

---
