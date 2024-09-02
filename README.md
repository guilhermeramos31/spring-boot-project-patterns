# Desafio de Projeto: Arquitetura com Spring Boot e Padrões de Projeto

Este repositório contém a solução para o desafio do bootcamp **Cognizant - Arquitetura com Spring Boot e Cloud** da Digital Innovation One (DIO). O objetivo deste desafio é aplicar os conceitos de Padrões de Projeto usando o Spring Boot, criando uma solução prática para demonstrar seu entendimento e domínio sobre o tema.

## Descrição do Desafio

Neste desafio, você deve criar uma solução que explore o conceito de Padrões de Projeto na prática. Você pode escolher entre reproduzir um dos projetos que foram criados durante as aulas ou, caso se sinta preparado, desenvolver uma nova ideia do zero.

### Requisitos

- Utilizar o **Spring Boot** como framework principal.
- Implementar pelo menos **dois padrões de projeto** na solução.
- O projeto deve seguir uma arquitetura bem definida e organizada.
- Documentar o código e o projeto em um **README** claro e objetivo.

## Padrões de Projeto Implementados

Nesta solução, foram implementados os seguintes padrões de projeto:

1. **Singleton**: Para garantir que uma classe tenha apenas uma instância e fornecer um ponto de acesso global a ela.
2. **Strategy**: Para definir uma família de algoritmos, encapsulá-los e torná-los intercambiáveis. O padrão Strategy permite que o algoritmo varie independentemente dos clientes que o utilizam.
3. **Factory Method**: Para criar objetos sem especificar a classe exata do objeto que será criado.

### Estrutura do Projeto

O projeto está organizado da seguinte forma:

- `src/main/java`: Código fonte da aplicação.
  - `configuration`: Contém as classes de configuração da aplicação.
  - `controller`: Contém os controladores REST.
  - `service`: Contém a lógica de negócios da aplicação.
    - `interfaces`: Contém as interfaces que definem contratos para os serviços.  
  - `model`: Contém as classes de modelo.
    - `dto`: Contém os Data Transfer Objects utilizados para a troca de dados entre camadas.
    - `mapper`: Contém classes responsáveis por mapear dados entre diferentes representações, como entidades e DTOs.
  - `repository`: Contém a interface para persistência de dados.
    - `interfaces`: Contém as interfaces que definem contratos para os repository.
- `src/main/resources`: Contém arquivos de configuração e outros recursos.

### Tecnologias Utilizadas

- Java 17+
- Spring Boot
- Spring Data JPA
- H2 Database (ou outro banco de dados à sua escolha)
- Maven

## Como Executar o Projeto

1. **Clone o Repositório:**
   ```bash
   git clone https://github.com/seu-usuario/seu-repositorio.git
3. **Navegue até o Diretório do Projeto:**
   ```bash
   cd seu-repositorio
4. **Execute o Projeto.**
5. **Acesse a Aplicação: Abra o navegador e acesse http://localhost:8080.**
