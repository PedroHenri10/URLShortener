🔗 URL Shortener – Encurtador de URL com Expiração Configurável
 
Este projeto é um encurtador de URLs desenvolvido com Spring Boot + MongoDB, incluindo um frontend simples em HTML/CSS/JS e um backend completo com validações, redirecionamento e controle de expiração da URL.
 
 
---
 
🚀 Funcionalidades
 
Encurtamento de qualquer URL válida.
 
Opções de expiração: 30, 45, 60 ou 90 dias.
 
Redirecionamento automático.
 
Exclusão automática de URLs expiradas.
 
Interface simples e responsiva.
 
API REST.
 
 
 
---
 
🛠️ Requisitos
 
Java 17+
 
Maven
 
MongoDB rodando localmente em localhost:27017
 
 
 
---
 
🗄️ Configuração do MongoDB
 
O aplicativo espera que um servidor MongoDB esteja rodando no computador, na porta padrão:
 
mongodb://localhost:27017
 
Por padrão, o Spring Boot tenta conectar automaticamente a:
 
mongodb://localhost:27017/test
 
Se quiser personalizar, crie o arquivo:
 
📄 src/main/resources/application.properties
 
E adicione:
 
spring.data.mongodb.uri=mongodb://localhost:27017/urlshortener
spring.data.mongodb.database=urlshortener
server.port=8080
 
> O Spring Data MongoDB cria automaticamente o banco e as coleções caso não existam.
 
 
 
 
---
 
▶️ Executando a Aplicação
 
Linux / Mac:

 ```
./mvnw spring-boot:run
```
 
Windows:

``` 
mvnw.cmd spring-boot:run
```
 
A aplicação ficará disponível em:
 
👉 http://localhost:8080
 
 
---
 
🌐 Como Usar
 
1. Abra no navegador:
 
http://localhost:8080
 
2. Insira uma URL longa
 
3. Escolha a validade:
 
30 dias
 
45 dias
 
60 dias
 
90 dias
 
 
4. Clique em Encurtar
 
5. Copie a URL curta gerada
 
6. Acesse a URL curta para ser redirecionado
 
Se a URL estiver expirada ou inválida, uma mensagem de erro será exibida.
 
 
---
 
📡 Endpoints da API
 
 
---
 
POST /api/shorten
 
Encurta a URL.
 
Corpo da requisição:
 ```
{
"url": "https://www.example.com/long/path",
  "days": 30
}
```

Resposta 200 OK:
``` 
{
"shortUrl": "http://localhost:8080/r/abc1234"
}
``` 
Erros:
 
{ "error": "The provided URL is not valid." }
 
 
---
 
GET /r/{shortUrl}
 
Redireciona para a URL original.
 
Exemplo:
 
GET /r/abc1234
 
Resposta:
 
302 Found → Redireciona
 
404 Not Found → URL expirada ou não existe
 
 
 
---
 
📁 Estrutura do Projeto
```
URLShortener-main/
├── .mvn/                     
├── mvnw                     
├── mvnw.cmd                  
├── pom.xml                   
├── README.md                 
└── src/
    ├── main/
    │   ├── java/
    │   │   └── com/
    │   │       └── shortener/
    │   │           └── URL/
│ │ ├── UrlApplication.java   # Classe principal da aplicação Spring Boot
    │   │               │
    │   │               ├── controller/           
│ │ │ ├── GlobalExceptionHandler.java 
│ │ │ └── UrlController.java           
    │   │               │
    │   │               ├── dto/                  
│ │ │ └── UrlRequest.java               
    │   │               │
    │   │               ├── exceptions/           
│ │ │ ├── InvalidUrlException.java      
│ │ │ └── UrlNotFoundException.java     
    │   │               │
    │   │               ├── model/               
│ │ │ └── Url.java                      
    │   │               │
    │   │               ├── repository/          
│ │ │ └── UrlRepository.java            
    │   │               │
    │   │               └── services/             
│ │ └── UrlService.java               
    │   │
    │   └── resources/
    │       ├── static/                 
    │       │   ├── index.html          
    │       │   ├── script.js           
    │       │   └── style.css           
    │       │
│ └── application.properties  
    │
    └── test/                  
        └── java/
            └── com/
                └── shortener/
                    └── URL/
└── UrlApplicationTests.java
```
---

## 🔧 Melhorias Futuras
 
- Escolher URL personalizada (ex.: meusite.com/r/meulink)
 
- Dashboard simples mostrando todas as URLs geradas
 
- Contador de cliques para cada URL encurtada
 
- Gerar QR Code automaticamente
 
- Configurar expiração personalizada (não só 30/45/60/90 dias)
 
- Testes unitários e de integração
 
- Deploy em produção (Railway, Render, Heroku, etc.)
 
 
 
---

Autor

💻 Pedro Henrique Nunes

🌐 https://www.linkedin.com/in/p-henrique-nunes
