# Arquitetura — Calculadora Financeira

## 1. Visão geral

A **Calculadora Financeira** é uma aplicação desenvolvida em **Java puro**, executada inicialmente pelo terminal.

O projeto tem dois objetivos principais:

1. Desenvolver uma calculadora financeira funcional.
2. Utilizar o desenvolvimento do projeto como meio de aprendizagem e aplicação prática dos fundamentos da linguagem Java.

A aplicação será construída de forma incremental. Novas funcionalidades e conceitos poderão ser adicionados conforme o projeto evoluir e houver necessidade.

---

## 2. Objetivos de aprendizagem

Durante o desenvolvimento, o projeto será utilizado para praticar e consolidar conceitos como:

* Sintaxe e fundamentos de Java;
* Variáveis e tipos de dados;
* Operadores;
* Estruturas condicionais;
* Estruturas de repetição;
* Métodos;
* Parâmetros e valores de retorno;
* Classes e objetos;
* Encapsulamento;
* Organização em pacotes;
* Separação de responsabilidades;
* Tratamento de exceções;
* Coleções;
* Manipulação de arquivos;
* Outros conceitos de Java que sejam introduzidos conforme a evolução do projeto.

O código deverá ser compreendido pela desenvolvedora. A implementação não deve priorizar apenas o funcionamento, mas também a compreensão das decisões tomadas.

---

## 3. Estrutura do projeto

A estrutura inicial será:

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

A estrutura poderá ser modificada futuramente caso novas necessidades técnicas justifiquem sua alteração.

Não serão adicionadas camadas, classes ou pastas apenas por convenção. Toda alteração estrutural deverá possuir uma justificativa relacionada ao funcionamento, manutenção ou evolução do projeto.

---

## 4. Responsabilidades

### 4.1 `Main.java`

É o ponto de entrada da aplicação.

Sua responsabilidade principal é iniciar o programa e entregar o controle para o componente responsável pelo fluxo da aplicação.

O `Main` não deverá concentrar:

* cálculos financeiros;
* leitura de todas as entradas;
* regras de negócio;
* lógica completa do menu.

Fluxo conceitual:

```text
Main
 ↓
Inicialização da aplicação
 ↓
Menu
```

---

### 4.2 `ui/Menu.java`

Responsável pela interação principal com o usuário através do terminal.

Suas responsabilidades incluem:

* Exibir o menu;
* Apresentar as opções disponíveis;
* Receber a escolha do usuário;
* Direcionar a execução para a operação correspondente;
* Solicitar a apresentação dos resultados;
* Controlar o retorno ao menu principal.

O `Menu` não deverá ser responsável pela implementação das fórmulas financeiras.

---

### 4.3 `calculos/CalculadoraFinanceira.java`

Responsável pelas regras matemáticas e cálculos financeiros da aplicação.

A classe deverá concentrar os métodos responsáveis por operações como:

```text
Porcentagem
Acréscimo percentual
Desconto percentual
Juros simples
Juros compostos
```

A classe deverá receber os dados necessários para realizar cada cálculo e retornar o resultado correspondente.

Ela não deverá ser responsável por:

* solicitar dados diretamente ao usuário;
* controlar o menu;
* apresentar a interface do terminal.

Dessa forma, as regras de negócio ficam separadas da interação com o usuário.

---

### 4.4 `util/EntradaDados.java`

Responsável pela leitura e validação de dados fornecidos pelo usuário.

Poderá centralizar funcionalidades como:

```text
Leitura de números inteiros
Leitura de números decimais
Leitura de textos
Validação de entradas
```

A centralização da entrada de dados evita a repetição desnecessária de código e mantém a responsabilidade de leitura separada das regras de negócio.

---

## 5. Separação de responsabilidades

A aplicação seguirá, inicialmente, uma divisão simples de responsabilidades:

```text
             Main
              │
              ▼
            Menu
           /    \
          ▼      ▼
EntradaDados   CalculadoraFinanceira
          \      /
           ▼    ▼
          Resultado
              │
              ▼
             Menu
```

A ideia central é evitar que uma única classe seja responsável por todo o funcionamento do programa.

### Princípio utilizado

Cada componente deve possuir uma responsabilidade clara.

Por exemplo:

* `Menu` → interação;
* `EntradaDados` → entrada e validação;
* `CalculadoraFinanceira` → cálculos;
* `Main` → inicialização.

Essa separação deverá facilitar a compreensão, manutenção e expansão do projeto.

---

## 6. Escopo da V1

A primeira versão da aplicação terá as seguintes operações:

```text
1. Porcentagem
2. Acréscimo percentual
3. Desconto percentual
4. Juros simples
5. Juros compostos
0. Sair
```

### 6.1 Porcentagem

Deverá calcular determinado percentual de um valor.

Fórmula:

```text
resultado = valor × percentual / 100
```

Exemplo:

```text
10% de R$ 500

500 × 10 / 100 = 50
```

---

### 6.2 Acréscimo percentual

Deverá calcular o valor final após adicionar determinado percentual ao valor original.

Conceitualmente:

```text
acréscimo = valor × percentual / 100

resultado = valor + acréscimo
```

---

### 6.3 Desconto percentual

Deverá calcular o valor final após aplicar determinado desconto percentual.

Conceitualmente:

```text
desconto = valor × percentual / 100

resultado = valor - desconto
```

---

### 6.4 Juros simples

Será utilizada a fórmula:

```text
J = C × i × t
```

Onde:

```text
J = juros
C = capital inicial
i = taxa de juros
t = período
```

O montante será calculado por:

```text
M = C + J
```

A implementação deverá considerar corretamente as unidades utilizadas para taxa e período.

---

### 6.5 Juros compostos

Será utilizada a fórmula:

```text
M = C × (1 + i)^t
```

Onde:

```text
M = montante
C = capital inicial
i = taxa de juros
t = período
```

Os juros serão obtidos por:

```text
J = M - C
```

A implementação deverá considerar corretamente as unidades utilizadas para taxa e período.

---

## 7. Validação de dados

A aplicação deverá possuir validações básicas para evitar entradas inválidas ou incompatíveis com os cálculos.

Entre os casos previstos:

### Entrada não numérica

Quando o programa espera um número e o usuário fornece um valor incompatível, o programa deverá informar o erro e permitir uma nova entrada.

Exemplo:

```text
Entrada inválida.
Digite um número válido.
```

### Valores incompatíveis

Valores que não façam sentido para determinada operação deverão ser tratados.

Exemplo:

```text
O valor deve ser maior que zero.
```

As regras exatas de validação serão definidas durante a implementação de cada operação, de acordo com suas características.

O tratamento de exceções será introduzido conforme necessário, servindo também como parte do aprendizado de Java.

---

## 8. Fluxo geral da aplicação

O funcionamento geral esperado é:

```text
Início
  ↓
Main
  ↓
Exibição do menu
  ↓
Usuário escolhe uma operação
  ↓
Programa solicita os dados necessários
  ↓
EntradaDados recebe e valida os dados
  ↓
CalculadoraFinanceira realiza o cálculo
  ↓
Resultado é retornado
  ↓
Resultado é apresentado ao usuário
  ↓
Retorno ao menu principal
  ↓
Nova operação
  │
  └───────────────┐
                  ↓
             Usuário escolhe 0
                  ↓
              Encerramento
```

A aplicação deverá permanecer em execução enquanto o usuário não escolher a opção de saída.

---

## 9. Comunicação entre componentes

A comunicação inicial seguirá o seguinte conceito:

```text
Main
 ↓
Menu
 ↓
EntradaDados
 ↓
Menu
 ↓
CalculadoraFinanceira
 ↓
Menu
```

O fluxo exato poderá variar conforme a implementação de cada funcionalidade.

A regra geral será manter as responsabilidades separadas, evitando que:

* cálculos sejam realizados diretamente no menu;
* entrada de dados fique espalhada pelas regras de negócio;
* o `Main` concentre a lógica da aplicação.

---

## 10. Escopo fora da V1

A primeira versão não terá:

* Interface gráfica;
* Banco de dados;
* Persistência de dados;
* Sistema de login;
* Integrações externas;
* API;
* Sistema de usuários;
* Histórico persistente de cálculos;
* Funcionalidades financeiras avançadas.

Essas funcionalidades não estão descartadas para versões futuras. Apenas não fazem parte do escopo inicial.

---

## 11. Evolução do projeto

O projeto poderá evoluir progressivamente conforme novos conhecimentos forem adquiridos.

Possíveis evoluções incluem:

```text
V1
Calculadora financeira básica
        ↓
V2
Novas operações financeiras
        ↓
V3
Histórico de cálculos
        ↓
V4
Persistência em arquivos
        ↓
V5
Banco de dados
        ↓
V6
Interface gráfica ou aplicação web
```

As versões futuras não serão implementadas antecipadamente. Cada nova funcionalidade será analisada quando houver necessidade e conhecimento suficiente para incorporá-la de maneira consciente.

---

## 12. Princípios de desenvolvimento

O projeto seguirá os seguintes princípios:

### 12.1 Compreensão antes da implementação

O código deverá ser compreendido pela desenvolvedora.

Não basta saber que determinada solução funciona. Deve-se compreender:

* o que o código faz;
* por que ele funciona;
* por que aquela estrutura foi escolhida;
* quais alternativas existiriam;
* quais consequências uma alteração poderia causar.

### 12.2 Complexidade justificada

Novas classes, pastas, abstrações ou padrões não deverão ser adicionados apenas por convenção.

Toda complexidade introduzida deverá resolver algum problema real ou contribuir diretamente para o aprendizado.

### 12.3 Desenvolvimento incremental

O projeto será construído em pequenas etapas funcionais.

Uma nova funcionalidade deverá ser implementada, testada e compreendida antes da próxima etapa.

### 12.4 Evolução baseada em necessidade

A arquitetura poderá ser modificada conforme o projeto crescer.

Uma decisão tomada na V1 não será considerada permanente se uma necessidade futura justificar sua revisão.

---

## 13. Estratégia de desenvolvimento

O desenvolvimento seguirá, de maneira geral, esta sequência:

```text
1. Definir arquitetura
        ↓
2. Criar estrutura do projeto
        ↓
3. Implementar inicialização
        ↓
4. Implementar menu
        ↓
5. Implementar entrada de dados
        ↓
6. Implementar primeira operação
        ↓
7. Testar
        ↓
8. Implementar próxima operação
        ↓
9. Implementar validações
        ↓
10. Testar novamente
        ↓
11. Refatorar quando necessário
```

Durante a implementação, cada conceito novo de Java deverá ser explicado antes ou no momento em que for utilizado.

O objetivo não é apenas concluir a calculadora, mas utilizar sua construção para desenvolver competência prática em Java.
