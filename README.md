# ⚔️ A Batalha Tática das Casas de Westeros ⚔️

![Java](https://img.shields.io/badge/Java-JDK_21-blue.svg?logo=openjdk)
![Maven](https://img.shields.io/badge/Maven-red.svg?logo=apachemaven)

Bem-vindo ao campo de batalha de Westeros! Este é um jogo de estratégia e combate tático por turnos, inspirado no universo de *Game of Thrones*, onde as grandes casas lutam pelo controle.

Este projeto foi desenvolvido como trabalho final para a disciplina de **Orientação a Objetos** do Departamento de Ciência da Computação (DCC) da Universidade Federal de Juiz de Fora (UFJF), sob orientação do Prof. Gleiph Ghiotto Lima de Menezes.

## 📜 Sobre o Jogo

O objetivo é simples: derrotar todos os personagens do time adversário. O jogo ocorre em um tabuleiro 10x10, onde cada jogador (Humano vs. Humano ou Humano vs. Bot) controla uma equipe de três personagens.

A cada turno, o jogador ativo escolhe um de seus personagens para se mover uma casa (ortogonal ou diagonal) e, em seguida, atacar um oponente que esteja dentro do seu alcance.

## ✨ Features Principais

* **Combate Tático em Turnos:** Planeje seus movimentos e ataques com cuidado.
* **Modos de Jogo:** Jogue contra um amigo (`Humano vs. Humano`) ou desafie a máquina (`Humano vs. Bot`).
* **Três Grandes Casas:** Escolha personagens das casas **Stark**, **Lannister** ou **Targaryen**.
* **Habilidades Únicas:** Cada casa possui atributos e modificadores de combate distintos.
* **Sistema de Replay:** Ao final da partida, assista a um replay completo de todas as jogadas!

## 🐺 As Casas 🦁

Cada casa possui um estilo de jogo único, baseado em seus atributos e modificadores:

> ### 🐺 **Casa Stark (Resistência)**
> * **Vida Máxima:** 60
> * **Alcance:** 1 (Corpo a Corpo)
> * **Modificador Defensivo:** Recebe **-20%** de dano em todos os ataques.

> ### 🦁 **Casa Lannister (Ofensivo/Tático)**
> * **Vida Máxima:** 50
> * **Alcance:** 2 (Padrão)
> * **Modificador Ofensivo:** Causa **+15%** de dano em todos os ataques.

> ### 🐉 **Casa Targaryen (Dano Ignorador)**
> * **Vida Máxima:** 45
> * **Alcance:** 3 (Distância)
> * **Modificador Ofensivo:** O ataque **ignora a defesa base** do alvo (Dano Bruto).

## 🚀 Tecnologias Utilizadas

* **Java (JDK 21)**
* **Maven** (para gerenciamento de dependências e build)

## ⚙️ Como Executar

1.  Certifique-se de ter o **JDK 21** e o **Maven** instalados e configurados corretamente em seu ambiente.
2.  Clone este repositório:
    ```bash
    git clone https://github.com/theocfaria/batalha-tatica.git
    ```
3.  Navegue até a pasta raiz do projeto e compile-o usando o Maven:
    ```bash
    mvn install
    ```
4.  Execute a classe `Main.java` (localizada em `src/main/java/Main.java`) a partir da sua IDE de preferência (IntelliJ, VSCode, Eclipse, etc.).

## 👨‍💻 Autores

Este projeto foi forjado nas terras de Westeros por:

| [![github.com/RyanPAlvim](https://img.shields.io/badge/GitHub-RyanPAlvim-181717?style=for-the-badge&logo=github)](https://github.com/RyanPAlvim) | [![github.com/theocfaria](https://img.shields.io/badge/GitHub-theocfaria-181717?style=for-the-badge&logo=github)](https://github.com/theocfaria) | [![github.com/Murilo19Dz9](https://img.shields.io/badge/GitHub-Murilo19Dz9-181717?style=for-the-badge&logo=github)](https://github.com/Murilo19Dz9) |
| :---: |:------------------------------------------------------------------------------------------------------------------------------------------------:| :---: |
| [Ryan Alvim](https://github.com/RyanPAlvim) |                                                   [Theo Faria](https://github.com/theocfaria)                                                    | [Murilo](https://github.com/Murilo19Dz9) |
