# PitRegex

PitRegex é um projeto desenvolvido como parte do Projeto Integrador Transdisciplinar do segundo semestre do curso de
Análise e Desenvolvimento de Sistemas da Universidade Cruzeiro do Sul.

## Descrição

O objetivo deste projeto é utilizar expressões regulares (regex) em um contexto de validação de e-mails e reagrupamento
de datas. O projeto foi implementado usando a linguagem Java e o framework Spring MVC.

## Situação-Problema

O projeto aborda duas situações-problema:

1. Validação de E-mails: O objetivo é verificar se um texto contém endereços de e-mail e extrair esses endereços. Foi
   desenvolvida uma lógica utilizando regex para identificar e retornar os endereços de e-mail presentes no texto.

2. Reagrupamento de Datas: O objetivo é converter datas no formato EUA (YYYY-MM-DD) para o formato BR (DD/MM/YYYY).
   Utilizando regex, foi implementada uma lógica para identificar as datas no formato EUA no texto e transformá-las para
   o formato BR.

## Estrutura do Projeto

O projeto foi estruturado seguindo o padrão MVC (Model-View-Controller) e contém os seguintes componentes:

- Model: A classe `Regex` define o modelo de objeto com a API `java.util.regex.Pattern` para encapsular as expressões
  regulares utilizadas em `RegexService` para
  a validação de e-mails e reagrupamento de datas. Foi utilizado um padrão Builder para facilitar a construção dessas
  expressões regulares.

- Service: A classe `RegexService` contém a lógica de aplicação, incluindo métodos para buscar padrões regex no texto,
  realizar transformações de datas e retornar os padrões regex utilizados.

- Controller: O controlador `RegexController` expõe a funcionalidade do projeto como uma API JSON. Ele define rotas para
  obter os padrões regex utilizados, filtrar e retornar os resultados das validações de e-mail e reagrupamento de datas.

- Testes: Foram criados testes unitários utilizando JUnit para garantir a corretude da implementação. Os testes
  verificam os padrões regex implementados da classe `RegexService`.

## Instruções para Execução

Para executar este projeto, é necessário ter o Java 17 instalado em sua máquina. Em seguida, faça o download do arquivo
.jar disponível na seção de releases do repositório.

Para executar o projeto, abra o terminal na pasta em que o arquivo .jar foi baixado e execute o seguinte comando:

```
java -jar pit_regex-0.0.1.jar
```

Após executar o comando acima, o servidor será iniciado e o projeto estará disponível na URL `http://localhost:8080`.

Além disso, o projeto conta com uma documentação Swagger, que pode ser acessada pelo seguinte
endereço: `http://localhost:8080/swagger-ui/index.html`. Lá você poderá consultar informações sobre as rotas disponíveis
na API e testar suas funcionalidades.
