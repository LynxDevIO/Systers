# Systers - Sistema de Comunidade Online

<div align="center">

![Java](https://img.shields.io/badge/Java-21-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.3.5-brightgreen)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-15%2B-blue)
![License](https://img.shields.io/badge/License-MIT-green)

</div>

## 📋 Sobre o Projeto
* Projeto desenvolvido para a disciplina de Programação Orientada a Objetos do curso de Análise e Desenvolvimento de Sistemas da PUC-GO.
* Systers é uma plataforma de comunidade online desenvolvida para criar um ambiente seguro e colaborativo para interação e networking entre mulheres. O sistema oferece recursos de gerenciamento de grupos, moderação de conteúdo e interação entre membros.

### 🌟 Principais Funcionalidades

- **Gestão de Grupos**
  - Criação e configuração de grupos de discussão
  - Sistema hierárquico de membros (Administrador, Moderador, Membro)
  - Controle de status de grupos (ativo/inativo)

- **Sistema de Postagens**
  - Compartilhamento de conteúdo em grupos
  - Sistema de comentários
  - Moderação de conteúdo

- **Controle de Acesso**
  - Autenticação segura de usuários
  - Diferentes níveis de permissão
  - Perfis personalizados

- **Sistema de Denúncias**
  - Denúncia de conteúdo inadequado
  - Fluxo de moderação
  - Diferentes categorias de denúncia

## 🚀 Tecnologias Utilizadas

### Backend
- Java 21
- Spring Boot 3.3.5
- Spring Security
- Spring Data JPA
- PostgreSQL

### Frontend
- Thymeleaf
- HTML5/CSS3
- JavaScript

### Ferramentas
- Maven
- Git

## 📦 Pré-requisitos

- JDK 21
- Maven 3.6+
- PostgreSQL 15+
- Git

## 🛠️ Instalação e Configuração

1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/systers.git
   cd systers
   ```

2. Configure o banco de dados:
   - Crie um banco de dados PostgreSQL
   - Atualize o arquivo `src/main/resources/application.properties` com suas credenciais:
     ```properties
     spring.datasource.url=jdbc:postgresql://localhost:5432/systers
     spring.datasource.username=seu_usuario
     spring.datasource.password=sua_senha
     ```

3. Compile e execute o projeto:
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

4. Acesse a aplicação:
   ```
   http://localhost:8080
   ```

## 📚 Documentação

A documentação completa do projeto está disponível em diferentes formatos:

- **Javadoc**: Documentação detalhada das classes e métodos
  ```bash
  mvn javadoc:javadoc
  ```
  Acesse em: `target/site/apidocs/index.html`

- **Maven Site**: Documentação geral do projeto
  ```bash
  mvn site
  ```
  Acesse em: `target/site/index.html`

## 🏗️ Arquitetura

O projeto segue uma arquitetura em camadas:

```
src/main/java/dev/team/systers/
├── controller/    # Controladores REST
├── service/       # Lógica de negócios
├── repository/    # Acesso a dados
├── model/         # Entidades
├── config/        # Configurações
└── exception/     # Tratamento de erros
```

## 🤝 Contribuindo

1. Fork o projeto
2. Crie uma branch para sua feature (`git checkout -b feature/AmazingFeature`)
3. Commit suas mudanças (`git commit -m 'Add some AmazingFeature'`)
4. Push para a branch (`git push origin feature/AmazingFeature`)
5. Abra um Pull Request

## 📝 Licença

Este projeto está sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.


## 📧 Contato

### Philipe Pedrosa
- Email: dev.lynx.io@gmail.com
- LinkedIn: [Philipe Pedrosa](https://www.linkedin.com/in/philipe-afonso-m-910b5a202/)
- GitHub: [@LynxDevIO](https://github.com/LynxDevIO) 

### Pedro Henrique
- Email: pedrosousxs@gmail.com
- LinkedIn: [Pedro Henrique](https://www.linkedin.com/in/sousxs/)
- GitHub: [@Sousxs](https://github.com/Sousxs)

### João Pedro
- Email: joaopedroaraujosilvabarbosa@gmail.com
- LinkedIn: [João Pedro](www.linkedin.com/in/joãopedro-sb)
- GitHub: [@jhonzito66](https://github.com/jhonzito66/)
