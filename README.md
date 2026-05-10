# 🚚 Sistema de Logística para Entregas

## 👥 Integrantes
- Enzo Augusto — RM562249  
- Gustavo Neres — RM561785  
- Rafael Santiago — RM563486  

---

## 🎯 Objetivo do Projeto
O objetivo deste projeto foi desenvolver um sistema simples de logística para entregas de e-commerce utilizando os conceitos de Programação Orientada a Objetos em Java. O sistema simula o funcionamento básico de uma operação logística, onde é possível cadastrar entregadores, criar pedidos de entrega, atribuir entregas para entregadores e atualizar o status das entregas.

Além do funcionamento do sistema, o principal foco do projeto foi aplicar corretamente os conceitos de herança, interfaces, classes abstratas, sobrescrita, sobrecarga e encapsulamento.

---

## 🧠 Respostas das Perguntas

### 🔹 1. Herança
A herança foi utilizada no sistema para representar os diferentes tipos de entregadores.

Criamos uma classe abstrata chamada `Entregador`, que possui os atributos e métodos em comum entre todos os entregadores, como id, nome e veículo.

Depois criamos as classes:
- `EntregadorMoto`
- `EntregadorBicicleta`

Essas classes herdam de `Entregador`, evitando repetição de código e deixando o sistema mais organizado.

---

### 🔹 2. Interface
A interface criada no sistema foi a `Entregavel`.

Ela foi utilizada para representar um comportamento comum relacionado às entregas, no caso o cálculo do tempo estimado da entrega.

A vantagem da interface é deixar definido quais métodos uma classe precisa obrigatoriamente implementar.

---

### 🔹 3. Classe Abstrata
A classe abstrata utilizada foi a classe `Entregador`.

Ela foi criada para representar um entregador de forma genérica, contendo informações comuns entre todos os tipos de entregadores.

Ela não poderia ser uma classe comum porque no sistema não faz sentido criar apenas um “entregador genérico”, já que todo entregador precisa possuir um tipo específico de veículo.

---

### 🔹 4. Sobrescrita de Métodos
A sobrescrita foi utilizada nos métodos:
- `calcularTempo()`
- `calcularCusto()`

Cada tipo de entregador possui regras diferentes para calcular o tempo e o custo da entrega.

Por exemplo, um entregador de moto possui uma velocidade maior do que um entregador de bicicleta.

---

### 🔹 5. Sobrecarga de Métodos
A sobrecarga foi utilizada no método `atualizarStatus()` da classe `Entrega`.

Foi criado:
- um método para atualizar apenas o status;
- outro método para atualizar o status junto com uma observação.

Isso permite atualizar o pedido de formas diferentes dependendo da situação.

---

### 🔹 6. Lógica do Sistema
O sistema permite:
- cadastrar entregadores;
- criar entregas;
- listar entregadores e entregas;
- atribuir entregas para entregadores;
- atualizar o status das entregas.

Também adicionamos validações para impedir:
- IDs repetidos de entregadores;
- IDs repetidos de entregas.

Além disso, o sistema possui diferentes tipos de status:
- Pendente
- Em rota
- Entregue
- Cancelada

---

### 📊 Diagrama UML

🔗 Link do diagrama:
([Canva]([https://www.canva.com/](https://canva.link/dw173k6tu8y0m9z)))

📷 Imagem do diagrama:
![Diagrama UML](<img width="1361" height="922" alt="Diagrama_UML" src="https://github.com/user-attachments/assets/0ea6f913-38f2-4445-9b37-8382553cf8f8" />)
