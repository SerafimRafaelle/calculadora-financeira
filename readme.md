# Calculadora Financeira

Uma aplicação de linha de comando desenvolvida em **Java** para realizar cálculos financeiros básicos de forma interativa, com foco em organização de código, separação de responsabilidades e validação de entradas.

> Projeto desenvolvido como parte do meu processo de aprendizagem em Java, aplicando conceitos de programação orientada a objetos, organização de projetos e desenvolvimento incremental.

---

## Funcionalidades

A versão atual oferece as seguintes operações:

| Operação                 | Descrição                                           |
| ------------------------ | --------------------------------------------------- |
| **Porcentagem**          | Calcula uma porcentagem sobre determinado valor     |
| **Acréscimo percentual** | Calcula o valor final após um acréscimo percentual  |
| **Desconto percentual**  | Calcula o valor final após um desconto percentual   |
| **Juros simples**        | Calcula juros pelo regime de capitalização simples  |
| **Juros compostos**      | Calcula juros pelo regime de capitalização composta |

Além dos cálculos, a aplicação possui **validação das entradas fornecidas pelo usuário**, evitando valores incompatíveis com as regras definidas para a aplicação.

---

## Tecnologias

* **Java**
* **Java Standard Library**
* **Scanner** para entrada de dados pelo terminal
* **Git**
* **GitHub**

O projeto não utiliza frameworks ou bibliotecas externas.

---

## Arquitetura

A aplicação foi estruturada com separação de responsabilidades entre seus componentes:

```text
Main
  │
  ▼
Menu
  │
  ▼
EntradaDados
  │
  ▼
CalculadoraFinanceira
```

### Componentes

**`Main.java`**

Responsável pelo ponto de entrada da aplicação e pela inicialização do programa.

**`ui/Menu.java`**

Responsável pela interação com o usuário, exibição do menu, solicitação dos dados e apresentação dos resultados.

**`util/EntradaDados.java`**

Centraliza a leitura e validação dos dados fornecidos pelo usuário.

**`calculos/CalculadoraFinanceira.java`**

Concentra as regras matemáticas e financeiras utilizadas pelos cálculos.

A documentação detalhada das decisões arquiteturais está disponível em [`arquitetura.md`](arquitetura.md).

---

## Validação de dados

A aplicação diferencia a validação do **tipo de entrada** da validação do **valor permitido**.

### Inteiros

```text
lerInteiro()
```

Verifica se a entrada corresponde a um número inteiro.

```text
lerInteiroPositivo()
```

Além de verificar o tipo, garante que o valor seja maior que zero.

É utilizado, por exemplo, para representar a quantidade de meses dos cálculos de juros.

### Números decimais

```text
lerDecimal()
```

Verifica se a entrada corresponde a um número válido.

```text
lerDecimalNaoNegativo()
```

Garante que o número seja maior ou igual a zero.

Essa validação é utilizada para valores financeiros, percentuais, capitais e taxas.

---

## Fórmulas utilizadas

### Porcentagem

```text
resultado = valor × percentual / 100
```

### Acréscimo percentual

```text
acréscimo = valor × percentual / 100

resultado = valor + acréscimo
```

### Desconto percentual

```text
desconto = valor × percentual / 100

resultado = valor - desconto
```

### Juros simples

```text
J = C × i × t

M = C + J
```

Onde:

* `J` = juros
* `C` = capital
* `i` = taxa de juros
* `t` = tempo
* `M` = montante

### Juros compostos

```text
M = C × (1 + i)^t

J = M - C
```

Na aplicação, as taxas são informadas pelo usuário em **porcentagem** e convertidas internamente para sua representação decimal.

Na versão atual, o tempo dos cálculos de juros é representado em **meses inteiros**, e a taxa utilizada é mensal.

---

## Exemplo de utilização

Ao iniciar a aplicação, o usuário encontra o menu principal:

```text
=== CALCULADORA FINANCEIRA ===
1. Porcentagem
2. Acréscimo percentual
3. Desconto percentual
4. Juros simples
5. Juros compostos
0. Sair
```

### Exemplo — Juros compostos

```text
Digite o capital:
1000

Digite a taxa mensal (%):
10

Digite o tempo (meses):
2

Juros: 210.0
Montante: 1210.0
```

---

## Como executar

### Pré-requisitos

É necessário possuir:

* **JDK instalado**
* **Git**, caso o projeto seja obtido através do repositório

### Execução

Clone o repositório:

```bash
git clone <URL_DO_REPOSITORIO>
```

Entre na pasta do projeto:

```bash
cd calculadora-financeira
```

Compile os arquivos Java:

```bash
javac -d out src/Main.java src/ui/Menu.java src/calculos/CalculadoraFinanceira.java src/util/EntradaDados.java
```

Execute a aplicação:

```bash
java -cp out Main
```

> A classe `Main` é o ponto de entrada da aplicação. As demais classes são componentes utilizados durante a execução.

---

## Estrutura do projeto

```text
calculadora-financeira/
│
├── src/
│   ├── Main.java
│   │
│   ├── ui/
│   │   └── Menu.java
│   │
│   ├── calculos/
│   │   └── CalculadoraFinanceira.java
│   │
│   └── util/
│       └── EntradaDados.java
│
├── README.md
└── Arquitetura.md
```

---

## Objetivos de aprendizagem

Este projeto está sendo desenvolvido com foco não apenas no funcionamento da aplicação, mas também na compreensão dos conceitos utilizados durante sua construção.

Entre os principais objetivos estão:

* desenvolver aplicações em Java;
* compreender classes, métodos e modificadores de acesso;
* trabalhar com tipos primitivos;
* utilizar estruturas condicionais e de repetição;
* compreender métodos `static`;
* trabalhar com entrada de dados através de `Scanner`;
* aplicar validação de entradas;
* praticar separação de responsabilidades;
* organizar um projeto em diferentes pacotes;
* utilizar Git e GitHub durante o desenvolvimento;
* desenvolver e testar funcionalidades de forma incremental.

---

## Evolução do projeto

O projeto está sendo desenvolvido de forma incremental.

### V1 — Calculadora Financeira

* [x] Estrutura inicial
* [x] Menu interativo
* [x] Entrada e validação de dados
* [x] Porcentagem
* [x] Acréscimo percentual
* [x] Desconto percentual
* [x] Juros simples
* [x] Juros compostos
* [x] Documentação da arquitetura

### Possíveis evoluções

Novas funcionalidades poderão ser incorporadas conforme a necessidade do projeto e o avanço dos estudos, como:

* histórico de cálculos;
* novas operações financeiras;
* conversão de taxas;
* cálculos de financiamento;
* persistência de dados;
* interface gráfica;
* integração com banco de dados.

Essas funcionalidades não fazem parte da versão atual.

---

## Documentação

Para conhecer as decisões técnicas e arquiteturais utilizadas no desenvolvimento:

**[`arquitetura.md`](arquitetura.md)**

---

## Status

**Versão 1.0 — Em desenvolvimento**

A primeira versão funcional da aplicação já possui as principais operações financeiras definidas para o escopo inicial, além de validação básica das entradas fornecidas pelo usuário.
