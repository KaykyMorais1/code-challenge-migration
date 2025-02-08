# DummyJSON Client - Java 17 e Spring Boot 3.2.5
📌 Descrição
Este microsserviço Java consome a API DummyJSON para buscar produtos. O projeto foi migrado de Java 8 / Spring Boot 2.6.x para Java 17 / Spring Boot 3.2.5, com diversas melhorias.

# 📌 O Que Foi Resolvido?
✅ Spring Boot atualizado para 3.2.5
✅ Substituição do RestTemplate por WebClient
✅ JUnit 4 / Mockito removido
✅ Testes de integração com @SpringBootTest e WebTestClient
✅ URL da API parametrizada no application.yml
✅ Novo endpoint /health para monitoramento
✅ Projeto containerizado com Docker

# 📌 Como Executar?
Após clonar o projeto, execute os seguintes comandos:

- *mvn clean install*
- *mvn clean package*
- *mvn spring-boot:run*

Para rodar no docker:
- *docker-compose up*

# 📌 Testes
- *mvn clean test*

# 📌 Estrutura
dummyjson-client
├── Dockerfile ✅ (Novo, para containerização)
├── docker-compose.yml ✅ (Novo, para orquestração)
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com.example.dummyjsonclient
│   │   │       ├── DummyJsonClientApplication.java
│   │   │       ├── config
│   │   │       │   ├── WebClientConfig.java  ✅ (Novo, substitui RestTemplateConfig)
│   │   │       ├── controller
│   │   │       │   ├── ProductController.java
│   │   │       │   ├── Health.java ✅ (Novo, para monitoramento)
│   │   │       ├── dto
│   │   │       │   ├── Product.java
│   │   │       ├── service
│   │   │       │   ├── ProductService.java ✅ (Atualizado para usar WebClient)
│   │   └── resources
│   │       ├── application.yml ✅ (Agora com API_URL parametrizada)
│   └── test
│       ├── java
│       │   └── com.example.dummyjsonclient
│       │       ├── integration
│       │       │   ├── ProductIntegratedTest.java ✅ (Novo, testes de integração reais)
│       └── resources
└── pom.xml ✅ (Atualizado para Java 17 e Spring Boot 3.2.5)
