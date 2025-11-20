# academiaDev

Sistema de gerenciamento de cursos online desenvolvido em Java, implementando conceitos avançados de Programação Orientada a Objetos, Streams API, Reflection e tratamento de exceções customizadas.

## 📋 Descrição do Projeto

A AcademiaDev é uma plataforma educacional que oferece cursos de tecnologia através de um sistema de assinaturas. O protótipo permite o gerenciamento completo de cursos, usuários, matrículas e suporte técnico, com funcionalidades diferenciadas para administradores e alunos.

## 🏗️ Arquitetura do Sistema

O projeto segue uma arquitetura em camadas bem definida:

```
academiadev/
├── src/com/academiadev/
│   ├── app/              # Classe principal (Main)
│   ├── config/           # Configuração e injeção de dependências
│   ├── controller/       # Controlador CLI
│   ├── dto/              # Data Transfer Objects
│   ├── exception(s)/     # Exceções customizadas
│   ├── model/            # Entidades de domínio
│   ├── repository/       # Interfaces e implementações de repositórios
│   ├── service/          # Lógica de negócio
│   ├── util/             # Utilitários e dados iniciais
│   └── view/             # Interface de usuário (CLI)
```

## 🎯 Funcionalidades Principais

### Para Administradores
- ✅ Gerenciar status de cursos (ativar/inativar)
- ✅ Alterar planos de assinatura dos alunos
- ✅ Atender tickets de suporte (fila FIFO)
- ✅ Gerar relatórios analíticos
- ✅ Exportar dados em formato CSV com seleção dinâmica de campos

### Para Alunos
- ✅ Consultar catálogo de cursos ativos
- ✅ Matricular-se em cursos (respeitando limites do plano)
- ✅ Atualizar progresso de conclusão (0-100%)
- ✅ Cancelar matrículas
- ✅ Abrir tickets de suporte

### Funcionalidades Gerais
- ✅ Autenticação simples por e-mail
- ✅ Sistema de fila FIFO para suporte
- ✅ Validação de regras de negócio

## 🔑 Conceitos Implementados

### Programação Orientada a Objetos
- **Encapsulamento**: Controle de acesso aos dados através de getters/setters
- **Herança**: Hierarquia de `User` → `Admin` e `Student`
- **Polimorfismo**: Interface `SubscriptionPlan` com implementações `BasicPlan` e `PremiumPlan`
- **Abstração**: Classes abstratas e interfaces para estruturação flexível

### Java 8+ e Programação Funcional
- **Streams API**: Todos os relatórios implementados com operações funcionais
- **Lambda Expressions**: Manipulação concisa de coleções
- **Optional**: Tratamento seguro de valores opcionais
- **Method References**: Referências a métodos para código mais limpo

### Estruturas de Dados
- **Map**: Garantia de unicidade para cursos (por título) e usuários (por e-mail)
- **Set**: Listagem de instrutores únicos sem duplicação
- **Queue**: Fila FIFO para tickets de suporte (ArrayDeque)
- **List**: Armazenamento de matrículas

### Reflection e Anotações
- **@CsvColumn**: Anotação customizada para marcar campos exportáveis
- **GenericCsvExporter**: Exportação genérica usando Reflection para leitura dinâmica de campos

## 🚀 Como Executar

### Pré-requisitos
- Java JDK 17 ou superior
- Um ambiente de desenvolvimento Java (Eclipse, IntelliJ IDEA, VSCode)

### Compilação e Execução

#### Via linha de comando:
```bash
# Navegar até o diretório src
cd academiadev/src

# Compilar o projeto
javac com/academiadev/app/Main.java

# Executar
java com.academiadev.app.Main
```

#### Via IDE:
1. Importe o projeto na sua IDE
2. Execute a classe `Main.java` localizada em `com.academiadev.app`

## 👥 Usuários Pré-cadastrados

O sistema inicia com os seguintes usuários de teste:

### Administrador
- **E-mail**: admin@sistemadev.com
- **Nome**: Administrador Geral

### Alunos
| Nome | E-mail | Plano | Matrículas |
|------|--------|-------|------------|
| Marina Souza | marina@email.com | Basic | 2 cursos |
| Lucas Pereira | lucas@email.com | Premium | 3 cursos |
| Fernanda Lima | fernanda@email.com | Basic | 1 curso |
| Rafael Costa | rafael@email.com | Basic | Nenhuma |

### Cursos Disponíveis
1. **Introdução ao Java** (Iniciante, 40h) - Prof. Ana Martins
2. **Spring Boot Completo** (Avançado, 60h) - Prof. Carlos Silva
3. **Python para Análise de Dados** (Intermediário, 50h) - Dra. Júlia Fernandes
4. **História dos Algoritmos** (INATIVO) - Prof. Roberto Antigo

## 📊 Relatórios Disponíveis

O sistema gera os seguintes relatórios analíticos usando Streams API:

1. **Cursos por Dificuldade**: Lista ordenada alfabeticamente por nível
2. **Instrutores Ativos**: Conjunto único de instrutores com cursos ativos
3. **Alunos por Plano**: Agrupamento de estudantes por tipo de assinatura
4. **Média de Progresso**: Cálculo da média geral de conclusão
5. **Aluno Destaque**: Estudante com maior número de matrículas ativas

## 🔒 Regras de Negócio

### Sistema de Matrículas
- **Basic Plan**: Máximo de 3 matrículas em cursos ativos simultaneamente
- **Premium Plan**: Matrículas ilimitadas
- Apenas cursos com status `ACTIVE` aceitam novas matrículas
- Progresso inicia em 0% e pode ser atualizado até 100%
- Progresso não pode retroagir (validação implementada)

### Gestão de Cursos
- Título de curso deve ser único na plataforma
- Cursos inativos não recebem novas matrículas
- Administradores podem alterar status a qualquer momento

### Fila de Suporte
- Atendimento em ordem FIFO (First-In, First-Out)
- Qualquer usuário pode abrir tickets
- Apenas administradores podem processar tickets

### Exportação de Dados
- Seleção dinâmica de campos via anotação `@CsvColumn`
- Formato CSV com separador `;` (ponto e vírgula)
- Escape automático de caracteres especiais

## 🛠️ Tecnologias Utilizadas

- **Java 17+**: Linguagem principal
- **Collections Framework**: Estruturas de dados em memória
- **Streams API**: Operações funcionais
- **Reflection API**: Introspecção dinâmica de classes
- **Custom Annotations**: Marcação de campos exportáveis
- **Exception Handling**: Tratamento robusto de erros

## ⚠️ Exceções Customizadas

O sistema implementa tratamento específico de erros:

- `EnrollmentException`: Violação de regras de matrícula
- `CourseNotFoundException`: Curso não encontrado
- `UserNotFoundException`: Usuário não encontrado
- `CourseAlreadyExistsException`: Tentativa de duplicação de curso
- `UserAlreadyExistException`: E-mail já cadastrado
- `AccessDeniedException`: Tentativa de operação sem permissão
- `ResourceNotFoundException`: Recurso genérico não encontrado

## 📐 Diagrama de Classes

O sistema foi modelado seguindo princípios SOLID, com as seguintes relações principais:

### Hierarquia de Usuários
```
User (abstract)
├── Admin
└── Student
    └── SubscriptionPlan (interface)
        ├── BasicPlan
        └── PremiumPlan
```

### Entidades Principais
- **Course**: Representa cursos com status, dificuldade e instrutor
- **Enrollment**: Associação entre Student e Course com progresso
- **SupportTicket**: Ticket de suporte com timestamp
- **DTOs**: Objetos de transferência para cada entidade

### Camadas de Serviço
- **UserService**: Gerenciamento de usuários e autenticação
- **CourseService**: CRUD e consultas de cursos
- **EnrollmentService**: Lógica de matrículas e progresso
- **ReportService**: Geração de relatórios com Streams
- **SupportTicketService**: Gestão da fila de tickets

## 🎨 Decisões de Design

### 1. Arquitetura em Camadas
Separação clara de responsabilidades entre Model, Repository, Service, Controller e View, facilitando manutenção e testabilidade.

### 2. Uso de DTOs
Evita exposição direta das entidades de domínio, permitindo controle sobre quais dados são transferidos entre camadas.

### 3. Repository Pattern
Abstração do acesso aos dados, facilitando futura migração para persistência em banco de dados.

### 4. Dependency Injection Manual
Classe `AppConfig` centraliza a criação de dependências, simulando um container IoC.

### 5. Validações na Camada de Serviço
Regras de negócio centralizadas nos services, mantendo controllers enxutos.

### 6. Uso de Optional
Retornos de busca usam `Optional` para forçar tratamento explícito de ausência de valores.

### 7. Streams API nos Relatórios
Implementação funcional que torna o código mais legível e declarativo.

### 8. Reflection para CSV
Exportador genérico que funciona com qualquer DTO anotado, seguindo DRY (Don't Repeat Yourself).

## 📝 Exemplo de Uso

### Fluxo de Matrícula
1. Aluno faz login com e-mail
2. Consulta cursos ativos disponíveis
3. Seleciona curso desejado
4. Sistema valida:
   - Curso está ativo?
   - Aluno já está matriculado?
   - Plano permite mais matrículas?
5. Matrícula é criada com progresso 0%
6. Aluno pode atualizar progresso posteriormente

### Fluxo de Exportação CSV
1. Admin acessa menu de exportação
2. Seleciona tipo de dado (Cursos, Usuários, etc.)
3. Escolhe campos desejados dinamicamente
4. Sistema usa Reflection para extrair valores
5. CSV formatado é exibido no console

## 🔄 Melhorias Futuras

- [ ] Persistência em banco de dados relacional
- [ ] API REST para integração com frontend
- [ ] Sistema de autenticação com senha e JWT
- [ ] Notificações por e-mail
- [ ] Dashboard com gráficos de progresso
- [ ] Sistema de avaliações e comentários
- [ ] Certificados de conclusão
- [ ] Gamificação com badges e pontos

## 👨‍💻 Equipe de Desenvolvimento

Este projeto foi desenvolvido como trabalho acadêmico por:

Ana Layslla - https://www.linkedin.com/in/ana-layslla/ & 
Beatriz Mazzucatto - www.linkedin.com/in/beatriz-mazzucatto-seabra

Projeto Acadêmico - IFSP GRU - 2025
Desenvolvido como projeto acadêmico para demonstração de conceitos avançados de Java e POO.

---

**Nota**: Este é um protótipo educacional. A persistência é simulada em memória e os dados são perdidos ao encerrar a aplicação.
