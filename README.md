# 🏠 Sistema de Gerenciamento de Imobiliária

## 📌 Sobre o Projeto

Este projeto foi desenvolvido como **Trabalho Final da disciplina de Programação II** da Universidade Federal do Sul e Sudeste do Pará (UNIFESSPA).

O objetivo é modelar e implementar um sistema orientado a objetos para o domínio de uma imobiliária, aplicando conceitos fundamentais de **Programação Orientada a Objetos (POO)**, como:

* Abstração
* Encapsulamento
* Herança
* Polimorfismo
* Relacionamentos entre classes

O sistema simula as principais operações de uma imobiliária, incluindo cadastro de imóveis, clientes, funcionários e realização de transações.

---

## 🧠 Modelagem do Sistema (Parte 1)

O sistema foi modelado com base em **Diagrama de Classes UML**, contendo:

* Definição das principais classes do sistema
* Atributos e métodos
* Relacionamentos (associação, agregação, composição e herança)

📎 O diagrama UML está disponível neste repositório.
* [Diagrama UML (PNG)](https://github.com/ElderOFC/TrabalhoFinalProg2/blob/283c0be2ffb87a99ec87f6d498dd91f6ba84b8bf/DiagramaProjetoImobiliaria.png)
* [Diagrama UML (PDF)](https://github.com/ElderOFC/TrabalhoFinalProg2/blob/a657d22101796f93bd0e8ee8ace5c9bad6985a43/DiagramaProjetoImobiliaria.pdf)

---

## ⚙️ Funcionalidades do Sistema (Parte 2)

### 🏡 Gestão de Imóveis

* Cadastro de imóveis para **venda e locação**
* Controle de status:

  * Disponível_Venda
  * Disponível_Locação
  * Vendido
  * Locado
* Registro de:

  * Data de construção
  * Data de cadastro (venda/locação)
  * Endereço completo (com bairro)
  * Valor sugerido

### 🧩 Tipos de Imóveis (Herança)

O sistema utiliza herança para representar os diferentes tipos de imóveis:

* **Casa**
* **Apartamento**
* **Terreno**
* **Sala Comercial**

Cada tipo possui atributos específicos conforme os requisitos do trabalho.

---

### 👥 Gestão de Clientes

#### Cliente Proprietário

* Pode possuir um ou mais imóveis
* Dados armazenados:

  * CPF, nome, endereço
  * Telefones, email
  * Sexo, estado civil, profissão

#### Cliente Usuário

* Responsável por comprar ou alugar imóveis

### 💼 Gestão de Funcionários

* Cadastro de funcionários/corretores
* Dados armazenados:

  * Nome, CPF, endereço
  * Telefones
  * Cargo
  * Data de ingresso
  * Usuario e Senha
  * Meta por vendas ( transações )

### 📄 Transações (Venda e Aluguel)

* Registro completo de transações contendo:

  * Cliente proprietário
  * Cliente usuário
  * Funcionário responsável
  * Imóvel
* Informações registradas:

  * Data da transação
  * Número do contrato (sequencial)
  * Forma de pagamento
  * Valor real negociado

---

## 🛠️ Tecnologias Utilizadas

* **Linguagem:** `Java`
* **Paradigma:** Programação Orientada a Objetos
* **Modelagem:** UML (Diagrama de Classes)
* **Interface:** `Console`

---

## 👨‍💻 Equipe

* [Elder Alencar](https://github.com/ElderOFC)
* [Hudglan Silva]()
* [Raimundo Junior]()
* [Wolliver Rodrigues]()

---

## 🎓 Informações Acadêmicas

* **Instituição:** Universidade Federal do Sul e Sudeste do Pará (UNIFESSPA)
* **Curso:** Sistemas de Informação
* **Disciplina:** Programação II
* **Professor:** Hugo Kuribayashi

---

## 📌 Observações

Este projeto foi desenvolvido para fins acadêmicos, com foco na aplicação prática dos conceitos de Programação Orientada a Objetos e modelagem de sistemas.

---

## ✅ O que foi atendido no trabalho

* ✔ Modelagem UML
* ✔ Uso de classes e relacionamentos
* ✔ Herança e polimorfismo
* ✔ Implementação das regras de negócio
* ✔ Sistema funcional em POO

---
