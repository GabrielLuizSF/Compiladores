# Gramática

## Introdução a Linguagens

- Letras
- Palavras
- Sentenças

- Nem todo conjunto de palavras é uma sentença válida
- Nem todo conjunto de letras forma uma palavra correta
- O mais importante é distinguir entre sentenças válidas e sequências inválidas;

### Em linguagens de Programação

- Certas strings são válidas(palavras reservadas) e quando agrupadas corretamente tornam-se em um código fonte que pode vir a ser um software que passou pelo processo de compilação sendo logo após convertidos em uma série de comandos em linguagem de máquina.

## O que é Gramática

- Formalmente, as gramáticas são definidas por quádruplas:

```haskell

G=(Vn, Vt, P, S)

```

- Vn: Conjunto de símbolos não-terminais  da gramática;
- Vt: Conjunto de símbolos terminais da gramática, os quais constituem as sentenças da linguagem;
- P: Regras de produção, responsáveis por produzir as sentenças de linguagem;
- S: Símbolo inicial da gramática, por onde se começa a derivação de sentenças.

### Exemplos:

```haskell

G = ({S, A, B},{a, b},P ,S)

P : S =>  AB
    A =>  a
    B =>  bB | b

```
----

```haskell

A => 0A | B
B => 1B | ɛ

```
- Cadeias

```haskell

ɛ, 0, 1
00, 01, 11
000, 101, 111

```
----

```haskell
 S =>  AB
 A =>  aaA | ɛ
 B =>  Bbb | ɛ

```

- Cadeias

```haskell

ɛ, aa, bb

```

----

```haskell

S => SS+ | SS* | a

```


- Derivação

```haskell

aa + a*

```

----

### Duas Gramáticas G1 e G2 são equivalentes se produzem a mesma linguagem:

```haskell

L(G1) = L(G2)

```

----

### Ambiguidade

```haskell

 S =>  aSbS | bSaS | ɛ

```


- Derivação

```haskell

abab
abab

```

----

### Classes de Gramáticas

- Conforme as restrições impostas ao formato das produções de uma gramática, a classe de linguagens que tal gramática gera varia correspondentemente;

- A teoria mostra que há quatro classes correspondentes de linguagens, de acordo com a denominada Hierarquia de Chomsky:

```c

// Gramáticas com estrutura de frase do Tipo 0

// Gramáticas sensíveis ao contexto ou Tipo 1

// Gramáticas livres de contexto ou Tipo 2

// Gramáticas regulares ou Tipo 3

```

### Hierarquia de Chomsky

- Classificação de gramáticas formais descrita em 1959 pelo linguista Noam Chomsky;

- Possui 4 níveis;
- Começa pelo tipo 0 com maior nível de liberdade em suas regras e aumentam as restrições Tipo 3.
- Níveis 2 e 3 são utilizados na descrição de linguagem de programação e na implementação de interpretadores e compiladores;

#### Nível 2

- Análise Sintática

#### Nível 3

- Análise Léxica